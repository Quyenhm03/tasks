package com.example.tasks.task2

/*
    5. Null Safety (An toàn với null)
        Nullable (?) và Non-nullable
        Elvis Operator (?:)
        Safe Call (?.)
        Not-null Assertion (!!)
 */
fun main() {
    demoNullSafety()
}

fun demoNullSafety() {
    // nullable
    var s1: String? = "Hello"
    s1 = null
    println(s1)

    // safe call
    val s2: String?= "abc"
    println(s1?.length)
    println(s2?.toUpperCase())

    // Not-null assertion
//    println(s1!!.toUpperCase()) exception
    println(s2!!.length)

    // elvis call
    val name1 = s1 ?: "Unknown"
    val name2 = s2 ?: "Default"
    println(name1)
    println(name2)
}