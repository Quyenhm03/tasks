package com.example.tasks.task3

fun main() {
    demoLambdaWithReceiver()
    demoInfixFunction()
    demoExtensionFunction()
}

data class Employee(var name: String = "", var age: Int = 0, var salary: Double = 0.0)

fun employee(lambda: Employee.() -> Unit) : Employee {
    val employee = Employee()
    employee.lambda()
    return employee
}

fun demoLambdaWithReceiver() {
    val employee = employee {
        name = "Nguyen Van A"
        age = 20
    }
    println("${employee.name} - ${employee.age}")
}

infix fun Employee.addSalary(salary: Double) {
    this.salary += salary
}

fun demoInfixFunction() {
    val employee = Employee()
    employee addSalary 10000.0
    println("${employee.salary}")
}

data class Address(var street: String = "", var city: String = "")

fun Employee.address(lambda: Address.() -> Unit) {
    val address = Address()
    address.lambda()
    println("Address: ${address.street}, ${address.city}")
}

fun Employee.setName(name: String) {
    this.name =  name
}

fun demoExtensionFunction() {
    val employee = employee {
        name = "Nguyen Van A"
        age = 20
        address {
            street = "Trang Thi Street"
            city = "Ha Noi"
        }
    }

    employee.setName("Nguyen Van B")
    println(employee.name)
}