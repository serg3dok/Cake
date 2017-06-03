import java.util.LinkedList;

/**
 * Created by sergeyo on 6/2/2017.
 */
public class HighestProductOfThree {
    public static void main(String[] args) {
        int[] testData = {1, 3, 5, 2, 4, 0, 7, -50, 25, -100};
        System.out.println(getHighestProductOfThree(testData));;
    }

    public static int getHighestProductOfThree(int[] input) {

        LinkedList<Integer> positiveList = new LinkedList<Integer>();
        LinkedList<Integer> negativeList = new LinkedList<Integer>();
        positiveList.add(0);
        negativeList.add(0);

        for (int current : input) {
            if (current < 0 ) {

                pushToNegativeList(negativeList, current);

                if (negativeList.size() > 2) {
                    negativeList.remove(2);
                }
            } else  {

                positiveList = pushToPositiveList(positiveList, current);

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

    public static LinkedList<Integer> pushToPositiveList(LinkedList<Integer> list, int num) {
        int i = 0;
        while (i < list.size() && list.get(i) > num) {
            if (i > 2) {
                return list;
            }
            i++;
        }
        list.add(i, num);
        return list;
    }

    public static LinkedList<Integer> pushToNegativeList(LinkedList<Integer> list, int num) {
        int i = 0;
        while (i < list.size() && list.get(i) < num) {
            if (i > 1) {
                return list;
            }
            i++;
        }
        list.add(i, num);
        return list;
    }
}
