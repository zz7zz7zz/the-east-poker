// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/com/poker/protocols/game/server/proto/BroadcastUserOffline.proto

package com.poker.protocols.game.server;

public final class BroadcastUserOfflineProto {
  private BroadcastUserOfflineProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface BroadcastUserOfflineOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.poker.protocols.game.server.proto.BroadcastUserOffline)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 uid = 1;</code>
     */
    long getUid();

    /**
     * <code>int32 status = 2;</code>
     */
    int getStatus();
  }
  /**
   * Protobuf type {@code com.poker.protocols.game.server.proto.BroadcastUserOffline}
   */
  public  static final class BroadcastUserOffline extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.poker.protocols.game.server.proto.BroadcastUserOffline)
      BroadcastUserOfflineOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use BroadcastUserOffline.newBuilder() to construct.
    private BroadcastUserOffline(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private BroadcastUserOffline() {
      uid_ = 0L;
      status_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private BroadcastUserOffline(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              uid_ = input.readInt64();
              break;
            }
            case 16: {

              status_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.poker.protocols.game.server.BroadcastUserOfflineProto.internal_static_com_poker_protocols_game_server_proto_BroadcastUserOffline_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.poker.protocols.game.server.BroadcastUserOfflineProto.internal_static_com_poker_protocols_game_server_proto_BroadcastUserOffline_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline.class, com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline.Builder.class);
    }

    public static final int UID_FIELD_NUMBER = 1;
    private long uid_;
    /**
     * <code>int64 uid = 1;</code>
     */
    public long getUid() {
      return uid_;
    }

    public static final int STATUS_FIELD_NUMBER = 2;
    private int status_;
    /**
     * <code>int32 status = 2;</code>
     */
    public int getStatus() {
      return status_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (uid_ != 0L) {
        output.writeInt64(1, uid_);
      }
      if (status_ != 0) {
        output.writeInt32(2, status_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (uid_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, uid_);
      }
      if (status_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, status_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline)) {
        return super.equals(obj);
      }
      com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline other = (com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline) obj;

      boolean result = true;
      result = result && (getUid()
          == other.getUid());
      result = result && (getStatus()
          == other.getStatus());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + UID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getUid());
      hash = (37 * hash) + STATUS_FIELD_NUMBER;
      hash = (53 * hash) + getStatus();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    //-----------------------------------------------------
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseFrom(byte[] data,int offset ,int length)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return PARSER.parseFrom(data,offset,length);
        }
    //-----------------------------------------------------
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    //-----------------------------------------------------
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseFrom(
    		byte[] data,int offset ,int length,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return PARSER.parseFrom(data,offset,length, extensionRegistry);
        }
   //-----------------------------------------------------
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.poker.protocols.game.server.proto.BroadcastUserOffline}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.poker.protocols.game.server.proto.BroadcastUserOffline)
        com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOfflineOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.poker.protocols.game.server.BroadcastUserOfflineProto.internal_static_com_poker_protocols_game_server_proto_BroadcastUserOffline_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.poker.protocols.game.server.BroadcastUserOfflineProto.internal_static_com_poker_protocols_game_server_proto_BroadcastUserOffline_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline.class, com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline.Builder.class);
      }

      // Construct using com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        uid_ = 0L;

        status_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.poker.protocols.game.server.BroadcastUserOfflineProto.internal_static_com_poker_protocols_game_server_proto_BroadcastUserOffline_descriptor;
      }

      public com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline getDefaultInstanceForType() {
        return com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline.getDefaultInstance();
      }

      public com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline build() {
        com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline buildPartial() {
        com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline result = new com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline(this);
        result.uid_ = uid_;
        result.status_ = status_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline) {
          return mergeFrom((com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline other) {
        if (other == com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline.getDefaultInstance()) return this;
        if (other.getUid() != 0L) {
          setUid(other.getUid());
        }
        if (other.getStatus() != 0) {
          setStatus(other.getStatus());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long uid_ ;
      /**
       * <code>int64 uid = 1;</code>
       */
      public long getUid() {
        return uid_;
      }
      /**
       * <code>int64 uid = 1;</code>
       */
      public Builder setUid(long value) {
        
        uid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 uid = 1;</code>
       */
      public Builder clearUid() {
        
        uid_ = 0L;
        onChanged();
        return this;
      }

      private int status_ ;
      /**
       * <code>int32 status = 2;</code>
       */
      public int getStatus() {
        return status_;
      }
      /**
       * <code>int32 status = 2;</code>
       */
      public Builder setStatus(int value) {
        
        status_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 status = 2;</code>
       */
      public Builder clearStatus() {
        
        status_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.poker.protocols.game.server.proto.BroadcastUserOffline)
    }

    // @@protoc_insertion_point(class_scope:com.poker.protocols.game.server.proto.BroadcastUserOffline)
    private static final com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline();
    }

    public static com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<BroadcastUserOffline>
        PARSER = new com.google.protobuf.AbstractParser<BroadcastUserOffline>() {
      public BroadcastUserOffline parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new BroadcastUserOffline(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<BroadcastUserOffline> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<BroadcastUserOffline> getParserForType() {
      return PARSER;
    }

    public com.poker.protocols.game.server.BroadcastUserOfflineProto.BroadcastUserOffline getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_poker_protocols_game_server_proto_BroadcastUserOffline_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_poker_protocols_game_server_proto_BroadcastUserOffline_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\nDsrc/com/poker/protocols/game/server/pr" +
      "oto/BroadcastUserOffline.proto\022%com.poke" +
      "r.protocols.game.server.proto\"3\n\024Broadca" +
      "stUserOffline\022\013\n\003uid\030\001 \001(\003\022\016\n\006status\030\002 \001" +
      "(\005B<\n\037com.poker.protocols.game.serverB\031B" +
      "roadcastUserOfflineProtob\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_poker_protocols_game_server_proto_BroadcastUserOffline_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_poker_protocols_game_server_proto_BroadcastUserOffline_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_poker_protocols_game_server_proto_BroadcastUserOffline_descriptor,
        new java.lang.String[] { "Uid", "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
