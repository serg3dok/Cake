public class AppleStocks {
    public static void main(String[] args) {
        int[] stockPrices = { 12, 10, 9, 8, 11, 10 }; // 3
        System.out.println("Best profit: " + calculateBestProfit(stockPrices));


    }

    private static int calculateBestProfit(int[] stockPrices) {
        if (stockPrices.length == 1) return stockPrices[0];
        int minValueTrack = stockPrices[0];
        int maxValueTrack = stockPrices[1];
        int bestProfit = maxValueTrack - minValueTrack;
        if (stockPrices.length == 2) return bestProfit;

        for (int i = 2; i < stockPrices.length; i++) {
            int currentValue = stockPrices[i];
            maxValueTrack = Math.max(maxValueTrack, currentValue);
            minValueTrack = Math.min(minValueTrack, currentValue);
            bestProfit = Math.max(bestProfit, maxValueTrack - minValueTrack);

        }

        return bestProfit;
    }
}
