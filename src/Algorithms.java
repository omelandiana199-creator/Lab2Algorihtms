public class Algorithms {

    // Рівень 1: Наївний
    public static boolean hasDuplicateNaive(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] == data[j]) return true;
            }
        }
        return false;
    }

    // Рівень 2: Швидкий
    public static boolean hasDuplicateFast(int[] data, int maxVal) {
        boolean[] seen = new boolean[maxVal + 1];
        for (int i = 0; i < data.length; i++) {
            if (seen[data[i]]) return true;
            seen[data[i]] = true;
        }
        return false;
    }

    // Рівень 3: Оптимальний
    public static boolean hasDuplicateBalanced(int[] data) {
        int[] sorted = data.clone();
        quickSort(sorted, 0, sorted.length - 1);

        for (int i = 0; i < sorted.length - 1; i++) {
            if (sorted[i] == sorted[i + 1]) return true;
        }
        return false;
    }


    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static int calculateHash(String s, int M) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash + (long) s.charAt(i) * (i + 1)) % M;
        }
        return (int) hash;
    }
}
