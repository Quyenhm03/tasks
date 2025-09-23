package com.example.tasks.task2.oop.singleton

class SingletonCompanion private constructor() {
    private var info: String = "Singleton Companion"

    fun getInfo(): String = info
    fun setInfo(newInfo: String) {
        info = newInfo
    }

    companion object {
        @Volatile
        private var instance: SingletonCompanion? = null

        fun getInstance(): SingletonCompanion = instance ?: synchronized(this) {
            instance ?: SingletonCompanion().also { instance = it }
        }
    }
}