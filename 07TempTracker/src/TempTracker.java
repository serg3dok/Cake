import java.util.Arrays;

/**
 * Created by sergeyo on 6/22/2017.
 */

class Temperature {
    int maxTemperature;
    int minTemperature;
    int numberOfValues;
    int sumOfValues;
    double mean;
    int mode;
    int[] temperaturesArr = new int[110];

    public Temperature() {
        maxTemperature = Integer.MIN_VALUE;
        minTemperature = Integer.MAX_VALUE;
        numberOfValues = 0;
        sumOfValues = 0;
        mean = 0;
        mode = 0;
    }

    public void addTemp (int t) {
        maxTemperature = Math.max(t, maxTemperature);
        minTemperature = Math.min(t, minTemperature);
        numberOfValues++;
        sumOfValues += t;
        temperaturesArr[t]++;
        mean = (double) sumOfValues / numberOfValues;

        Arrays.sort(temperaturesArr);
        mode = temperaturesArr[temperaturesArr.length-1];
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public double getMean() {
        return mean;
    }

    public int getMode() {
        return mode;
    }






}

public class TempTracker {



    public static void main(String[] args) {

        int[] temperatures = {25, 10, 22, 4, 1, 16, 108 };

        Temperature temp = new Temperature();
        for (int i = 0; i < temperatures.length; i++) {
            temp.addTemp(temperatures[i]);
        }
        System.out.println("max: " + temp.getMaxTemperature());
        System.out.println("min: " + temp.getMinTemperature());
        System.out.println("mean: " + temp.getMean());
        System.out.println("mode: " + temp.getMode());




    }


}
