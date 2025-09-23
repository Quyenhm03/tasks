package com.example.tasks.task2.oop

import com.example.tasks.task2.oop.animal.Cat
import com.example.tasks.task2.oop.animal.Dog
import com.example.tasks.task2.oop.book.Book
import com.example.tasks.task2.oop.book.BookRepoImpl
import com.example.tasks.task2.oop.companionobject.MyClass
import com.example.tasks.task2.oop.customer.Customer
import com.example.tasks.task2.oop.customer.CustomerRepoImpl
import com.example.tasks.task2.oop.singleton.SingletonCompanion
import com.example.tasks.task2.oop.singleton.SingletonKotlin
import com.example.tasks.task2.oop.singleton.SingletonLazy
import com.example.tasks.task2.oop.student.Student

/*
    6. Lập trình hướng đối tượng (OOP) trong Kotlin
        Class & Object
        Constructor (Primary & Secondary)
        Kế thừa (open class, override)
        Interface & Abstract Class
        Data Class
        Singleton & Companion Object
 */

fun main() {
    // class
    val student = Student()
    student.name = "Nguyen Thi Quyen"
    student.age = 22
    student.major = "Information Technology"
    student.showInfo()

    // data class
    val book = Book("Kotlin Programming", "abc", "2025")
    println(book)

    // Constructor (Primary & Secondary)
    val customer = Customer("abcd@gmail.com")
    customer.showInfoCustomer()

    // abstract class
    val bookRepoImpl = BookRepoImpl()
    bookRepoImpl.selectBookById()

    // interface
    val customerRepoImpl = CustomerRepoImpl()
    customerRepoImpl.selectCustomerById1("1")

    // Inheritance
    val dog = Dog()
    dog.talk()

    val cat = Cat("Cat")
    cat.talk()

    // singleton(object) & companion Object (static)
    // 1. singleton with object
    println(SingletonKotlin.name)
    println(SingletonKotlin.doSonething())

    //2. singleton with companion object
    demoSingletonWithCompanionObject()

    //3. singleton with lazy
    demoSingletonWithLazy()

    val pi = MyClass.PI
    println(pi)
    MyClass.showInfo()
}

fun demoSingletonWithCompanionObject() {
    println("Demo singleton with companion object: ")
    val singleton1 = SingletonCompanion.getInstance()
    println("Initial info: ${singleton1.getInfo()}")

    val singleton2 = SingletonCompanion.getInstance()
    singleton2.setInfo("New class info") // Update info

    println("Updated info from singleton1: ${singleton1.getInfo()}")
    println("Updated info from singleton2: ${singleton2.getInfo()}")
}

fun demoSingletonWithLazy() {
    println("Demo singleton with companion lazy: ")

    val singleton1 = SingletonLazy.instance
    println("Initial info: ${singleton1.getInfo()}")

    val singleton2 = SingletonLazy.instance
    singleton2.setInfo("New class info") // Update info

    println("Updated info from singleton1: ${singleton1.getInfo()}")
    println("Updated info from singleton2: ${singleton2.getInfo()}")
}