package sort;

public class Quick {
    public void quickSort(int[] ints){
        quickSortC(ints,0,ints.length-1);


    }
    public void quickSortC(int[] ints,int p,int r){
        if (p>=r){
            return;
        }
        int div = partition(ints, p, r);
        quickSortC(ints,p,div-1);
        quickSortC(ints,div+1,r);
    }

    public int partition(int[] ints ,int p,int r){
        int div = r;
        int i = p,j = p;
        while(j<=r){
            if (j == r) {
                swap(ints,i,div);
                div = i;
                break;
            }
          if (ints[j]<ints[div]){
              swap(ints,i,j);
              i++;
          }
          j++;
        }
        return div;
    }
    public void swap(int[] ints,int i,int j){
        if (i==j){
            return;
        }
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }
}
