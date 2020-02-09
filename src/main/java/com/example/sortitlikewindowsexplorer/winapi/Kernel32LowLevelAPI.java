package com.example.sortitlikewindowsexplorer.winapi;

import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.win32.StdCallLibrary;

/**
 * Based on <a href="https://stackoverflow.com/a/7205788">this answer</a>
 * to <a href="https://stackoverflow.com/q/7204663">this StackOverflow question</a>.
 * <p>
 * Kudos go to <a href="https://stackoverflow.com/users/98607/martin-liversage">Martin Liversage</a>.
 *
 * @see <a href="https://stackoverflow.com/users/98607/martin-liversage">Martin Liversage</a>
 * @see <a href="https://stackoverflow.com/a/7205788">Martin Liversage answer to "What is the shortest way in .NET to sort strings starting with 1, 10 and 2 and respect the number ordering?"</a>
 */
public interface Kernel32LowLevelAPI extends StdCallLibrary {

    /**
     * Native WIN32 string comparing function.
     *
     * <pre>
     * int CompareStringEx(
     *     LPCWSTR                          lpLocaleName,
     *     DWORD                            dwCmpFlags,
     *     _In_NLS_string_(cchCount1)LPCWCH lpString1,
     *     int                              cchCount1,
     *     _In_NLS_string_(cchCount2)LPCWCH lpString2,
     *     int                              cchCount2,
     *     LPNLSVERSIONINFO                 lpVersionInformation,
     *     LPVOID                           lpReserved,
     *     LPARAM                           lParam
     * );
     * </pre>
     *
     * @see <a href="https://docs.microsoft.com/en-us/windows/win32/api/stringapiset/nf-stringapiset-comparestringex">CompareStringEx</a>
     */
    int CompareStringEx(WString lpLocaleName,
                        int dwCmpFlags,
                        WString lpString1,
                        int cchCount1,
                        WString lpString2,
                        int cchCount2,
                        Pointer lpVersionInformation,
                        Pointer lpReserved,
                        int lParam);
}
