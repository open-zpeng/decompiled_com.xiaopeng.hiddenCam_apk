package com.xiaopeng.lib.apirouter;

import android.content.ContentProviderClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaopeng.lib.apirouter.ClientConstants;
import com.xiaopeng.lib.apirouter.server.ApiPublisherProvider;
import java.util.List;
/* loaded from: classes.dex */
public class ApiRouter {
    private static ApiMatcher mApiMatcher = new ApiMatcher();

    private ApiRouter() {
    }

    private static RemoteOperator publishModule(UriStruct uriStruct, IBinder iBinder, String str) {
        RemoteOperator fromJson = RemoteOperator.fromJson(iBinder, str);
        mApiMatcher.publishUri(uriStruct, fromJson);
        return fromJson;
    }

    public static <T> T route(Uri uri) throws RemoteException {
        return (T) route(uri, false, null);
    }

    private static UriStruct toUriStruct(Uri uri) throws RemoteException {
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            int lastIndexOf = authority.lastIndexOf(".");
            if (lastIndexOf != -1) {
                String substring = authority.substring(0, lastIndexOf);
                String substring2 = authority.substring(lastIndexOf + 1);
                UriStruct uriStruct = new UriStruct();
                uriStruct.applicationId = substring;
                uriStruct.serviceName = substring2;
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null && pathSegments.size() > 1) {
                    uriStruct.processTag = pathSegments.get(1);
                }
                return uriStruct;
            }
            throw new RemoteException("Illegal uri authority");
        }
        throw new RemoteException("Can not find authority in uri");
    }

    private static RemoteOperator wakeRemoteService(UriStruct uriStruct) throws RemoteException {
        if (ApiPublisherProvider.CONTEXT != null) {
            Uri.Builder builder = new Uri.Builder();
            if (TextUtils.isEmpty(uriStruct.processTag)) {
                Uri.Builder scheme = builder.scheme(ClientConstants.BINDER.SCHEME);
                scheme.authority(uriStruct.applicationId + ClientConstants.BINDER.API_SUFFIX);
            } else {
                Uri.Builder scheme2 = builder.scheme(ClientConstants.BINDER.SCHEME);
                scheme2.authority(uriStruct.applicationId + "." + uriStruct.processTag + ClientConstants.BINDER.API_SUFFIX);
            }
            ContentProviderClient acquireContentProviderClient = ApiPublisherProvider.CONTEXT.getContentResolver().acquireContentProviderClient(builder.build());
            if (acquireContentProviderClient != null) {
                try {
                    Bundle call = acquireContentProviderClient.call(uriStruct.serviceName, null, null);
                    if (call != null) {
                        IBinder binder = call.getBinder("binder");
                        String string = call.getString("manifest");
                        if (binder != null && !TextUtils.isEmpty(string)) {
                            return publishModule(uriStruct, binder, string);
                        }
                        throw new RemoteException("No matching method");
                    }
                    throw new RemoteException("Server does not implement call");
                } finally {
                    acquireContentProviderClient.release();
                }
            }
            throw new RemoteException("Unknown service " + uriStruct);
        }
        throw new RemoteException("ApiRouter can not route. If it is an asynchronous thread, please check your Context first!");
    }

    public static <T> T route(Uri uri, byte[] bArr) throws RemoteException {
        return (T) route(uri, true, bArr);
    }

    private static <T> T route(Uri uri, boolean z, byte[] bArr) throws RemoteException {
        UriStruct uriStruct = toUriStruct(uri);
        RemoteOperator matchRemoteOperator = mApiMatcher.matchRemoteOperator(uriStruct);
        if (matchRemoteOperator == null) {
            matchRemoteOperator = wakeRemoteService(uriStruct);
        } else if (!matchRemoteOperator.isRemoteAlive()) {
            mApiMatcher.unpublishUri(uriStruct);
            matchRemoteOperator = wakeRemoteService(uriStruct);
        }
        return (T) matchRemoteOperator.call(uri, z, bArr);
    }
}
