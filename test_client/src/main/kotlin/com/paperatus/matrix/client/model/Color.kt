package com.paperatus.matrix.client.model

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