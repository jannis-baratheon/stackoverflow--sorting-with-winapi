package com.example.sortitlikewindowsexplorer.winapi;

import com.sun.jna.WString;

public final class JnaTypeUtil {
    private JnaTypeUtil() {
    }

    public static WString wString(String string) {
        return new WString(string);
    }
}
