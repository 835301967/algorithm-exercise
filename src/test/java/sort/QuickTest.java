package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickTest {

    @Test
    void quickSort() {
        Quick quick = new Quick();
        int[] input = {3, 4, 5, 6, 2, 1, 22, 11, 1, 1, 1111, 0, 5435, 63465, 4532, 4, 432423};
        quick.quickSort(input);
        Arrays.stream(input).forEach(i-> System.out.println(i));
    }
    @Test
    void jj(){
        int j = 1;
        int i = --j;
        if (i == 0){
            System.out.printf("result"+j);
        }
    }

}