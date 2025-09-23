package com.example.tasks.task2.oop.animal

class Dog : Animal() {
    init{
        this.name = "Dog"
    }

    override fun talk() {
        println("Gau gau")
    }
}