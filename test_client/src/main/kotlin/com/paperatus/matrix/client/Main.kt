package com.paperatus.matrix.client

import com.paperatus.matrix.client.model.Color
import com.paperatus.matrix.client.model.LedMapping
import com.paperatus.matrix.client.model.LedMatrix

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
}

suspend fun main(array: Array<String>) {
    val matrix = LedMatrix(12, 2)
    matrix[0, 0] = Color(255, 0, 255)
    matrix[1, 1] = Color(255, 127, 127)
    matrix[1, 11] = Color(0, 50, 127)

    LedControlClient("192.168.0.232", 50051).use { client ->
        with(client) {
            initialize(matrix, mapping)
        }
    }
}