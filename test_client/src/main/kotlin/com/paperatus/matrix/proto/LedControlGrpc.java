package com.paperatus.matrix.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: led_control.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LedControlGrpc {

  private LedControlGrpc() {}

  public static final String SERVICE_NAME = "paperatus.LedControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.paperatus.matrix.proto.LedData,
      com.google.protobuf.BoolValue> getInitializeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Initialize",
      requestType = com.paperatus.matrix.proto.LedData.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.paperatus.matrix.proto.LedData,
      com.google.protobuf.BoolValue> getInitializeMethod() {
    io.grpc.MethodDescriptor<com.paperatus.matrix.proto.LedData, com.google.protobuf.BoolValue> getInitializeMethod;
    if ((getInitializeMethod = LedControlGrpc.getInitializeMethod) == null) {
      synchronized (LedControlGrpc.class) {
        if ((getInitializeMethod = LedControlGrpc.getInitializeMethod) == null) {
          LedControlGrpc.getInitializeMethod = getInitializeMethod =
              io.grpc.MethodDescriptor.<com.paperatus.matrix.proto.LedData, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Initialize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.paperatus.matrix.proto.LedData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new LedControlMethodDescriptorSupplier("Initialize"))
              .build();
        }
      }
    }
    return getInitializeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.paperatus.matrix.proto.LedData,
      com.google.protobuf.Empty> getWriteDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteData",
      requestType = com.paperatus.matrix.proto.LedData.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.paperatus.matrix.proto.LedData,
      com.google.protobuf.Empty> getWriteDataMethod() {
    io.grpc.MethodDescriptor<com.paperatus.matrix.proto.LedData, com.google.protobuf.Empty> getWriteDataMethod;
    if ((getWriteDataMethod = LedControlGrpc.getWriteDataMethod) == null) {
      synchronized (LedControlGrpc.class) {
        if ((getWriteDataMethod = LedControlGrpc.getWriteDataMethod) == null) {
          LedControlGrpc.getWriteDataMethod = getWriteDataMethod =
              io.grpc.MethodDescriptor.<com.paperatus.matrix.proto.LedData, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.paperatus.matrix.proto.LedData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new LedControlMethodDescriptorSupplier("WriteData"))
              .build();
        }
      }
    }
    return getWriteDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LedControlStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LedControlStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LedControlStub>() {
        @java.lang.Override
        public LedControlStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LedControlStub(channel, callOptions);
        }
      };
    return LedControlStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LedControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LedControlBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LedControlBlockingStub>() {
        @java.lang.Override
        public LedControlBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LedControlBlockingStub(channel, callOptions);
        }
      };
    return LedControlBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LedControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LedControlFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LedControlFutureStub>() {
        @java.lang.Override
        public LedControlFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LedControlFutureStub(channel, callOptions);
        }
      };
    return LedControlFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LedControlImplBase implements io.grpc.BindableService {

    /**
     */
    public void initialize(com.paperatus.matrix.proto.LedData request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInitializeMethod(), responseObserver);
    }

    /**
     */
    public void writeData(com.paperatus.matrix.proto.LedData request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInitializeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.paperatus.matrix.proto.LedData,
                com.google.protobuf.BoolValue>(
                  this, METHODID_INITIALIZE)))
          .addMethod(
            getWriteDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.paperatus.matrix.proto.LedData,
                com.google.protobuf.Empty>(
                  this, METHODID_WRITE_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class LedControlStub extends io.grpc.stub.AbstractAsyncStub<LedControlStub> {
    private LedControlStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LedControlStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LedControlStub(channel, callOptions);
    }

    /**
     */
    public void initialize(com.paperatus.matrix.proto.LedData request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitializeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeData(com.paperatus.matrix.proto.LedData request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LedControlBlockingStub extends io.grpc.stub.AbstractBlockingStub<LedControlBlockingStub> {
    private LedControlBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LedControlBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LedControlBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.BoolValue initialize(com.paperatus.matrix.proto.LedData request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitializeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty writeData(com.paperatus.matrix.proto.LedData request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LedControlFutureStub extends io.grpc.stub.AbstractFutureStub<LedControlFutureStub> {
    private LedControlFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LedControlFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LedControlFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> initialize(
        com.paperatus.matrix.proto.LedData request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitializeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> writeData(
        com.paperatus.matrix.proto.LedData request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INITIALIZE = 0;
  private static final int METHODID_WRITE_DATA = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LedControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LedControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INITIALIZE:
          serviceImpl.initialize((com.paperatus.matrix.proto.LedData) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_WRITE_DATA:
          serviceImpl.writeData((com.paperatus.matrix.proto.LedData) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LedControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LedControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.paperatus.matrix.proto.LedControlProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LedControl");
    }
  }

  private static final class LedControlFileDescriptorSupplier
      extends LedControlBaseDescriptorSupplier {
    LedControlFileDescriptorSupplier() {}
  }

  private static final class LedControlMethodDescriptorSupplier
      extends LedControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LedControlMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LedControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LedControlFileDescriptorSupplier())
              .addMethod(getInitializeMethod())
              .addMethod(getWriteDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
