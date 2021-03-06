//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: led_control.proto

package com.paperatus.matrix.proto;

@kotlin.jvm.JvmSynthetic
public inline fun setup(block: com.paperatus.matrix.proto.SetupKt.Dsl.() -> kotlin.Unit): com.paperatus.matrix.proto.Setup =
  com.paperatus.matrix.proto.SetupKt.Dsl._create(com.paperatus.matrix.proto.Setup.newBuilder()).apply { block() }._build()
public object SetupKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.paperatus.matrix.proto.Setup.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.paperatus.matrix.proto.Setup.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.paperatus.matrix.proto.Setup = _builder.build()

    /**
     * <code>.paperatus.LedData ledData = 1;</code>
     */
    public var ledData: com.paperatus.matrix.proto.LedData
      @JvmName("getLedData")
      get() = _builder.getLedData()
      @JvmName("setLedData")
      set(value) {
        _builder.setLedData(value)
      }
    /**
     * <code>.paperatus.LedData ledData = 1;</code>
     */
    public fun clearLedData() {
      _builder.clearLedData()
    }
    /**
     * <code>.paperatus.LedData ledData = 1;</code>
     * @return Whether the ledData field is set.
     */
    public fun hasLedData(): kotlin.Boolean {
      return _builder.hasLedData()
    }

    /**
     * <code>.paperatus.Mapping mapping = 2;</code>
     */
    public var mapping: com.paperatus.matrix.proto.Mapping
      @JvmName("getMapping")
      get() = _builder.getMapping()
      @JvmName("setMapping")
      set(value) {
        _builder.setMapping(value)
      }
    /**
     * <code>.paperatus.Mapping mapping = 2;</code>
     */
    public fun clearMapping() {
      _builder.clearMapping()
    }
    /**
     * <code>.paperatus.Mapping mapping = 2;</code>
     * @return Whether the mapping field is set.
     */
    public fun hasMapping(): kotlin.Boolean {
      return _builder.hasMapping()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.paperatus.matrix.proto.Setup.copy(block: com.paperatus.matrix.proto.SetupKt.Dsl.() -> kotlin.Unit): com.paperatus.matrix.proto.Setup =
  com.paperatus.matrix.proto.SetupKt.Dsl._create(this.toBuilder()).apply { block() }._build()
