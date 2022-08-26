import lombok.ToString;

import java.util.*;

public class Binance {
    public static void main(String[] args) {
        int[] data = {2,3,1,4,5,8};
//        System.out.println(Arrays.toString(sort(data)));

        // created an unsorted array
        int[] array = { 6, 5, 12, 10, 9, 1 };

        // call the method mergeSort()
        // pass argument: array, first index and last index
        mergeSort(array, 0, array.length - 1);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(array));


        Teacher t1 = new Teacher("james", 45);
        Teacher t2 = new Teacher("Lauren", 35);
        Teacher t3 = new Teacher("albert", 55);


        List<Teacher> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        System.out.println(list);
        list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

//        Collections.sort(list);
//        System.out.println(list);
    }

    // array {2,3,1,4,5,8} input
    // 2 1

    // array {1,2,3,4,5,8} output

    static int[] sort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int temp = data[j];
                    data[j] = data[i];
                    data[i] = temp;
                }
            }
        }
        return data;
    }

    static void mergeSort(int[] array, int left, int right) {
        // Divide the array into two sub arrays, sort them and merge them

        if (left < right) {

            // m is the point where the array is divided into two sub arrays
            int mid = (left + right) / 2;

            // recursive call to each sub arrays
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted sub arrays
            merge(array, left, mid, right);
        }
    }
    // fill the left and right array
    // Maintain current index of sub-arrays and main array
    // Until we reach either end of either arr1 or arr2, pick larger among
    // elements arr1 and arr2 and place them in the correct position at A[p...r]
    // for sorting in descending
    // use if(arr1[i] >= <[j])
    static void merge(int[] array, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        System.arraycopy(array, p, arr1, 0, n1);
        for (int j = 0; j < n2; j++)
            arr2[j] = array[q + 1 + j];


        int i, j, k;
        i = 0;
        j = 0;
        k = p;


        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                array[k] = arr1[i];
                i++;
            } else {
                array[k] = arr2[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either arr1 or arr2,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            array[k] = arr1[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = arr2[j];
            j++;
            k++;
        }
    }


}

// teacher
// name
// age
@ToString
class Teacher implements Comparable<Teacher>{
    String name;
    int age;

    Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Teacher o) {
        return this.age - o.age;
    }
}
