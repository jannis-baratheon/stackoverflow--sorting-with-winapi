package com.example.sortitlikewindowsexplorer;

import com.example.sortitlikewindowsexplorer.winapi.Shlwapi;
import com.example.sortitlikewindowsexplorer.winapi.Win32API;
import java.util.Comparator;

public class StrCmpLogicalWComparator implements Comparator<String> {

    private final Shlwapi shlwapi;

    public StrCmpLogicalWComparator() {
        shlwapi = Win32API.shlwapi();
    }

    @Override
    public int compare(String o1, String o2) {
        return shlwapi.StrCmpLogicalW(o1, o2);
    }
}
