package com.example.sortitlikewindowsexplorer.winapi;

import static com.example.sortitlikewindowsexplorer.winapi.JnaTypeUtil.wString;

import com.sun.jna.Pointer;
import java.util.EnumSet;
import java.util.Locale;

public class Kernel32 {
    private final Kernel32LowLevelAPI kernel32LowLevelAPI;

    Kernel32(Kernel32LowLevelAPI kernel32LowLevelAPI) {
        this.kernel32LowLevelAPI = kernel32LowLevelAPI;
    }

    public int CompareStringEx(LocaleName localeName,
                               CompareStringExOptionSet options,
                               String str1,
                               String str2) {
        return kernel32LowLevelAPI
            .CompareStringEx(
                wString(localeName.getName()),
                options.getFlags(),
                wString(str1),
                str1.length(),
                wString(str2),
                str2.length(),
                Pointer.NULL,
                Pointer.NULL,
                0);
    }

    @SuppressWarnings("unused")
    public enum CompareStringExOption {
        NONE(0x00000000),

        NORM_IGNORECASE(0x00000001),
        NORM_IGNORENONSPACE(0x00000002),
        NORM_IGNORESYMBOLS(0x00000004),
        LINGUISTIC_IGNORECASE(0x00000010),
        LINGUISTIC_IGNOREDIACRITIC(0x00000020),
        NORM_IGNOREKANATYPE(0x00010000),
        NORM_IGNOREWIDTH(0x00020000),
        NORM_LINGUISTIC_CASING(0x08000000),
        SORT_STRINGSORT(0x00001000),
        SORT_DIGITSASNUMBERS(0x00000008);

        private final int optionMask;

        CompareStringExOption(int optionMask) {
            this.optionMask = optionMask;
        }

        public int getOptionMask() {
            return optionMask;
        }
    }

    @SuppressWarnings("unused")
    public static
    class LocaleName {

        public static LocaleName USER_DEFAULT = new LocaleName(null);
        public static LocaleName INVARIANT = new LocaleName("");
        public static LocaleName SYSTEM_DEFAULT = new LocaleName("!sys-default-locale");
        private final String localeName;

        private LocaleName(String locale) {
            this.localeName = locale;
        }

        public static LocaleName of(Locale locale) {
            return new LocaleName(locale.toString());
        }

        public String getName() {
            return localeName;
        }
    }

    public static class CompareStringExOptionSet {
        public static CompareStringExOptionSet NONE =
            of(CompareStringExOption.NONE);
        private final int flags;

        private CompareStringExOptionSet(CompareStringExOption first,
                                         CompareStringExOption... rest) {
            this.flags = EnumSet.of(first, rest)
                .stream()
                .mapToInt(CompareStringExOption::getOptionMask)
                .reduce(0, (mask, option) -> mask | option);
        }

        public static CompareStringExOptionSet of(CompareStringExOption first,
                                                  CompareStringExOption... rest) {
            return new CompareStringExOptionSet(first, rest);
        }

        int getFlags() {
            return flags;
        }
    }
}
