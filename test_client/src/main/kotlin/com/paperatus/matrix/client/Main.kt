package com.paperatus.matrix.client

import com.paperatus.matrix.client.model.Color
import com.paperatus.matrix.client.model.LedMapping
import com.paperatus.matrix.client.model.LedMatrix
import kotlinx.coroutines.delay

val mapping = LedMapping().also { mapping ->
    mapping[0, 0] = 60
    mapping[0, 1] = 61
    mapping[0, 2] = 62
    mapping[0, 3] = 63
    mapping[0, 4] = 64
    mapping[0, 5] = 65
    mapping[0, 6] = 66
    mapping[0, 7] = 67
    mapping[0, 8] = 68
    mapping[0, 9] = 69
    mapping[0, 10] = 70
    mapping[0, 11] = 71

    mapping[1, 0] = 59
    mapping[1, 1] = 58
    mapping[1, 2] = 57
    mapping[1, 3] = 56
    mapping[1, 4] = 55
    mapping[1, 5] = 54
    mapping[1, 6] = 53
    mapping[1, 7] = 52
    mapping[1, 8] = 51
    mapping[1, 9] = 50
    mapping[1, 10] = 49
    mapping[1, 11] = 48

    mapping[2, 0] = 36
    mapping[2, 1] = 37
    mapping[2, 2] = 38
    mapping[2, 3] = 39
    mapping[2, 4] = 40
    mapping[2, 5] = 41
    mapping[2, 6] = 42
    mapping[2, 7] = 43
    mapping[2, 8] = 44
    mapping[2, 9] = 45
    mapping[2, 10] = 46
    mapping[2, 11] = 47

    mapping[3, 0] = 35
    mapping[3, 1] = 34
    mapping[3, 2] = 33
    mapping[3, 3] = 32
    mapping[3, 4] = 31
    mapping[3, 5] = 30
    mapping[3, 6] = 29
    mapping[3, 7] = 28
    mapping[3, 8] = 27
    mapping[3, 9] = 26
    mapping[3, 10] = 25
    mapping[3, 11] = 24

    mapping[4, 0] = 12
    mapping[4, 1] = 13
    mapping[4, 2] = 14
    mapping[4, 3] = 15
    mapping[4, 4] = 16
    mapping[4, 5] = 17
    mapping[4, 6] = 18
    mapping[4, 7] = 19
    mapping[4, 8] = 20
    mapping[4, 9] = 21
    mapping[4, 10] = 22
    mapping[4, 11] = 23

    mapping[5, 0] = 11
    mapping[5, 1] = 10
    mapping[5, 2] = 9
    mapping[5, 3] = 8
    mapping[5, 4] = 7
    mapping[5, 5] = 6
    mapping[5, 6] = 5
    mapping[5, 7] = 4
    mapping[5, 8] = 3
    mapping[5, 9] = 2
    mapping[5, 10] = 1
    mapping[5, 11] = 0
}

suspend fun LedControlClient.test1(matrix: LedMatrix) {

    var time = 0.0f
    var delta = 0.0f
    var col = 0

    val update = 0.05f

    while (true) {
        matrix.clear()

        val color = java.awt.Color.HSBtoRGB(time / 5.0f, 1.0f, 1.0f)
        val co = Color(color)
        for (r in 0 until 6) {
            matrix[r, col] = co
        }

        sendLedMatrix(matrix)
        delay((update * 1000).toLong())
        time += update

        delta += update


        if (delta >= 0.5f) {
            delta = 0.0f
        }
        col++
        col %= 12
    }
}

suspend fun LedControlClient.test2(matrix: LedMatrix) {

    var time = 0.0f
    var delta = 0.0f
    var idx = 0

    val update = 0.1f

    while (true) {
        matrix.clear()

        val color = java.awt.Color.HSBtoRGB(time / 5.0f, 1.0f, 1.0f)
        val co = Color(color)

        val r = idx / 12
        val c = idx % 12
        matrix[r, c] = co

        sendLedMatrix(matrix)
        delay((update * 1000).toLong())
        time += update

        delta += update

        if (delta >= 0.1f) {
            idx++
            idx %= 12 * 6
            delta = 0.0f
        }
    }
}

suspend fun main(array: Array<String>) {
    val matrix = LedMatrix(12, 6)

    LedControlClient("192.168.0.171", 50051).use { client ->
        client.initialize(matrix, mapping)
        client.test2(matrix)
//        matrix[4, 11] = Color(0xFFFFFF.toInt())
        client.sendLedMatrix(matrix)
    }
}