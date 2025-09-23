package com.example.tasks.task2.oop.singleton

class SingletonLazy private constructor() {

    private var info: String = "Singleton Companion"

    fun getInfo(): String = info
    fun setInfo(newInfo: String) {
        info = newInfo
    }

    companion object {
        val instance: SingletonLazy by lazy {
            SingletonLazy()
        }
    }

}
