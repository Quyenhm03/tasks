package com.example.tasks.task3

fun main() {
    demoReflectClass()
    demoReflectFunction()
}

class Student(var name: String = "Nguyen Van A", var age: Int = 18)

fun demoReflectClass() {
    val student1 = Student::class
    println("Qualified name: ${student1.qualifiedName}")
    println("Data class: ${student1.isData}")
    println("Companion object: ${student1.isCompanion}")
    println("Abstract class: ${student1.isAbstract}")
    println("Final class: ${student1.isFinal}")
    println("Sealed class: ${student1.isSealed}")
}

fun isPositiveNumber(x: Int) = x >= 0
fun isPositiveNumber(s: String ) = s == "abc" || s == "def"

class Person(val name: String)

fun<A, B, C> compose(f: (B) -> C, g: (A) -> B) : (A) -> C {
    return { x -> f(g(x))}
}

fun isEven(x: Int) = (x % 2 == 0)
fun length(s: String) = s.length

fun demoReflectFunction() {
    val numbers = listOf(-5, 0, 8, 6, -3, 2)
    println(numbers.filter(::isPositiveNumber).sorted())

    val predicate: (String) -> Boolean = ::isPositiveNumber
    println(predicate("abc"))

    val numberRegex = "\\d+".toRegex()
    val strNum = listOf("abc", "d21", "639")
    println(strNum.filter(numberRegex::matches))

    val p1: (String) -> Person = ::Person
    println(p1("Nguyen Van B").name)

    val listStr = listOf("ntq", "d21cnpm", "haizz", "jvbert")
    val evenLength = compose(::isEven, ::length)
    println(listStr.filter(evenLength))
}