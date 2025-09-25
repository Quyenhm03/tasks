package com.example.tasks.task3

/*
    7. Higher-Order Function & Lambda
        Hàm là tham số của hàm khác
        Lambda Expression ({ x, y -> x + y })
        Inline Function
        Higher-Order Function (fun operation(a: Int, b: Int, action: (Int, Int) -> Int))
 */
fun main() {
    demoFunctionIsParameter()
    demoLambdaExpression()

    // demo return a function
    println("Sum: ${demoReturnFunction()(6,3)}")

    demoInlineFunction()
}

fun demoFunctionIsParameter() {
    val result = calculate(5, 3, ::sum)
    // int result = calculate(5, 3, (Function2)null.INSTANCE);
    println("Sum: $result")
}

fun demoLambdaExpression() {
    val result1 = calculate(5, 3) { a, b : Int ->
        if (a > b) {
            a - b
        } else {
            b - a
        }
    }
    println("Subtract: $result1")

    val result2 = calculate(5, 3) {
        a, b -> a * b
    }
    println("Multiply: $result2")

    val lambda : (Int, Int) -> Double = {a, b -> (a / b).toDouble() }
    println("Division: ${lambda(5,3)}")
}

fun demoReturnFunction() : ((Int, Int) -> Int) {
    return ::sum
}

fun demoInlineFunction() {
    val result = sqrt(4.0) {
        x -> kotlin.math.sqrt(x)
    }
//    double x$iv = 4.0;
//    int $i$f$sqrt = false;
//    double x = x$iv;
//    int var7 = false;
//    double result = Math.sqrt(x);
    println("Sqrt: $result")
}

fun sum(a: Int, b: Int) = a + b

// higher-order function
fun calculate(a: Int, b: Int, func: (Int, Int) -> Int) : Int {
    return func(a,b)
}

inline fun sqrt(x: Double, func: (Double) -> Double) : Double {
    return func(x)
}