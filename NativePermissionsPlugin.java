package com.ethiolegacy.app;

import android.Manifest;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.PermissionState;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;

@CapacitorPlugin(
    name = "NativePermissions",
    permissions = {
        @Permission(alias = "camera", strings = { Manifest.permission.CAMERA }),
        @Permission(alias = "microphone", strings = { Manifest.permission.RECORD_AUDIO }),
        @Permission(alias = "notifications", strings = { Manifest.permission.POST_NOTIFICATIONS })
    }
)
public class NativePermissionsPlugin extends Plugin {
    @PluginMethod
    public void requestAll(PluginCall call) {
        if (!hasRequiredPermissions()) {
            requestAllPermissions(call, "permissionRequestFinished");
        } else {
            resolvePermissionStates(call);
        }
    }

    @PermissionCallback
    private void permissionRequestFinished(PluginCall call) {
        resolvePermissionStates(call);
    }

    private void resolvePermissionStates(PluginCall call) {
        JSObject result = new JSObject();
        result.put("camera", getPermissionState("camera").toString().toLowerCase());
        result.put("microphone", getPermissionState("microphone").toString().toLowerCase());
        result.put("notifications", getPermissionState("notifications").toString().toLowerCase());
        call.resolve(result);
    }
}
