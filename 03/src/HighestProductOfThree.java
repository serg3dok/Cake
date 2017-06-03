import java.util.LinkedList;
import java.util.List;

/**
 * Created by sergeyo on 6/2/2017.
 */
public class HighestProductOfThree {
    public static void main(String[] args) {
        int[] testData = {1, 3, 5, 2, 4, 0, 7};
        System.out.println(getHighestProductOfThree(testData));;
    }

    public static int getHighestProductOfThree(int[] input) {

        List<Integer> positiveList = new LinkedList<Integer>();
        List<Integer> negativeList = new LinkedList<Integer>();
        positiveList.add(0);
        negativeList.add(0);

        for (int current : input) {
            if (current < 0 ) {
                if (current > negativeList.get(0) && negativeList.size() < 2) {
                    int tmp = negativeList.get(0);
                    negativeList.add(0, current);
                    negativeList.add(0, tmp);
                } else if (current < negativeList.get(0)) {
                    negativeList.add(0, current);
                }
                if (negativeList.size() > 2) {
                    negativeList.remove(2);
                }
            } else  {
                if (current < positiveList.get(0) && positiveList.size() < 3) {
                    int tmp = positiveList.get(0);
                    positiveList.add(0, current);
                    positiveList.add(0, tmp);
                } else if (current > positiveList.get(0)) {
                    positiveList.add(0, current);
                }
                if (positiveList.size() > 3) {
                    positiveList.remove(3);
                }
            }
        }

        int maxPositive = positiveList.get(0);
        int negativeProduct = 1;
        int positiveProduct = 1;
        if (negativeList.size() > 1) {
            negativeProduct = negativeList.get(0) * negativeList.get(1);
        }
        if (positiveList.size() > 2) {
            positiveProduct = positiveList.get(1) * positiveList.get(2);
        }


        return Math.max(maxPositive * positiveProduct, maxPositive * negativeProduct);
    }
}
