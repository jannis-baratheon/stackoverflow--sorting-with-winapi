package com.example.sortitlikewindowsexplorer;

import com.example.sortitlikewindowsexplorer.winapi.Kernel32;

public class NumericalCompareStringExComparator
    extends CompareStringExComparator {

    public NumericalCompareStringExComparator() {
        super(Kernel32.CompareStringExOptionSet.of(
            Kernel32.CompareStringExOption.SORT_DIGITSASNUMBERS));
    }
}
