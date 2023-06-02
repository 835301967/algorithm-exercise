package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BubblingTest {

    @Test
    void sortWithBubbling() {
        Bubbling bubblingTest = new Bubbling();

        int[] input = {3, 4, 5, 6, 2, 1, 22, 11, 1, 1, 1111, 0, 5435, 63465, 4532, 4, 432423};
        bubblingTest.sortWithBubbling(input);
        Arrays.stream(input).forEach(i-> System.out.println(i));
    }
}