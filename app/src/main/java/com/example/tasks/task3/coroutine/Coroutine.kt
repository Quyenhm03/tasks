package com.example.tasks.task3.coroutine

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.cancellation.CancellationException
import kotlin.system.measureTimeMillis

/*
    8. Coroutine (Lập trình bất đồng bộ)
        Suspend Function (suspend fun fetchData())
        Launch & Async
        Dispatcher (Dispatchers.Main, Dispatchers.IO)
        Scope (GlobalScope, CoroutineScope)
 */
suspend fun main() {
    val userRepo = UserRepository()

    demoLaunch(userRepo)
    demoAsync(userRepo)
    demoCoroutineScopeCancel(userRepo)
    demoGlobalScope(userRepo)
    demoException()
}

fun showUsers(user1: User, user2: User) {
    println("$user1 - $user2")
}

suspend fun demoLaunch(userRepo: UserRepository) = coroutineScope {
    println("Starting demo on thread: ${Thread.currentThread().name}")

    launch {
        val user1 = userRepo.getUser(1)
        println("Got $user1 on thread: ${Thread.currentThread().name}")
    }

    val customScope = CoroutineScope(Dispatchers.IO)
    customScope.launch {
        val user2 = userRepo.getUser(2)
        println("Got $user2 on thread: ${Thread.currentThread().name}")
    }

    println("Demo completed on thread: ${Thread.currentThread().name}")
}

suspend fun demoAsync(userRepo: UserRepository) = coroutineScope {
    val time = measureTimeMillis {
        val user1 = async {
            userRepo.getUser(1)
        }
        val user2 = async {
            userRepo.getUser(2)
        }

        showUsers(user1.await(), user2.await())
    }

    println("Completed in $time ms")
}

suspend fun demoCoroutineScopeCancel(userRepo: UserRepository) = coroutineScope {
    val jobParent = launch {
        launch {
            delay(100)
            println("Child of the jobParent coroutine")

            val user = userRepo.getUser(4)
            println("Got $user in child coroutine on thread: ${Thread.currentThread().name}")
            delay(1000)
            println("jobChildren will not execute this line if my parent request is cancelled")
        }
    }
    delay(1000)
    jobParent.cancel()
    println("Parent coroutine cancelled")
}

suspend fun demoGlobalScope(userRepo: UserRepository) = coroutineScope {
    val jobParent = launch {
        GlobalScope.launch {
            delay(100)
            println("job1: GlobalScope and execute independently!")

            val user = userRepo.getUser(4)
            println("Got $user in child coroutine on thread: ${Thread.currentThread().name}")
        }

        launch {
            delay(100)
            println("job2: Child of the request coroutine")
            delay(1000)
            println("job2 will not execute this line if jobParent is cancelled")
        }
    }
    delay(500)
    jobParent.cancel()
    delay(2000)
}

val handler = CoroutineExceptionHandler {
    _, exp -> println("Error: ${exp.toString()}")
}

fun funWithExceptionAsync() : Int {
    return 10 / (0..1).random()
}

fun funWithException() : Nothing {
    throw Exception("Exception")
}

fun demoException() = runBlocking {
    println("Exception use handler: ")
    val job1 = GlobalScope.launch(handler) {
        delay(1000)
        funWithException()
    }

    job1.join()

    println("Exception try-catch: ")
    val job2 = GlobalScope.launch {
        try {
            delay(1000)
            val result = async {
                funWithExceptionAsync()
            }.await()
            println("Result: $result")
        } catch (e: Exception) {
            println(e.toString())
        }
    }

    job2.join()
}

