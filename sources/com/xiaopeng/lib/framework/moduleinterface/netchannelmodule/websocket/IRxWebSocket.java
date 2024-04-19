package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket;

import okio.ByteString;
/* loaded from: classes.dex */
public interface IRxWebSocket {
    void close(String str);

    IWebSocketConfig config();

    a5<IWebSocketInfo> get(String str);

    a5<IWebSocketInfo> get(String str, long j);

    IRxWebSocket header(String str, String str2);

    void send(String str, String str2) throws Exception;

    void send(String str, ByteString byteString) throws Exception;
}
