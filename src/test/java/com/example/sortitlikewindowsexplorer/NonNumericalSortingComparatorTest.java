package com.example.sortitlikewindowsexplorer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

abstract class NonNumericalSortingComparatorTest extends AbstractComparatorTest {

    @Test
    void case2() {
        Comparator<String> sut = createComparator();
        String[] fileNames = new String[]{
            "1 test ---10.jpg",
            "1 test --11.jpg",
            "1 test -12.jpg",
            "1.jpg",
            "10.jpg",
            "2.jpg"
        };

        Arrays.sort(fileNames, sut);

        assertThat(fileNames)
            .containsExactly(
                "1 test ---10.jpg",
                "1 test --11.jpg",
                "1 test -12.jpg",
                "1.jpg",
                "10.jpg",
                "2.jpg");
    }
}
