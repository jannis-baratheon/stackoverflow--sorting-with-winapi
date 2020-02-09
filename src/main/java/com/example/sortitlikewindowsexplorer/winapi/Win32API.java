package com.example.sortitlikewindowsexplorer.winapi;

import static java.util.Collections.emptyMap;

import com.sun.jna.Library;
import com.sun.jna.Native;
import java.util.Locale;
import java.util.Map;

public final class Win32API {
    private static final Map<String, Object> OPTIONS = emptyMap();
    private final static Shlwapi SHLWAPI = new Shlwapi(
        loadWin32Lib("Shlwapi", ShlwapiLowLevelAPI.class));
    private final static Kernel32 KERNEL32 = new Kernel32(
        loadWin32Lib("Kernel32", Kernel32LowLevelAPI.class));

    private Win32API() {
    }

    public static Shlwapi shlwapi() {
        return SHLWAPI;
    }

    public static Kernel32 kernel32() {
        return KERNEL32;
    }

    private static <T extends Library> T
    loadWin32Lib(String name, Class<T> interfaceClass) {
        verifyThatWeAreRunningOnWindows();
        return Native.load(name, interfaceClass, OPTIONS);
    }

    private static void verifyThatWeAreRunningOnWindows() {
        String operatingSystem = getOperatingSystemName();

        if (!operatingSystem.contains("win")) {
            throw new WorksOnlyOnWindowsException();
        }
    }

    /**
     * Used for determining the operating system. Based on
     * <a href="https://stackoverflow.com/a/17506150">this answer</a> to
     * <a href="https://stackoverflow.com/q/228477">this StackOverflow question</a>.
     * <p>
     * Kudos go to <a href="https://stackoverflow.com/users/1964633/nikesh-jauhari">Nikesh Jauhari</a>.
     *
     * @see <a href="https://stackoverflow.com/a/17506150">Nikesh Jauhari answer to "How do I programmatically determine operating system in Java?"</a>
     * @see <a href="https://stackoverflow.com/users/1964633/nikesh-jauhari">Nikesh Jauhari</a>
     */
    private static String getOperatingSystemName() {
        return System
            .getProperty("os.name", "unknown")
            .toLowerCase(Locale.ROOT);
    }

    public static class WorksOnlyOnWindowsException extends IllegalStateException {
        public WorksOnlyOnWindowsException() {
            super("This will not work on an OS other than Windows " +
                "as it uses the Windows native API. " +
                "Your operating system is: \"" +
                getOperatingSystemName() + "\"");
        }
    }
}
