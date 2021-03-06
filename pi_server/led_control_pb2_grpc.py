# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

from google.protobuf import empty_pb2 as google_dot_protobuf_dot_empty__pb2
from google.protobuf import wrappers_pb2 as google_dot_protobuf_dot_wrappers__pb2
import led_control_pb2 as led__control__pb2


class LedControlStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.Initialize = channel.unary_unary(
                '/paperatus.LedControl/Initialize',
                request_serializer=led__control__pb2.Setup.SerializeToString,
                response_deserializer=google_dot_protobuf_dot_wrappers__pb2.BoolValue.FromString,
                )
        self.WriteData = channel.unary_unary(
                '/paperatus.LedControl/WriteData',
                request_serializer=led__control__pb2.LedData.SerializeToString,
                response_deserializer=google_dot_protobuf_dot_empty__pb2.Empty.FromString,
                )


class LedControlServicer(object):
    """Missing associated documentation comment in .proto file."""

    def Initialize(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def WriteData(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_LedControlServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'Initialize': grpc.unary_unary_rpc_method_handler(
                    servicer.Initialize,
                    request_deserializer=led__control__pb2.Setup.FromString,
                    response_serializer=google_dot_protobuf_dot_wrappers__pb2.BoolValue.SerializeToString,
            ),
            'WriteData': grpc.unary_unary_rpc_method_handler(
                    servicer.WriteData,
                    request_deserializer=led__control__pb2.LedData.FromString,
                    response_serializer=google_dot_protobuf_dot_empty__pb2.Empty.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'paperatus.LedControl', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class LedControl(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def Initialize(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/paperatus.LedControl/Initialize',
            led__control__pb2.Setup.SerializeToString,
            google_dot_protobuf_dot_wrappers__pb2.BoolValue.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def WriteData(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/paperatus.LedControl/WriteData',
            led__control__pb2.LedData.SerializeToString,
            google_dot_protobuf_dot_empty__pb2.Empty.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
