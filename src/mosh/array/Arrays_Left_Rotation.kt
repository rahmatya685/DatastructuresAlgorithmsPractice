package mosh.array

import kotlin.Array
import kotlin.collections.*
import kotlin.io.*

// Complete the mosh.array.rotLeft function below.
fun rotLeft(a: kotlin.Array<Int>, d: Int): kotlin.Array<Int> {

    val newArr = Array<Int>(a.size) { 0 }

    a.forEachIndexed { index, i ->

        val displacement = index - d

        if (displacement >= 0)
            newArr[displacement] = i
        else
            newArr[a.size + displacement] = i

    }
    return newArr
}

fun main(args: Array<String>) {

    val result = rotLeft(arrayOf(1, 2, 3, 5), 3)
    println(result.joinToString(" "))
}