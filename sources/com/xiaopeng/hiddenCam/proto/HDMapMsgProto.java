package com.xiaopeng.hiddenCam.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class HDMapMsgProto {

    /* renamed from: com.xiaopeng.hiddenCam.proto.HDMapMsgProto$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        static {
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class HDMapMsg extends GeneratedMessageLite<HDMapMsg, Builder> implements HDMapMsgOrBuilder {
        private static final HDMapMsg DEFAULT_INSTANCE = new HDMapMsg();
        public static final int ETH_XPU_CDU_AP_TIPS_FIELD_NUMBER = 1;
        public static final int ISHDMAP_FIELD_NUMBER = 2;
        public static final int MAP_ID_FIELD_NUMBER = 3;
        public static final int MAP_TIME_FIELD_NUMBER = 4;
        private static volatile Parser<HDMapMsg> PARSER = null;
        public static final int XPU_FSD_APA_FRONT_SLOT_FIELD_NUMBER = 5;
        private int eTHXPUCDUAPTips_;
        private int isHDMAP_;
        private int mapID_;
        private long mapTime_;
        private Internal.ProtobufList<HDMapXpuFsdApaFrontSlot> xpuFsdApaFrontSlot_ = GeneratedMessageLite.emptyProtobufList();

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<HDMapMsg, Builder> implements HDMapMsgOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllXpuFsdApaFrontSlot(Iterable<? extends HDMapXpuFsdApaFrontSlot> iterable) {
                copyOnWrite();
                ((HDMapMsg) this.instance).addAllXpuFsdApaFrontSlot(iterable);
                return this;
            }

            public Builder addXpuFsdApaFrontSlot(HDMapXpuFsdApaFrontSlot hDMapXpuFsdApaFrontSlot) {
                copyOnWrite();
                ((HDMapMsg) this.instance).addXpuFsdApaFrontSlot(hDMapXpuFsdApaFrontSlot);
                return this;
            }

            public Builder clearETHXPUCDUAPTips() {
                copyOnWrite();
                ((HDMapMsg) this.instance).clearETHXPUCDUAPTips();
                return this;
            }

            public Builder clearIsHDMAP() {
                copyOnWrite();
                ((HDMapMsg) this.instance).clearIsHDMAP();
                return this;
            }

            public Builder clearMapID() {
                copyOnWrite();
                ((HDMapMsg) this.instance).clearMapID();
                return this;
            }

            public Builder clearMapTime() {
                copyOnWrite();
                ((HDMapMsg) this.instance).clearMapTime();
                return this;
            }

            public Builder clearXpuFsdApaFrontSlot() {
                copyOnWrite();
                ((HDMapMsg) this.instance).clearXpuFsdApaFrontSlot();
                return this;
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
            public int getETHXPUCDUAPTips() {
                return ((HDMapMsg) this.instance).getETHXPUCDUAPTips();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
            public int getIsHDMAP() {
                return ((HDMapMsg) this.instance).getIsHDMAP();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
            public int getMapID() {
                return ((HDMapMsg) this.instance).getMapID();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
            public long getMapTime() {
                return ((HDMapMsg) this.instance).getMapTime();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
            public HDMapXpuFsdApaFrontSlot getXpuFsdApaFrontSlot(int i) {
                return ((HDMapMsg) this.instance).getXpuFsdApaFrontSlot(i);
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
            public int getXpuFsdApaFrontSlotCount() {
                return ((HDMapMsg) this.instance).getXpuFsdApaFrontSlotCount();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
            public List<HDMapXpuFsdApaFrontSlot> getXpuFsdApaFrontSlotList() {
                return Collections.unmodifiableList(((HDMapMsg) this.instance).getXpuFsdApaFrontSlotList());
            }

            public Builder removeXpuFsdApaFrontSlot(int i) {
                copyOnWrite();
                ((HDMapMsg) this.instance).removeXpuFsdApaFrontSlot(i);
                return this;
            }

            public Builder setETHXPUCDUAPTips(int i) {
                copyOnWrite();
                ((HDMapMsg) this.instance).setETHXPUCDUAPTips(i);
                return this;
            }

            public Builder setIsHDMAP(int i) {
                copyOnWrite();
                ((HDMapMsg) this.instance).setIsHDMAP(i);
                return this;
            }

            public Builder setMapID(int i) {
                copyOnWrite();
                ((HDMapMsg) this.instance).setMapID(i);
                return this;
            }

            public Builder setMapTime(long j) {
                copyOnWrite();
                ((HDMapMsg) this.instance).setMapTime(j);
                return this;
            }

            public Builder setXpuFsdApaFrontSlot(int i, HDMapXpuFsdApaFrontSlot hDMapXpuFsdApaFrontSlot) {
                copyOnWrite();
                ((HDMapMsg) this.instance).setXpuFsdApaFrontSlot(i, hDMapXpuFsdApaFrontSlot);
                return this;
            }

            private Builder() {
                super(HDMapMsg.DEFAULT_INSTANCE);
            }

            public Builder addXpuFsdApaFrontSlot(int i, HDMapXpuFsdApaFrontSlot hDMapXpuFsdApaFrontSlot) {
                copyOnWrite();
                ((HDMapMsg) this.instance).addXpuFsdApaFrontSlot(i, hDMapXpuFsdApaFrontSlot);
                return this;
            }

            public Builder setXpuFsdApaFrontSlot(int i, HDMapXpuFsdApaFrontSlot.Builder builder) {
                copyOnWrite();
                ((HDMapMsg) this.instance).setXpuFsdApaFrontSlot(i, builder);
                return this;
            }

            public Builder addXpuFsdApaFrontSlot(HDMapXpuFsdApaFrontSlot.Builder builder) {
                copyOnWrite();
                ((HDMapMsg) this.instance).addXpuFsdApaFrontSlot(builder);
                return this;
            }

            public Builder addXpuFsdApaFrontSlot(int i, HDMapXpuFsdApaFrontSlot.Builder builder) {
                copyOnWrite();
                ((HDMapMsg) this.instance).addXpuFsdApaFrontSlot(i, builder);
                return this;
            }
        }

        static {
            GeneratedMessageLite.registerDefaultInstance(HDMapMsg.class, DEFAULT_INSTANCE);
        }

        private HDMapMsg() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllXpuFsdApaFrontSlot(Iterable<? extends HDMapXpuFsdApaFrontSlot> iterable) {
            ensureXpuFsdApaFrontSlotIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.xpuFsdApaFrontSlot_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addXpuFsdApaFrontSlot(HDMapXpuFsdApaFrontSlot hDMapXpuFsdApaFrontSlot) {
            if (hDMapXpuFsdApaFrontSlot != null) {
                ensureXpuFsdApaFrontSlotIsMutable();
                this.xpuFsdApaFrontSlot_.add(hDMapXpuFsdApaFrontSlot);
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearETHXPUCDUAPTips() {
            this.eTHXPUCDUAPTips_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsHDMAP() {
            this.isHDMAP_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMapID() {
            this.mapID_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMapTime() {
            this.mapTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXpuFsdApaFrontSlot() {
            this.xpuFsdApaFrontSlot_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureXpuFsdApaFrontSlotIsMutable() {
            if (this.xpuFsdApaFrontSlot_.isModifiable()) {
                return;
            }
            this.xpuFsdApaFrontSlot_ = GeneratedMessageLite.mutableCopy(this.xpuFsdApaFrontSlot_);
        }

        public static HDMapMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static HDMapMsg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (HDMapMsg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static HDMapMsg parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (HDMapMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<HDMapMsg> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeXpuFsdApaFrontSlot(int i) {
            ensureXpuFsdApaFrontSlotIsMutable();
            this.xpuFsdApaFrontSlot_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setETHXPUCDUAPTips(int i) {
            this.eTHXPUCDUAPTips_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsHDMAP(int i) {
            this.isHDMAP_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMapID(int i) {
            this.mapID_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMapTime(long j) {
            this.mapTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXpuFsdApaFrontSlot(int i, HDMapXpuFsdApaFrontSlot hDMapXpuFsdApaFrontSlot) {
            if (hDMapXpuFsdApaFrontSlot != null) {
                ensureXpuFsdApaFrontSlotIsMutable();
                this.xpuFsdApaFrontSlot_.set(i, hDMapXpuFsdApaFrontSlot);
                return;
            }
            throw new NullPointerException();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new HDMapMsg();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u000b\u0002\u000b\u0003\u000b\u0004\u0003\u0005\u001b", new Object[]{"eTHXPUCDUAPTips_", "isHDMAP_", "mapID_", "mapTime_", "xpuFsdApaFrontSlot_", HDMapXpuFsdApaFrontSlot.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<HDMapMsg> parser = PARSER;
                    if (parser == null) {
                        synchronized (HDMapMsg.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
        public int getETHXPUCDUAPTips() {
            return this.eTHXPUCDUAPTips_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
        public int getIsHDMAP() {
            return this.isHDMAP_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
        public int getMapID() {
            return this.mapID_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
        public long getMapTime() {
            return this.mapTime_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
        public HDMapXpuFsdApaFrontSlot getXpuFsdApaFrontSlot(int i) {
            return this.xpuFsdApaFrontSlot_.get(i);
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
        public int getXpuFsdApaFrontSlotCount() {
            return this.xpuFsdApaFrontSlot_.size();
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapMsgOrBuilder
        public List<HDMapXpuFsdApaFrontSlot> getXpuFsdApaFrontSlotList() {
            return this.xpuFsdApaFrontSlot_;
        }

        public HDMapXpuFsdApaFrontSlotOrBuilder getXpuFsdApaFrontSlotOrBuilder(int i) {
            return this.xpuFsdApaFrontSlot_.get(i);
        }

        public List<? extends HDMapXpuFsdApaFrontSlotOrBuilder> getXpuFsdApaFrontSlotOrBuilderList() {
            return this.xpuFsdApaFrontSlot_;
        }

        public static Builder newBuilder(HDMapMsg hDMapMsg) {
            return DEFAULT_INSTANCE.createBuilder(hDMapMsg);
        }

        public static HDMapMsg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HDMapMsg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static HDMapMsg parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HDMapMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static HDMapMsg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (HDMapMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addXpuFsdApaFrontSlot(int i, HDMapXpuFsdApaFrontSlot hDMapXpuFsdApaFrontSlot) {
            if (hDMapXpuFsdApaFrontSlot != null) {
                ensureXpuFsdApaFrontSlotIsMutable();
                this.xpuFsdApaFrontSlot_.add(i, hDMapXpuFsdApaFrontSlot);
                return;
            }
            throw new NullPointerException();
        }

        public static HDMapMsg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HDMapMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXpuFsdApaFrontSlot(int i, HDMapXpuFsdApaFrontSlot.Builder builder) {
            ensureXpuFsdApaFrontSlotIsMutable();
            this.xpuFsdApaFrontSlot_.set(i, builder.build());
        }

        public static HDMapMsg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (HDMapMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static HDMapMsg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HDMapMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addXpuFsdApaFrontSlot(HDMapXpuFsdApaFrontSlot.Builder builder) {
            ensureXpuFsdApaFrontSlotIsMutable();
            this.xpuFsdApaFrontSlot_.add(builder.build());
        }

        public static HDMapMsg parseFrom(InputStream inputStream) throws IOException {
            return (HDMapMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static HDMapMsg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HDMapMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addXpuFsdApaFrontSlot(int i, HDMapXpuFsdApaFrontSlot.Builder builder) {
            ensureXpuFsdApaFrontSlotIsMutable();
            this.xpuFsdApaFrontSlot_.add(i, builder.build());
        }

        public static HDMapMsg parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (HDMapMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static HDMapMsg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HDMapMsg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes.dex */
    public interface HDMapMsgOrBuilder extends MessageLiteOrBuilder {
        int getETHXPUCDUAPTips();

        int getIsHDMAP();

        int getMapID();

        long getMapTime();

        HDMapXpuFsdApaFrontSlot getXpuFsdApaFrontSlot(int i);

        int getXpuFsdApaFrontSlotCount();

        List<HDMapXpuFsdApaFrontSlot> getXpuFsdApaFrontSlotList();
    }

    /* loaded from: classes.dex */
    public static final class HDMapXpuFsdApaFrontSlot extends GeneratedMessageLite<HDMapXpuFsdApaFrontSlot, Builder> implements HDMapXpuFsdApaFrontSlotOrBuilder {
        private static final HDMapXpuFsdApaFrontSlot DEFAULT_INSTANCE = new HDMapXpuFsdApaFrontSlot();
        private static volatile Parser<HDMapXpuFsdApaFrontSlot> PARSER = null;
        public static final int SCU_LOCAT_H_FIELD_NUMBER = 18;
        public static final int SCU_LOCAT_S_FIELD_NUMBER = 19;
        public static final int XPU_PKPTFARFRONTX_FIELD_NUMBER = 5;
        public static final int XPU_PKPTFARFRONTY_FIELD_NUMBER = 6;
        public static final int XPU_PKPTFARREARX_FIELD_NUMBER = 7;
        public static final int XPU_PKPTFARREARY_FIELD_NUMBER = 8;
        public static final int XPU_PKPTNEARFRONTX_FIELD_NUMBER = 3;
        public static final int XPU_PKPTNEARFRONTY_FIELD_NUMBER = 4;
        public static final int XPU_PKPTNEARREARX_FIELD_NUMBER = 1;
        public static final int XPU_PKPTNEARREARY_FIELD_NUMBER = 2;
        public static final int XPU_PKTEXTCENTERX_FIELD_NUMBER = 13;
        public static final int XPU_PKTEXTCENTERY_FIELD_NUMBER = 14;
        public static final int XPU_PKTEXTCONF_FIELD_NUMBER = 17;
        public static final int XPU_PKTEXTSLOPEX_FIELD_NUMBER = 15;
        public static final int XPU_PKTEXTSLOPEY_FIELD_NUMBER = 16;
        public static final int XPU_PKTEXT_FIELD_NUMBER = 12;
        public static final int XPU_SCU_SEND_PARK_TIMES_FIELD_NUMBER = 11;
        public static final int XPU_SCU_SLOTATT_FIELD_NUMBER = 9;
        public static final int XPU_SCU_SLOTINDEX_FIELD_NUMBER = 10;
        private float sCULocatH_;
        private float sCULocatS_;
        private float xPUPkPtFarFrontX_;
        private float xPUPkPtFarFrontY_;
        private float xPUPkPtFarRearX_;
        private float xPUPkPtFarRearY_;
        private float xPUPkPtNearFrontX_;
        private float xPUPkPtNearFrontY_;
        private float xPUPkPtNearRearX_;
        private float xPUPkPtNearRearY_;
        private float xPUPkTextCenterX_;
        private float xPUPkTextCenterY_;
        private float xPUPkTextConf_;
        private float xPUPkTextSlopeX_;
        private float xPUPkTextSlopeY_;
        private String xPUPkText_ = "";
        private int xPUSCUSendParkTimes_;
        private int xPUSCUSlotAtt_;
        private int xPUSCUSlotIndex_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<HDMapXpuFsdApaFrontSlot, Builder> implements HDMapXpuFsdApaFrontSlotOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearSCULocatH() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearSCULocatH();
                return this;
            }

            public Builder clearSCULocatS() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearSCULocatS();
                return this;
            }

            public Builder clearXPUPkPtFarFrontX() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkPtFarFrontX();
                return this;
            }

            public Builder clearXPUPkPtFarFrontY() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkPtFarFrontY();
                return this;
            }

            public Builder clearXPUPkPtFarRearX() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkPtFarRearX();
                return this;
            }

            public Builder clearXPUPkPtFarRearY() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkPtFarRearY();
                return this;
            }

            public Builder clearXPUPkPtNearFrontX() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkPtNearFrontX();
                return this;
            }

            public Builder clearXPUPkPtNearFrontY() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkPtNearFrontY();
                return this;
            }

            public Builder clearXPUPkPtNearRearX() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkPtNearRearX();
                return this;
            }

            public Builder clearXPUPkPtNearRearY() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkPtNearRearY();
                return this;
            }

            public Builder clearXPUPkText() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkText();
                return this;
            }

            public Builder clearXPUPkTextCenterX() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkTextCenterX();
                return this;
            }

            public Builder clearXPUPkTextCenterY() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkTextCenterY();
                return this;
            }

            public Builder clearXPUPkTextConf() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkTextConf();
                return this;
            }

            public Builder clearXPUPkTextSlopeX() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkTextSlopeX();
                return this;
            }

            public Builder clearXPUPkTextSlopeY() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUPkTextSlopeY();
                return this;
            }

            public Builder clearXPUSCUSendParkTimes() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUSCUSendParkTimes();
                return this;
            }

            public Builder clearXPUSCUSlotAtt() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUSCUSlotAtt();
                return this;
            }

            public Builder clearXPUSCUSlotIndex() {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).clearXPUSCUSlotIndex();
                return this;
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getSCULocatH() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getSCULocatH();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getSCULocatS() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getSCULocatS();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkPtFarFrontX() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkPtFarFrontX();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkPtFarFrontY() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkPtFarFrontY();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkPtFarRearX() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkPtFarRearX();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkPtFarRearY() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkPtFarRearY();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkPtNearFrontX() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkPtNearFrontX();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkPtNearFrontY() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkPtNearFrontY();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkPtNearRearX() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkPtNearRearX();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkPtNearRearY() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkPtNearRearY();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public String getXPUPkText() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkText();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public ByteString getXPUPkTextBytes() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkTextBytes();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkTextCenterX() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkTextCenterX();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkTextCenterY() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkTextCenterY();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkTextConf() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkTextConf();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkTextSlopeX() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkTextSlopeX();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public float getXPUPkTextSlopeY() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUPkTextSlopeY();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public int getXPUSCUSendParkTimes() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUSCUSendParkTimes();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public int getXPUSCUSlotAtt() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUSCUSlotAtt();
            }

            @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
            public int getXPUSCUSlotIndex() {
                return ((HDMapXpuFsdApaFrontSlot) this.instance).getXPUSCUSlotIndex();
            }

            public Builder setSCULocatH(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setSCULocatH(f);
                return this;
            }

            public Builder setSCULocatS(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setSCULocatS(f);
                return this;
            }

            public Builder setXPUPkPtFarFrontX(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkPtFarFrontX(f);
                return this;
            }

            public Builder setXPUPkPtFarFrontY(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkPtFarFrontY(f);
                return this;
            }

            public Builder setXPUPkPtFarRearX(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkPtFarRearX(f);
                return this;
            }

            public Builder setXPUPkPtFarRearY(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkPtFarRearY(f);
                return this;
            }

            public Builder setXPUPkPtNearFrontX(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkPtNearFrontX(f);
                return this;
            }

            public Builder setXPUPkPtNearFrontY(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkPtNearFrontY(f);
                return this;
            }

            public Builder setXPUPkPtNearRearX(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkPtNearRearX(f);
                return this;
            }

            public Builder setXPUPkPtNearRearY(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkPtNearRearY(f);
                return this;
            }

            public Builder setXPUPkText(String str) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkText(str);
                return this;
            }

            public Builder setXPUPkTextBytes(ByteString byteString) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkTextBytes(byteString);
                return this;
            }

            public Builder setXPUPkTextCenterX(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkTextCenterX(f);
                return this;
            }

            public Builder setXPUPkTextCenterY(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkTextCenterY(f);
                return this;
            }

            public Builder setXPUPkTextConf(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkTextConf(f);
                return this;
            }

            public Builder setXPUPkTextSlopeX(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkTextSlopeX(f);
                return this;
            }

            public Builder setXPUPkTextSlopeY(float f) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUPkTextSlopeY(f);
                return this;
            }

            public Builder setXPUSCUSendParkTimes(int i) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUSCUSendParkTimes(i);
                return this;
            }

            public Builder setXPUSCUSlotAtt(int i) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUSCUSlotAtt(i);
                return this;
            }

            public Builder setXPUSCUSlotIndex(int i) {
                copyOnWrite();
                ((HDMapXpuFsdApaFrontSlot) this.instance).setXPUSCUSlotIndex(i);
                return this;
            }

            private Builder() {
                super(HDMapXpuFsdApaFrontSlot.DEFAULT_INSTANCE);
            }
        }

        static {
            GeneratedMessageLite.registerDefaultInstance(HDMapXpuFsdApaFrontSlot.class, DEFAULT_INSTANCE);
        }

        private HDMapXpuFsdApaFrontSlot() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSCULocatH() {
            this.sCULocatH_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSCULocatS() {
            this.sCULocatS_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkPtFarFrontX() {
            this.xPUPkPtFarFrontX_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkPtFarFrontY() {
            this.xPUPkPtFarFrontY_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkPtFarRearX() {
            this.xPUPkPtFarRearX_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkPtFarRearY() {
            this.xPUPkPtFarRearY_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkPtNearFrontX() {
            this.xPUPkPtNearFrontX_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkPtNearFrontY() {
            this.xPUPkPtNearFrontY_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkPtNearRearX() {
            this.xPUPkPtNearRearX_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkPtNearRearY() {
            this.xPUPkPtNearRearY_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkText() {
            this.xPUPkText_ = getDefaultInstance().getXPUPkText();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkTextCenterX() {
            this.xPUPkTextCenterX_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkTextCenterY() {
            this.xPUPkTextCenterY_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkTextConf() {
            this.xPUPkTextConf_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkTextSlopeX() {
            this.xPUPkTextSlopeX_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUPkTextSlopeY() {
            this.xPUPkTextSlopeY_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUSCUSendParkTimes() {
            this.xPUSCUSendParkTimes_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUSCUSlotAtt() {
            this.xPUSCUSlotAtt_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPUSCUSlotIndex() {
            this.xPUSCUSlotIndex_ = 0;
        }

        public static HDMapXpuFsdApaFrontSlot getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static HDMapXpuFsdApaFrontSlot parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (HDMapXpuFsdApaFrontSlot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static HDMapXpuFsdApaFrontSlot parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (HDMapXpuFsdApaFrontSlot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<HDMapXpuFsdApaFrontSlot> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSCULocatH(float f) {
            this.sCULocatH_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSCULocatS(float f) {
            this.sCULocatS_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkPtFarFrontX(float f) {
            this.xPUPkPtFarFrontX_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkPtFarFrontY(float f) {
            this.xPUPkPtFarFrontY_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkPtFarRearX(float f) {
            this.xPUPkPtFarRearX_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkPtFarRearY(float f) {
            this.xPUPkPtFarRearY_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkPtNearFrontX(float f) {
            this.xPUPkPtNearFrontX_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkPtNearFrontY(float f) {
            this.xPUPkPtNearFrontY_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkPtNearRearX(float f) {
            this.xPUPkPtNearRearX_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkPtNearRearY(float f) {
            this.xPUPkPtNearRearY_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkText(String str) {
            if (str != null) {
                this.xPUPkText_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkTextBytes(ByteString byteString) {
            if (byteString != null) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.xPUPkText_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkTextCenterX(float f) {
            this.xPUPkTextCenterX_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkTextCenterY(float f) {
            this.xPUPkTextCenterY_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkTextConf(float f) {
            this.xPUPkTextConf_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkTextSlopeX(float f) {
            this.xPUPkTextSlopeX_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUPkTextSlopeY(float f) {
            this.xPUPkTextSlopeY_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUSCUSendParkTimes(int i) {
            this.xPUSCUSendParkTimes_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUSCUSlotAtt(int i) {
            this.xPUSCUSlotAtt_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPUSCUSlotIndex(int i) {
            this.xPUSCUSlotIndex_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new HDMapXpuFsdApaFrontSlot();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0013\u0000\u0000\u0001\u0013\u0013\u0000\u0000\u0000\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u000b\n\u000b\u000b\u000b\fȈ\r\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001", new Object[]{"xPUPkPtNearRearX_", "xPUPkPtNearRearY_", "xPUPkPtNearFrontX_", "xPUPkPtNearFrontY_", "xPUPkPtFarFrontX_", "xPUPkPtFarFrontY_", "xPUPkPtFarRearX_", "xPUPkPtFarRearY_", "xPUSCUSlotAtt_", "xPUSCUSlotIndex_", "xPUSCUSendParkTimes_", "xPUPkText_", "xPUPkTextCenterX_", "xPUPkTextCenterY_", "xPUPkTextSlopeX_", "xPUPkTextSlopeY_", "xPUPkTextConf_", "sCULocatH_", "sCULocatS_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<HDMapXpuFsdApaFrontSlot> parser = PARSER;
                    if (parser == null) {
                        synchronized (HDMapXpuFsdApaFrontSlot.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getSCULocatH() {
            return this.sCULocatH_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getSCULocatS() {
            return this.sCULocatS_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkPtFarFrontX() {
            return this.xPUPkPtFarFrontX_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkPtFarFrontY() {
            return this.xPUPkPtFarFrontY_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkPtFarRearX() {
            return this.xPUPkPtFarRearX_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkPtFarRearY() {
            return this.xPUPkPtFarRearY_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkPtNearFrontX() {
            return this.xPUPkPtNearFrontX_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkPtNearFrontY() {
            return this.xPUPkPtNearFrontY_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkPtNearRearX() {
            return this.xPUPkPtNearRearX_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkPtNearRearY() {
            return this.xPUPkPtNearRearY_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public String getXPUPkText() {
            return this.xPUPkText_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public ByteString getXPUPkTextBytes() {
            return ByteString.copyFromUtf8(this.xPUPkText_);
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkTextCenterX() {
            return this.xPUPkTextCenterX_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkTextCenterY() {
            return this.xPUPkTextCenterY_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkTextConf() {
            return this.xPUPkTextConf_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkTextSlopeX() {
            return this.xPUPkTextSlopeX_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public float getXPUPkTextSlopeY() {
            return this.xPUPkTextSlopeY_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public int getXPUSCUSendParkTimes() {
            return this.xPUSCUSendParkTimes_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public int getXPUSCUSlotAtt() {
            return this.xPUSCUSlotAtt_;
        }

        @Override // com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlotOrBuilder
        public int getXPUSCUSlotIndex() {
            return this.xPUSCUSlotIndex_;
        }

        public static Builder newBuilder(HDMapXpuFsdApaFrontSlot hDMapXpuFsdApaFrontSlot) {
            return DEFAULT_INSTANCE.createBuilder(hDMapXpuFsdApaFrontSlot);
        }

        public static HDMapXpuFsdApaFrontSlot parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HDMapXpuFsdApaFrontSlot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static HDMapXpuFsdApaFrontSlot parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HDMapXpuFsdApaFrontSlot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static HDMapXpuFsdApaFrontSlot parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (HDMapXpuFsdApaFrontSlot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static HDMapXpuFsdApaFrontSlot parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HDMapXpuFsdApaFrontSlot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static HDMapXpuFsdApaFrontSlot parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (HDMapXpuFsdApaFrontSlot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static HDMapXpuFsdApaFrontSlot parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HDMapXpuFsdApaFrontSlot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static HDMapXpuFsdApaFrontSlot parseFrom(InputStream inputStream) throws IOException {
            return (HDMapXpuFsdApaFrontSlot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static HDMapXpuFsdApaFrontSlot parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HDMapXpuFsdApaFrontSlot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static HDMapXpuFsdApaFrontSlot parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (HDMapXpuFsdApaFrontSlot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static HDMapXpuFsdApaFrontSlot parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HDMapXpuFsdApaFrontSlot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes.dex */
    public interface HDMapXpuFsdApaFrontSlotOrBuilder extends MessageLiteOrBuilder {
        float getSCULocatH();

        float getSCULocatS();

        float getXPUPkPtFarFrontX();

        float getXPUPkPtFarFrontY();

        float getXPUPkPtFarRearX();

        float getXPUPkPtFarRearY();

        float getXPUPkPtNearFrontX();

        float getXPUPkPtNearFrontY();

        float getXPUPkPtNearRearX();

        float getXPUPkPtNearRearY();

        String getXPUPkText();

        ByteString getXPUPkTextBytes();

        float getXPUPkTextCenterX();

        float getXPUPkTextCenterY();

        float getXPUPkTextConf();

        float getXPUPkTextSlopeX();

        float getXPUPkTextSlopeY();

        int getXPUSCUSendParkTimes();

        int getXPUSCUSlotAtt();

        int getXPUSCUSlotIndex();
    }

    private HDMapMsgProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
