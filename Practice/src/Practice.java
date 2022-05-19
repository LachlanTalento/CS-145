public class Practice {

    public static void main(String[] args) {

        int[] list = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int size = 11;
        int n = 3;
        int rotate = size - n;
        int current;

        for (int i = 0; i < size; i++) {

                current = list[n - 1];
                list[n] = current;
                current = list[n];

        }
        for (int i = 0; i <= size - 1; i++) {
            System.out.print(list[i]);
            System.out.print(current);
        }
    }
}
