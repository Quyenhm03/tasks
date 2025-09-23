package com.example.tasks.task3

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

data class Flower(val name: String = "Rose")
data class Fruit(val name: String = "Orange", val price: Double = 10.0)

fun demoGeneric() {
    val rose = Repository<Flower>()
    rose.insert(Flower())

    val fruit = Repository<Fruit>()
    fruit.insert(Fruit())

    val peachBlossom = createInstance(Flower("Peach blossom"))
    println(peachBlossom.toString())
}

open class Father(val name: String, val age: Int)
class Son(name: String, age: Int) : Father(name, age)

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