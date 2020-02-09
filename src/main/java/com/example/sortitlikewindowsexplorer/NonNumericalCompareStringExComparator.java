package com.example.sortitlikewindowsexplorer;

import com.example.sortitlikewindowsexplorer.winapi.Kernel32;

public class NonNumericalCompareStringExComparator
    extends CompareStringExComparator {

    public NonNumericalCompareStringExComparator() {
        super(Kernel32.CompareStringExOptionSet.NONE);
    }
}
