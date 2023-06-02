package sort;

public class Insertion {
    public void insertSort(int[] ints){
        for (int i = 0; i < ints.length-1; i++) {
            for (int j = i+1; j >0; j--) {
                if (ints[j]<ints[j-1]){
                    int temp = ints[j];
                    ints[j] = ints[j-1];
                    ints[j-1] = temp;
                }else{
                    break;
                }
            }
        }
    }
}
