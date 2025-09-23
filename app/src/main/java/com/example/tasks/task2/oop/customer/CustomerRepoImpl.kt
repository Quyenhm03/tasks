package com.example.tasks.task2.oop.customer

class CustomerRepoImpl : ICustomerRepo1, ICustomerRepo2 {
    override fun selectCustomerById1(userId: String) {
        super.selectCustomerById1(userId)
        println("Call inside class")
    }

    override fun selectCustomerById2(userId: String) {
    }
}