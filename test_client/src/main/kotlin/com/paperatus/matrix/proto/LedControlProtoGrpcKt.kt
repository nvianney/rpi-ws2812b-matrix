package com.paperatus.matrix.proto

import com.google.protobuf.BoolValue
import com.google.protobuf.Empty
import com.paperatus.matrix.proto.LedControlGrpc.getServiceDescriptor
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Holder for Kotlin coroutine-based client and server APIs for paperatus.LedControl.
 */
object LedControlGrpcKt {
  const val SERVICE_NAME: String = LedControlGrpc.SERVICE_NAME

  @JvmStatic
  val serviceDescriptor: ServiceDescriptor
    get() = LedControlGrpc.getServiceDescriptor()

  val initializeMethod: MethodDescriptor<LedData, BoolValue>
    @JvmStatic
    get() = LedControlGrpc.getInitializeMethod()

  val writeDataMethod: MethodDescriptor<LedData, Empty>
    @JvmStatic
    get() = LedControlGrpc.getWriteDataMethod()

  /**
   * A stub for issuing RPCs to a(n) paperatus.LedControl service as suspending coroutines.
   */
  @StubFor(LedControlGrpc::class)
  class LedControlCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT
  ) : AbstractCoroutineStub<LedControlCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): LedControlCoroutineStub =
        LedControlCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun initialize(request: LedData, headers: Metadata = Metadata()): BoolValue = unaryRpc(
      channel,
      LedControlGrpc.getInitializeMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun writeData(request: LedData, headers: Metadata = Metadata()): Empty = unaryRpc(
      channel,
      LedControlGrpc.getWriteDataMethod(),
      request,
      callOptions,
      headers
    )}

  /**
   * Skeletal implementation of the paperatus.LedControl service based on Kotlin coroutines.
   */
  abstract class LedControlCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for paperatus.LedControl.Initialize.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun initialize(request: LedData): BoolValue = throw
        StatusException(UNIMPLEMENTED.withDescription("Method paperatus.LedControl.Initialize is unimplemented"))

    /**
     * Returns the response to an RPC for paperatus.LedControl.WriteData.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun writeData(request: LedData): Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method paperatus.LedControl.WriteData is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = LedControlGrpc.getInitializeMethod(),
      implementation = ::initialize
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = LedControlGrpc.getWriteDataMethod(),
      implementation = ::writeData
    )).build()
  }
}
