package com.example.tasks.task3

fun main() {
    demoEnum()
    demoSealedClass(APIResult.Success(200,"200 OK"))
    demoSealedClass(APIResult.Error("404 Not found"))
}

fun demoEnum() {
    val red = Color.RED
    println(red)
    println(red.ordinal)

    for(item in Color.entries) {
        println("$item - value = ${item.showDetail()}")
    }
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0) {
        override fun showDetail(): String {
            return "r: $r, g: $g, b: $b"
        }
    },
    ORANGE(255, 165, 0) {
        override fun showDetail(): String {
            return "r: $r, g: $g, b: $b"
        }
    },
    BLUE(0, 0, 255) {
        override fun showDetail(): String {
            return "r: $r, g: $g, b: $b"
        }
    };

    abstract fun showDetail() : String
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

sealed class APIResult {
    data class Success(val data: Int, val msg: String) : APIResult()
    data class Error(val msg: String) : APIResult()
}