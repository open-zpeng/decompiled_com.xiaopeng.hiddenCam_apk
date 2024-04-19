package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket;

import okio.ByteString;
/* loaded from: classes.dex */
public abstract class WebSocketSubscriber implements c5<IWebSocketInfo> {
    private d5 disposable;
    private boolean hasOpened;

    public final void dispose() {
        d5 d5Var = this.disposable;
        if (d5Var != null) {
            d5Var.a();
        }
    }

    protected void onClose() {
    }

    protected void onClosed(int i, String str) {
    }

    public final void onComplete() {
        if (this.hasOpened) {
            onClose();
        }
    }

    public void onError(Throwable th) {
        th.printStackTrace();
    }

    protected void onMessage(String str) {
    }

    protected void onMessage(ByteString byteString) {
    }

    protected void onOpen() {
    }

    protected void onReconnect() {
    }

    public final void onSubscribe(d5 d5Var) {
        this.disposable = d5Var;
    }

    public final void onNext(IWebSocketInfo iWebSocketInfo) {
        if (iWebSocketInfo.isOnOpen()) {
            this.hasOpened = true;
            onOpen();
        } else if (iWebSocketInfo.isClosed()) {
            this.hasOpened = false;
            onClosed(iWebSocketInfo.closedReasonCode(), iWebSocketInfo.closedReason());
        } else if (iWebSocketInfo.stringMessage() != null) {
            onMessage(iWebSocketInfo.stringMessage());
        } else if (iWebSocketInfo.byteStringMessage() != null) {
            onMessage(iWebSocketInfo.byteStringMessage());
        } else if (iWebSocketInfo.isOnReconnect()) {
            onReconnect();
        }
    }
}
