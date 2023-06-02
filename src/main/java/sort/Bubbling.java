package sort;

import java.util.Deque;
import java.util.LinkedList;

public class Bubbling {
    public void sortWithBubbling(int[] input){
       for (int i = 0; i < input.length; i++) {
            boolean isExchange = false;
            for (int j = 0; j < input.length - i-1; j++) {
                if (input[j]>input[j+1]){
                    int temp= input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                    isExchange = true;
                }
            }
           if (!isExchange){
                    break ;
                }
        }
    }
}
