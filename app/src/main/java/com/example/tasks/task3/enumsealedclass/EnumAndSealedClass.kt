package com.example.tasks.task3.enumsealedclass

fun main() {
    demoEnum()
    demoSealedClass(APIResult.Success(200,"200 OK"))
    demoSealedClass(APIResult.Error("404 Not found"))
}

fun demoEnum() {
    val today = Weekday.THURSDAY
    println("Today is weekend: ${today.isWeekend()}")

    val red = Color.RED
    println(red)
    println(red.ordinal)

    for(item in Color.entries) {
        println("$item - value = ${item.showDetail()}")
    }
}

sealed class APIResult {
    data class Success(val data: Int, val msg: String) : APIResult()
    data class Error(val msg: String) : APIResult()
}

fun demoSealedClass(apiResult: APIResult) {
    when(apiResult) {
        is APIResult.Success -> {
            println("${apiResult.data} - ${apiResult.msg}")
        }
        is APIResult.Error -> {
            println(apiResult.msg)
        }
    }
}