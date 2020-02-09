package com.example.sortitlikewindowsexplorer.winapi;

import static com.example.sortitlikewindowsexplorer.winapi.JnaTypeUtil.wString;

public class Shlwapi {

    private final ShlwapiLowLevelAPI shlwapiLowLevelAPI;

    Shlwapi(ShlwapiLowLevelAPI shlwapiLowLevelAPI) {
        this.shlwapiLowLevelAPI = shlwapiLowLevelAPI;
    }

    public int StrCmpLogicalW(String str1, String str2) {
        return shlwapiLowLevelAPI.StrCmpLogicalW(wString(str1), wString(str2));
    }
}
