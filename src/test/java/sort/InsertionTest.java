package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class InsertionTest {

    @Test
    void insertSort() {
        Insertion insertion = new Insertion();
        int[] input = {3, 4, 5, 6, 2, 1, 22, 11, 1, 1, 1111, 0, 5435, 63465, 4532, 4, 432423};
        insertion.insertSort(input);
        Arrays.stream(input).forEach(i-> System.out.println(i));
    }
}