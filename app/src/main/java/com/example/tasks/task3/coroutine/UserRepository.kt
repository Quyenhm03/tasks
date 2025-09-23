package com.example.tasks.task3.coroutine

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUser(id: Int): User {
        delay(1000)
        println("Fetched User $id on thread: ${Thread.currentThread().name}")
        return User(id, "User-$id")
    }

}