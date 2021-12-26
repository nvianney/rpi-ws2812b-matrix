package com.paperatus.matrix.client

import com.google.protobuf.ByteString
import com.paperatus.matrix.proto.LedControlGrpcKt
import com.paperatus.matrix.proto.LedData
import com.paperatus.matrix.proto.ledData
import io.grpc.ManagedChannelBuilder
import java.io.Closeable
import java.util.concurrent.TimeUnit

class LedControlClient(address: String, port: Int) : Closeable {

    private val channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build()
    private val stub = LedControlGrpcKt.LedControlCoroutineStub(channel)

    private fun mapToByteArray(intArray: IntArray): ByteArray {
        val bytes = ByteArray(intArray.size * 4)
        // little endian
        intArray.forEachIndexed { index, i ->
            bytes[(index * 4) + 0] = (i shr 0).toByte() // msbs truncated
            bytes[(index * 4) + 1] = (i shr 8).toByte()
            bytes[(index * 4) + 2] = (i shr 16).toByte()
            bytes[(index * 4) + 3] = (i shr 24).toByte()
        }

        return bytes
    }

    suspend fun initialize(matrix: LedMatrix) {
        val request = matrix.asLedData()
        val response = stub.initialize(request)
    }

    suspend fun sendLedMatrix(matrix: LedMatrix) {
        val request = matrix.asLedData()
        val response = stub.writeData(request)
    }

    private fun LedMatrix.asLedData(): LedData {
        val matrix = this
        return ledData {
            data = ByteString.copyFrom(
                mapToByteArray(matrix.int)
            )
            width = matrix.width
            height = matrix.height
        }
    }

    override fun close() {
        channel.shutdown().awaitTermination(5000, TimeUnit.SECONDS)
    }
}