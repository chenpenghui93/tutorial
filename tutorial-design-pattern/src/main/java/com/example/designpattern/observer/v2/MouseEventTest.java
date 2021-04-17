package com.example.designpattern.observer.v2;

import com.example.designpattern.observer.v2.mouseevent.Mouse;
import com.example.designpattern.observer.v2.mouseevent.MouseEventCallback;
import com.example.designpattern.observer.v2.mouseevent.MouseEventType;

public class MouseEventTest {
    public static void main(String[] args) {

        MouseEventCallback callback = new MouseEventCallback();

        Mouse mouse = new Mouse();

        //@谁？  @回调方法
        mouse.addLisenter(MouseEventType.ON_CLICK, callback);
        mouse.addLisenter(MouseEventType.ON_FOCUS, callback);

        mouse.click();

        mouse.focus();


    }
}
