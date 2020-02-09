package com.example.sortitlikewindowsexplorer;

import java.util.Comparator;

class NumericalCompareStringExComparatorTest extends NumericalSortingComparatorTest {

    @Override
    Comparator<String> createComparator() {
        return new NumericalCompareStringExComparator();
    }
}
