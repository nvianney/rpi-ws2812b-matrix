package com.paperatus.matrix.client

import com.paperatus.matrix.client.model.Color
import com.paperatus.matrix.client.model.LedMapping
import com.paperatus.matrix.client.model.LedMatrix
import kotlinx.coroutines.delay

val mapping = LedMapping().also { mapping ->
    mapping[0, 0] = 0
    mapping[0, 1] = 1
    mapping[0, 2] = 2
    mapping[0, 3] = 3
    mapping[0, 4] = 4
    mapping[0, 5] = 5
    mapping[0, 6] = 6
    mapping[0, 7] = 7
    mapping[0, 8] = 8
    mapping[0, 9] = 9
    mapping[0, 10] = 10
    mapping[0, 11] = 11

    mapping[1, 0] = 23
    mapping[1, 1] = 22
    mapping[1, 2] = 21
    mapping[1, 3] = 20
    mapping[1, 4] = 19
    mapping[1, 5] = 18
    mapping[1, 6] = 17
    mapping[1, 7] = 16
    mapping[1, 8] = 15
    mapping[1, 9] = 14
    mapping[1, 10] = 13
    mapping[1, 11] = 12

    mapping[2, 0] = 24
    mapping[2, 1] = 25
    mapping[2, 2] = 26
    mapping[2, 3] = 27
    mapping[2, 4] = 28
    mapping[2, 5] = 29
    mapping[2, 6] = 30
    mapping[2, 7] = 31
    mapping[2, 8] = 32
    mapping[2, 9] = 33
    mapping[2, 10] = 34
    mapping[2, 11] = 35

    mapping[3, 0] = 47
    mapping[3, 1] = 46
    mapping[3, 2] = 45
    mapping[3, 3] = 44
    mapping[3, 4] = 43
    mapping[3, 5] = 42
    mapping[3, 6] = 41
    mapping[3, 7] = 40
    mapping[3, 8] = 39
    mapping[3, 9] = 38
    mapping[3, 10] = 37
    mapping[3, 11] = 36

    mapping[4, 0] = 48
    mapping[4, 1] = 49
    mapping[4, 2] = 50
    mapping[4, 3] = 51
    mapping[4, 4] = 52
    mapping[4, 5] = 53
    mapping[4, 6] = 54
    mapping[4, 7] = 55
    mapping[4, 8] = 56
    mapping[4, 9] = 57
    mapping[4, 10] = 58
    mapping[4, 11] = 59

    mapping[5, 0] = 71
    mapping[5, 1] = 70
    mapping[5, 2] = 69
    mapping[5, 3] = 68
    mapping[5, 4] = 67
    mapping[5, 5] = 66
    mapping[5, 6] = 65
    mapping[5, 7] = 64
    mapping[5, 8] = 62
    mapping[5, 9] = 62
    mapping[5, 10] = 61
    mapping[5, 11] = 60
}


suspend fun main(array: Array<String>) {
    val matrix = LedMatrix(12, 6)

    LedControlClient("192.168.0.232", 50051).use { client ->
        with(client) {
            initialize(matrix, mapping)

            var time = 0.0f
            var col = 0

            while (true) {
                matrix.clear()

                val color = java.awt.Color.HSBtoRGB(time / 5.0f, 1.0f, 1.0f)
                val co = Color(color)
                for (r in 0 until 6) {
                    matrix[r, col] = co
                }

                sendLedMatrix(matrix)
                delay(20)
                time += 0.2f
                col++

                col %= 12;
            }
        }
    }
}