package com.example.tasks.task2.oop.animal

class Cat : Animal {
    constructor(name: String) : super(name)

    init{
        this.name = "Cat"
    }

    override fun talk() {
        println("Meo meo")
    }
}