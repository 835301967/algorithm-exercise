package sort;

public class Select {
    public void selectSort(int[] ints){
        for (int i = 0; i < ints.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < ints.length; j++) {
                if (ints[j]<ints[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                int temp = ints[minIndex];
                ints[minIndex] = ints[i];
                ints[i] = temp;
            }
        }
    }
}
