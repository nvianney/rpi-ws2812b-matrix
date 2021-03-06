# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: led_control.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


from google.protobuf import empty_pb2 as google_dot_protobuf_dot_empty__pb2
from google.protobuf import wrappers_pb2 as google_dot_protobuf_dot_wrappers__pb2


DESCRIPTOR = _descriptor.FileDescriptor(
  name='led_control.proto',
  package='paperatus',
  syntax='proto3',
  serialized_options=b'\n\032com.paperatus.matrix.protoB\017LedControlProtoP\001',
  create_key=_descriptor._internal_create_key,
  serialized_pb=b'\n\x11led_control.proto\x12\tpaperatus\x1a\x1bgoogle/protobuf/empty.proto\x1a\x1egoogle/protobuf/wrappers.proto\"6\n\x07LedData\x12\x0c\n\x04\x64\x61ta\x18\x01 \x03(\r\x12\r\n\x05width\x18\x02 \x01(\r\x12\x0e\n\x06height\x18\x03 \x01(\r\"Q\n\x05Setup\x12#\n\x07ledData\x18\x01 \x01(\x0b\x32\x12.paperatus.LedData\x12#\n\x07mapping\x18\x02 \x01(\x0b\x32\x12.paperatus.Mapping\"\x17\n\x07Mapping\x12\x0c\n\x04\x64\x61ta\x18\x01 \x03(\r2\x85\x01\n\nLedControl\x12<\n\nInitialize\x12\x10.paperatus.Setup\x1a\x1a.google.protobuf.BoolValue\"\x00\x12\x39\n\tWriteData\x12\x12.paperatus.LedData\x1a\x16.google.protobuf.Empty\"\x00\x42/\n\x1a\x63om.paperatus.matrix.protoB\x0fLedControlProtoP\x01\x62\x06proto3'
  ,
  dependencies=[google_dot_protobuf_dot_empty__pb2.DESCRIPTOR,google_dot_protobuf_dot_wrappers__pb2.DESCRIPTOR,])




_LEDDATA = _descriptor.Descriptor(
  name='LedData',
  full_name='paperatus.LedData',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='data', full_name='paperatus.LedData.data', index=0,
      number=1, type=13, cpp_type=3, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='width', full_name='paperatus.LedData.width', index=1,
      number=2, type=13, cpp_type=3, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='height', full_name='paperatus.LedData.height', index=2,
      number=3, type=13, cpp_type=3, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=93,
  serialized_end=147,
)


_SETUP = _descriptor.Descriptor(
  name='Setup',
  full_name='paperatus.Setup',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='ledData', full_name='paperatus.Setup.ledData', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='mapping', full_name='paperatus.Setup.mapping', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=149,
  serialized_end=230,
)


_MAPPING = _descriptor.Descriptor(
  name='Mapping',
  full_name='paperatus.Mapping',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='data', full_name='paperatus.Mapping.data', index=0,
      number=1, type=13, cpp_type=3, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=232,
  serialized_end=255,
)

_SETUP.fields_by_name['ledData'].message_type = _LEDDATA
_SETUP.fields_by_name['mapping'].message_type = _MAPPING
DESCRIPTOR.message_types_by_name['LedData'] = _LEDDATA
DESCRIPTOR.message_types_by_name['Setup'] = _SETUP
DESCRIPTOR.message_types_by_name['Mapping'] = _MAPPING
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

LedData = _reflection.GeneratedProtocolMessageType('LedData', (_message.Message,), {
  'DESCRIPTOR' : _LEDDATA,
  '__module__' : 'led_control_pb2'
  # @@protoc_insertion_point(class_scope:paperatus.LedData)
  })
_sym_db.RegisterMessage(LedData)

Setup = _reflection.GeneratedProtocolMessageType('Setup', (_message.Message,), {
  'DESCRIPTOR' : _SETUP,
  '__module__' : 'led_control_pb2'
  # @@protoc_insertion_point(class_scope:paperatus.Setup)
  })
_sym_db.RegisterMessage(Setup)

Mapping = _reflection.GeneratedProtocolMessageType('Mapping', (_message.Message,), {
  'DESCRIPTOR' : _MAPPING,
  '__module__' : 'led_control_pb2'
  # @@protoc_insertion_point(class_scope:paperatus.Mapping)
  })
_sym_db.RegisterMessage(Mapping)


DESCRIPTOR._options = None

_LEDCONTROL = _descriptor.ServiceDescriptor(
  name='LedControl',
  full_name='paperatus.LedControl',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_start=258,
  serialized_end=391,
  methods=[
  _descriptor.MethodDescriptor(
    name='Initialize',
    full_name='paperatus.LedControl.Initialize',
    index=0,
    containing_service=None,
    input_type=_SETUP,
    output_type=google_dot_protobuf_dot_wrappers__pb2._BOOLVALUE,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='WriteData',
    full_name='paperatus.LedControl.WriteData',
    index=1,
    containing_service=None,
    input_type=_LEDDATA,
    output_type=google_dot_protobuf_dot_empty__pb2._EMPTY,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
])
_sym_db.RegisterServiceDescriptor(_LEDCONTROL)

DESCRIPTOR.services_by_name['LedControl'] = _LEDCONTROL

# @@protoc_insertion_point(module_scope)
