package com.paperatus.matrix.client.model

data class LedMatrix(val width: Int, val height: Int) {
    private val data = Array(width * height) {
        Color(0, 0, 0)
    }

    val int: IntArray
        get() = IntArray(data.size) { i -> data[i].int() }

    operator fun get(row: Int, col: Int): Color {
        return data[width * row + col]
    }

    operator fun set(row: Int, col: Int, color: Color) {
        data[width * row + col] = color
    }
}

