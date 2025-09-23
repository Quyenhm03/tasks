package com.example.tasks.task1

/*
    3. Collection (Danh sách dữ liệu)
    List (Danh sách)
    Set (Tập hợp không trùng lặp)
    Map (Dạng key-value)
    Các hàm quan trọng trong Collection
    map(), filter(), reduce(), forEach(), first(), last(), ...
 */
fun main() {
    demoList()
    demoSet()
    demoMap()
    demoCollectionFunction()
}

fun demoList() {
    // immutable list
    val list1 = listOf(1, 2, 3, 4)
    println(list1)
    println(list1.reversed())

    // mutable list
    val list2 = mutableListOf(1, 2, 3, 4)
    list2.add(5)
    println(list2)

    println("First element of list2: ${list2.first()}")
    println("Last element of list2: ${list2.last()}")

    list2.sortDescending()
    println(list2)

    val list3 = list2.filter { it > 2 }
    println(list3)

    val sum = list2.reduce { acc, i -> acc + i }
    println("Sum of list2: $sum")

}

fun demoSet() {
    val num = setOf(1 ,2, 2, 4, 3, 6, 7, 8, 5)
    println("The number of element: " + num.count())
    println("Max value: " + num.max())
    println("Min value: " + num.min())
    println("Sum in set: " + num.sum())
    println("Average in set: " + num.average())

    println("The set contains 10? ${num.contains(10)}")

    print("Set: ")
    num.forEach { print("$it ") }
    println()
}

fun demoMap() {
    val map = mapOf(1 to "One", 2 to "Two" , 3 to "Three", 4 to "Four")
    println(map)
    println("Map Keys: " + map.keys )
    println("Map Values: " + map.values )

    val filteredMap = map.filter { it.key % 2 == 0 }
    println("Filtered map: $filteredMap")

    val num = 5
    println("Map contain key $num: " + map.containsKey(5))
}

fun demoCollectionFunction() {
    val list = listOf(1, 5, 6, 3, 8)

    // aggregate functions
    println("List has 3: " + list.any{ it == 3})
    println("All element of list %2 == 0: " + list.all{ it % 2 == 0})
    println("List has " + list.count { it % 3 == 0 } + "element %3 == 0")

    val sum1 = list.fold(0) {
        total, i ->  total + i
    }
    println("Sum list use fold: $sum1")

    val sum2 = list.reduce { total, i ->
        total + i
    }
    println("Sum list use reduce: $sum2")

    val sum3 = list.sumBy {
        it % 2
    }
    println("Sum of element % 2: $sum3")

    print("List use forEach: ")
    list.forEach {
        print("$it ")
    }
    println()

    println("List use forEach: ")
    list.forEachIndexed { index, value ->
        println("position $index: $value")
    }

    println("Max element: " + list.max())
    println("Min element: " + list.min())
    println("List hasn't element greater than 10: " + list.none { it > 10 })

    // filter functions
    println("Drop 2 element: " + list.drop(2))
    println("Drop while result: " + list.dropWhile { it < 5 })
    println("Drop last while result: " + list.dropLastWhile { it < 5 })
    println("Filter result: " + list.filter { it - 2 > 0 })
    println("Filter not result: " + list.filterNot { it > 2 })
    println("Slice result: " + list.slice(listOf(0, 2, 3)))
    println("Take result: " + list.take(3))
    println("Take while result: " + list.takeLast(3))
    println("Take last while result: " + list.takeWhile { it < 5 })

    // conversion functions
    val listFlatMap = list.flatMap { listOf(it, it +1) }
    println("Flat map result: $listFlatMap")

    val listGroupBy = list.groupBy {
        if(it % 2 == 0) {
            "even"
        } else {
            "odd"
        }
    }
    println("Group by result: " + listGroupBy)

    val listMap = list.map {
        it * 2
    }
    println("Map result: " + listMap)

    // element functions
    println("List contains 1: " + list.contains(1))
    println("Element at 2: " + list.elementAt(2))
    println("Element at 10: " + list.elementAtOrNull(10))
    println("First element greater than 5: " + list.first{ it > 5 })
    println("Index of 3 in list: " + list.indexOf(3))
    println("Last element greater than 5: " + list.last{ it > 5 })
    println("Unique element pass condition: " + list.single { it % 5 == 0 })

    // generate functions
    println("Partition result: " + list.partition { it % 2 == 0 })

    val listNum = listOf(1, 2, 3)
    val listStr = listOf("one", "two", "three", "four")
    println("Plus result: " + listNum.plus(listStr))
    println("Zip result: " + listNum.zip(listStr))

    // functions work with order
    println("List reverse: " + list.reversed())
    println("List sorted: " + list.sorted())
    println("List sorted by: " + list.sortedBy{ it % 3 == 0})
    println("List sorted descending: " + list.sortedDescending())
    println("List sorted by descending: " + list.sortedByDescending{ it % 3 == 0})

    // work with 2 list
    val list1 = listOf(2, 3, 5, 7)
    println("Plus result: " + list.plus(list1))
    println("Union result: " + list.union(list1))
    println("Intersct result: " + list.intersect(list1))

    // mixed collection function
    val listRes1 = list.map {
        it * 2
    }. filter {
        it > 5
    }. sorted()
    println("Mixed function result1: " + listRes1)
}
