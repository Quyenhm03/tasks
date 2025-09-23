package com.example.tasks.task1

/*
    2. Cấu trúc điều kiện và vòng lặp
    If - Else
    When (Thay thế switch-case trong Java)
    For Loop (for (i in 1..10) { }) (có bao nhiêu loại for)
    While & Do-While Loop
    ...
 */
fun main() {
    demoCondition()
    demoWhen(3)
    demoLoop()
    demoWhile()
}

fun demoCondition() {
    val a = 100
    val b = 200
    if(a > b) {
        println("Number $a is larger than $b")
    } else {
        println("Number $b is larger than $a")
    }
}

fun demoWhen(month: Int) {
    when(month) {
        in 1..3 -> println("Spring")
        in 4..6 -> println("Summer")
        in 7..9 -> println("Autumn")
        in 10..12 -> println("Winter")
        else -> println("Invalid month")
    }
}

fun demoLoop() {
    print("Even number: ")
    for (i in 0..9 step 2) {
        print("$i ")
    }
    println()

    for (i in 0..<10) {
        print("$i ")
    }
    println()

    print("Odd number: ")
    for (i in 9 downTo 0 step 2) {
        print("$i ")
    }
    println()

    val list = listOf(1, 2, 3)
    for(i in list.indices) {
        print("${list[i]} ")
    }
    println()

    val language = arrayOf("kotlin","java","c#","python")
    for ((index,value) in language.withIndex()) {
        println("Index in array $index has value: $value")
    }

    val str = "Hello"
    for(i in str)
        print("$i ")
    println()

    // break, break custom
    println("Demo break: ")
    for (i in 1..2) {
        for (j in 1..2) {
            println("i = $i <=> j = $j")
            if (j > i) {
                break
            }
        }
        println("i = $i")
    }

    println("Demo break custom: ")
    loop@ for (i in 1..3) {
        for (j in 1.. 3) {
            println("i = $i <=> j = $j")
            if (j > i) {
                break@loop
            }
        }
        println("i = $i")
    }

    // continue
    print("Demo continue: ")
    for(i in 0 until 10) {
        if( i.rem(2) == 0) {
            continue
        }
        print("$i ")
    }
    println()
}

fun demoWhile() {
    // while
    var count = 1

    println("Demo while: ")
    while(count <= 10) {
        print("$count ")
        count++
    }
    count--
    println()

    // do - while
    println("Demo do-while: ")
    do {
        print("$count ")
        count--
    } while(count >= 11)
}