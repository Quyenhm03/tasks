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
    demoInlineFunction()
}

fun demoFunctionIsParameter() {
    val result = calculate(5, 3, ::sum)
    // int result = calculate(5, 3, (Function2)null.INSTANCE);
    println("Sum: $result")
}

fun demoLambdaExpression() {
    val result1 = calculate(5, 3) {
        a, b : Int -> a - b
    }
    println("Subtract: $result1")

    val result2 = calculate(5, 3) {
        a, b -> a * b
    }
    println("Multiply: $result2")
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