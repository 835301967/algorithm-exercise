package easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


class twoNumSumTest {

    @Test
    void twoSum() {
        twoNumSum twoNumSum = new twoNumSum();
        int[] ints = twoNumSum.twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println(Arrays.toString(ints));
    }
}