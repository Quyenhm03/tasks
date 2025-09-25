package com.example.tasks.task3.enumsealedclass

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