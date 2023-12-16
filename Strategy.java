public interface Strategy {
    void sort(int []arr);
}

class BubbleSort implements Strategy{

    @Override
    public void sort(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr.length;j++) {
                if (arr[i]<arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j]= temp;
                }
            }
        }
    }
}

class SelectionSort implements Strategy{
    @Override
    public void sort(int[] arr) {
        for (int i=0;i<arr.length-1;i++) {
            int min = i;
            for (int j=i+1;j<arr.length;j++) {
                if (arr[j]<arr[min]) {
                    int temp = arr[j];
                    arr[j] = arr[min];
                    arr[min] = temp;
                }
            }
        }
    }
}

class SortStrategy {
    private Strategy strategy;
    public SortStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void exeStrategy(int []arr) {
        strategy.sort(arr);
    }
}


class Main {
    public static void main(String[] args) {

        int[] a= new int[]{4, 6, 7, 1, 23};
        SortStrategy sortStrategy = new SortStrategy(new SelectionSort());
        sortStrategy.exeStrategy(a);
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
}