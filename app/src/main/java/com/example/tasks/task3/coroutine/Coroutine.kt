package com.example.tasks.task3.coroutine

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

/*
    8. Coroutine (Lập trình bất đồng bộ)
        Suspend Function (suspend fun fetchData())
        Launch & Async
        Dispatcher (Dispatchers.Main, Dispatchers.IO)
        Scope (GlobalScope, CoroutineScope)
 */
fun main() {
//    demoLaunch()
//    demoAsync()
//    demoWithContext()
//    demoCoroutineScope()
//    demoException()
}

suspend fun fetchUser(id: Int) : User {
    val result = GlobalScope.async (Dispatchers.IO) {
        delay(2000L)
        User(id, "Nguyen Van A")
    }
    return result.await()
}

fun showUsers(user1: User, user2: User) {
    println("$user1 - $user2")
}

fun demoLaunch() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello ")
    Thread.sleep(2000L)
}

fun demoAsync() {
    println("=== Demo Async ===")
    val time = measureTimeMillis {
        runBlocking {
            launch {
                println("Start job on ${Thread.currentThread().name}")

                val userOne = async {
                    fetchUser(1)
                }
                val userTwo = async {
                    fetchUser(2)
                }

                // not waiting async results
                println("End job")
                // waiting async results
                showUsers(userOne.await(), userTwo.await())
            }
        }
    }
    println("Demo Async took $time ms")
}

fun demoWithContext() {
    println("=== Demo WithContext ===")
    val time = measureTimeMillis {
        runBlocking {
            launch {
                println("Start job on ${Thread.currentThread().name}")

                val userOne = withContext(Dispatchers.IO) {
                    fetchUser(1)
                }
                val userTwo = withContext(Dispatchers.IO) {
                    fetchUser(2)
                }

                // after all withContext calls complete
                println("End job")
                showUsers(userOne, userTwo)
            }
        }
    }
    println("Demo WithContext took $time ms")
}

fun demoCoroutineScope() {
    val customScope = CoroutineScope(Job() + Dispatchers.Default)
    customScope.launch {
        println("Run on ${Thread.currentThread().name}")
        val user = fetchUser(1)
        println(user)
    }
    Thread.sleep(3000L)
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

fun nomalFunction() {
    Thread.sleep(2000L)
}

suspend fun suspendFunc() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello ")
    Thread.sleep(2000L)
}

fun test() {

}