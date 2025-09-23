package com.example.tasks.task2.oop.customer

interface ICustomerRepo1 {
    fun selectCustomerById1(userId: String) {
        println("Call from interface")
    }
}
