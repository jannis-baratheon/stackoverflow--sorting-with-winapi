package com.example.sortitlikewindowsexplorer;

import java.util.Comparator;

class StrCmpLogicalWComparatorTest extends NumericalSortingComparatorTest {

    @Override
    Comparator<String> createComparator() {
        return new StrCmpLogicalWComparator();
    }
}
