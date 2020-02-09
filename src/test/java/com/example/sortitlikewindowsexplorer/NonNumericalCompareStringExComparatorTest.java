package com.example.sortitlikewindowsexplorer;

import java.util.Comparator;

abstract class NonNumericalCompareStringExComparatorTest extends NonNumericalSortingComparatorTest {

    @Override
    Comparator<String> createComparator() {
        return new NonNumericalCompareStringExComparator();
    }
}
