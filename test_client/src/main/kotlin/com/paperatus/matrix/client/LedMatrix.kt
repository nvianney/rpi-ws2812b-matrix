package com.paperatus.matrix.client

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

data class Color(val r: Int, val g: Int, val b: Int) {
    constructor(int: Int) : this(
        ((int shr 16) and 0xFF),
        ((int shr 8) and 0xFF),
        ((int shr 0) and 0xFF)
    )

    fun int(): Int {
        return (r shl 16) or (g shl 8) or (b shl 0)
    }
}
