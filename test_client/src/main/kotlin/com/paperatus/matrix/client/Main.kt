package com.paperatus.matrix.client

suspend fun main(array: Array<String>) {
    val matrix = LedMatrix(5, 5)
    matrix[0, 0] = Color(255, 0, 0)
    LedControlClient("localhost", 50051).use { client ->
        with(client) {
//            initialize(matrix)
            sendLedMatrix(matrix)
        }
    }
}