package com.mercury.test

import android.accessibilityservice.AccessibilityService
import android.app.Notification
import android.os.Build
import android.os.Parcelable
import android.text.TextUtils
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button

/**
 * 还要写个xml 写其的describe 等等 还需在menifest文件中声明该组件
 */
class MyAccessibeService : AccessibilityService() {
    override fun onInterrupt() {
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        var eventType = event?.eventType
        when (eventType){
            AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED->{

            }

            AccessibilityEvent.TYPE_WINDOWS_CHANGED->{

            }

            AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED->{}

        }

        var className = event?.className.toString()
        if (TextUtils.equals(className,"my package name")){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2){
                click(event,"click me ",Button.AUTOFILL_HINT_NAME)
            }
        }
    }

    private fun click(event: AccessibilityEvent?, s: String, any: String) {
         if(event?.source != null){
         var  nodes :List<AccessibilityNodeInfo> = event.source.findAccessibilityNodeInfosByText(s)
             if (!nodes.isEmpty()){
                var node: AccessibilityNodeInfo
                 for(i in 0..nodes.size){
                     node = nodes[i]
                     if (node.className.equals(any)){
                         if(node.isEnabled){
                             node.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                         }
                     }
                 }
             }

         }
    }


    fun getNotifacationInfo(event: AccessibilityEvent?){
       var parcele: Parcelable? = event?.parcelableData
        if (parcele is Notification){
            var notification:Notification = parcele
            notification.contentIntent.send()
        }
    }
}