package mosh.array

import java.util.*
import kotlin.Array

class TwoDArrayDs {
    // Complete the hourglassSum function below.
    fun hourglassSum(arr: Array<kotlin.Array<Int>>): Int {

        var sum = -63

        arr.forEachIndexed { rowIdx, column ->
            if (rowIdx > 0 && rowIdx < arr.size - 1) {

                val prevRow = arr[rowIdx - 1];
                val nextRow = arr[rowIdx + 1];

                column.forEachIndexed { columnIdx, cell ->
                    if (columnIdx > 0 && columnIdx < column.size - 1) {

                        val temSum = cell + prevRow[columnIdx - 1] + prevRow[columnIdx] + prevRow[columnIdx + 1] + nextRow[columnIdx - 1] + nextRow[columnIdx] + nextRow[columnIdx + 1]
                        if (temSum > sum) sum = temSum
                    }
                }
            }
        }
        return sum
    }


    fun main(args: kotlin.Array<String>) {
        val arr = Array<kotlin.Array<Int>>(6, { Array<Int>(6, { 0 }) })

        for (k in 0..100) {
            for (i in 0..5) {
                arr[i] = arrayOf(rand(), rand(), rand(), rand(), rand(), rand())
            }

            arr.forEach {
                it.forEach { print("$it,") }
                println()
            }

            val result = hourglassSum(arr)

            println("result:" + result)
            println("**********************************")
        }


    }

    fun rand(): Int = if (Random().nextBoolean()) Random().nextInt(9) else Random().nextInt(9) * -1
}