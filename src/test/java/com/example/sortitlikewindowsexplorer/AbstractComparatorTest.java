package com.example.sortitlikewindowsexplorer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

abstract class AbstractComparatorTest {

    abstract Comparator<String> createComparator();

    @Test
    void case1() {
        Comparator<String> sut = createComparator();
        String[] fileNames = new String[]{
            "1 test -12.jpg",
            "1 test ---10.jpg",
            "1 test --11.jpg"
        };

        Arrays.sort(fileNames, sut);

        assertThat(fileNames)
            .containsExactly(
                "1 test ---10.jpg",
                "1 test --11.jpg",
                "1 test -12.jpg");
    }

    @ParameterizedTest
    @CsvSource({
        "a,b,-1",
        "b,a,1",
        "a,a,0",
    })
    void compares_simple_strings(String string1,
                                 String string2,
                                 int expectedComparisonResult) {
        Comparator<String> sut = createComparator();

        assertThat(sut.compare(string1, string2))
            .isEqualTo(expectedComparisonResult);
    }
}
