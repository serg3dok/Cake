/**
 * Created by sergeyo on 6/3/2017.
 */
public class HighestProductOfThree2 {
    public static void main(String[] args) {
        int[] testData = {1, 3, 5, 2, 4, 0, 7, -50, 25, -100};
        System.out.println(getHighestProductOfThree(testData));
    }

    private static int getHighestProductOfThree(int[] arr) {
        int highest = Math.max(arr[0], arr[1]);
        int lowest = Math.min(arr[0], arr[1]);
        int highestProductOf2 = arr[0] * arr[1];
        int lowestProductOf2 = highestProductOf2;
        int highestProductOf3 = highestProductOf2 * arr[2];
        for (int i = 2; i < arr.length; i++) {

            highestProductOf3 = Math.max(Math.max(arr[i] * highestProductOf2, arr[i] * lowestProductOf2), highestProductOf3);


            highestProductOf2 = Math.max(highestProductOf2, highest * arr[i]);
            lowestProductOf2 = Math.min(lowestProductOf2, lowest * arr[i]);


            highest = Math.max(highest, arr[i]);
            lowest = Math.min(highest, arr[i]);
        }

        return highestProductOf3;
    }
}
