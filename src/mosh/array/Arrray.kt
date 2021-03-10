package mosh.array

class Arrray(val size: Int) {
    private var arr = IntArray(size)

    fun max(): Int? {
        if (arr.isEmpty())
            return null
        arr.max()
        var max = arr[0]
        for (i in arr)
            if (i > max) max = i

        return max
    }

    fun intersect(array: IntArray): IntArray {
        var commonItems = mutableListOf<Int>()
        arr.forEachIndexed { index, i ->
            for (j in array)
                if (j == i) commonItems.add(i)
        }
        return commonItems.toIntArray()
    }

}