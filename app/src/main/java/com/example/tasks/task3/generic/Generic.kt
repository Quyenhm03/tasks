package com.example.tasks.task3.generic

import com.example.tasks.task3.generic.person.Father
import com.example.tasks.task3.generic.person.Son
import com.example.tasks.task3.generic.plant.Flower
import com.example.tasks.task3.generic.plant.Fruit

fun main() {
    demoGeneric()
    demoCovariance()
    demoContravariance()
}

class Repository<T> {
    fun insert(obj: T) {
        println("Insert ${obj.toString()}")
    }
}

fun <T> createInstance(obj: T) : T {
    return obj
}

fun demoGeneric() {
    val rose = Repository<Flower>()
    rose.insert(Flower())

    val fruit = Repository<Fruit>()
    fruit.insert(Fruit())

    val peachBlossom = createInstance(Flower("Peach blossom"))
    println(peachBlossom.toString())
}

class Person1<out T> (val value: T) {
    fun get() : T {
        return value
    }
}

fun demoCovariance() {
    val sonObject = Person1(Son("Nguyen Van A", 18))
    println("SonObject: ${sonObject.get()}")

    val fatherObject: Person1<Father>
    fatherObject = sonObject

    println("FatherObject: ${fatherObject.get()}")
}

class Person2<in T>

fun demoContravariance() {
    val fatherObject: Person2<Father> = Person2()
    println("FatherObject: ${fatherObject}")

    val sonObject: Person2<Son>
    sonObject = fatherObject
    println("SonObject: ${sonObject}")
}