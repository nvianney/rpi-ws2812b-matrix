package com.paperatus.matrix.client

import com.paperatus.matrix.client.model.Color
import com.paperatus.matrix.client.model.LedMapping
import com.paperatus.matrix.client.model.LedMatrix

suspend fun main(array: Array<String>) {
    val matrix = LedMatrix(5, 5)
    matrix[0, 0] = Color(255, 0, 0)
    val mapping = LedMapping()
    mapping[1, 1] = 5
    LedControlClient("localhost", 50051).use { client ->
        with(client) {
            initialize(matrix, mapping)
        }
    }
}