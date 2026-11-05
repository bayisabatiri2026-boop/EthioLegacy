package com.ethiolegacy.app;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
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
        if (Build.VERSION.SDK_INT < 33) {
            if (!hasRequiredPermissions()) {
                requestAllPermissions(call, "permissionRequestFinished");
            } else {
                resolvePermissionStates(call);
            }
            return;
        }

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

    @PluginMethod
    public void openAppSettings(PluginCall call) {
        try {
            Intent intent = new Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:" + getContext().getPackageName())
            );
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getContext().startActivity(intent);
            call.resolve();
        } catch (Exception error) {
            call.reject("Unable to open Android app settings", error);
        }
    }

    private void resolvePermissionStates(PluginCall call) {
        JSObject result = new JSObject();
        result.put("camera", getPermissionState("camera").toString().toLowerCase());
        result.put("microphone", getPermissionState("microphone").toString().toLowerCase());
        result.put(
            "notifications",
            Build.VERSION.SDK_INT >= 33
                ? getPermissionState("notifications").toString().toLowerCase()
                : "granted"
        );
        call.resolve(result);
    }
}
