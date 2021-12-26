package com.paperatus.matrix.client.model

class LedMapping {
    private val data = hashMapOf<Pair<Int, Int>, Int>()

    val int: IntArray
        get() {
            val out = IntArray(data.size * 3)
            var index = 0

            data.forEach { (key, value) ->
                out[index++] = key.first
                out[index++] = key.second
                out[index++] = value
            }

            return out
        }

    operator fun get(row: Int, col: Int): Int {
        return data[row to col]!!
    }

    operator fun set(row: Int, col: Int, index: Int) {
        data[row to col] = index
    }
}