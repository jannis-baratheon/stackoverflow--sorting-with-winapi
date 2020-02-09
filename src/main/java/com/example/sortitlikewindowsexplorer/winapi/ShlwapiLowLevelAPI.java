package com.example.sortitlikewindowsexplorer.winapi;

import static com.example.sortitlikewindowsexplorer.winapi.JnaTypeUtil.wString;

import com.sun.jna.WString;
import com.sun.jna.win32.StdCallLibrary;

public interface ShlwapiLowLevelAPI extends StdCallLibrary {

    /**
     * String comparing function that Windows Explorer uses for sorting files by
     * their names.
     *
     * <pre>
     * int StrCmpLogicalW(
     *     PCWSTR psz1,
     *     PCWSTR psz2
     * );
     * </pre>
     *
     * @see <a href="https://docs.microsoft.com/pl-pl/windows/win32/api/shlwapi/nf-shlwapi-strcmplogicalw">StrCmpLogicalW</a>
     */
    int StrCmpLogicalW(WString psz1, WString psz2);

    default int StrCmpLogicalW(String str1, String str2) {
        return StrCmpLogicalW(wString(str1), wString(str2));
    }
}
