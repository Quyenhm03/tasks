package com.example.tasks.task3.enumsealedclass

enum class Weekday {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    fun isWeekend(): Boolean {
        return this == SATURDAY || this == SUNDAY
    }
}