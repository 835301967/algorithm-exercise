package easy;


import org.junit.jupiter.api.Test;

class threeNumTest {

    @Test
    void averageValue() {
        threeNum threeNum = new threeNum();
//        int i = threeNum.averageValue(new int[]{1, 3, 4, 5, 5, 6, 9, 12});
        int i = threeNum.averageValue(new int[]{ 4,4,  9, 10});
        System.out.println(i);
    }
}