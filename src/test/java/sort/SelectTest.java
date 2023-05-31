package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectTest {

    @Test
    void selectSort() {
        Select select = new Select();
        int[] input = {3, 4, 5, 6, 2, 1, 22, 11, 1, 1, 1111, 0, 5435, 63465, 4532, 4, 432423};
        select.selectSort(input);
        Arrays.stream(input).forEach(i-> System.out.printf("%d,",i));
    }
}