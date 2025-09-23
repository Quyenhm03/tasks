package com.example.tasks.task2.oop.customer

class Customer (var name: String = "", var phone: String = "") {
    private var email: String = ""

    init {
        name = "abcd"
        phone = "0123456789"
    }

    constructor(email: String) : this() {
        this.email = email
    }

    fun showInfoCustomer() {
        println("Customer: $name, phone: $phone, email: $email")
    }
}