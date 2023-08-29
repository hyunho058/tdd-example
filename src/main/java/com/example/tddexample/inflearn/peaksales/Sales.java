package com.example.tddexample.inflearn.peaksales;

public class Sales {

    //O(n2)
    public int sum(String record, int k) {
        String[] records = record.split(" ");
        int loopCount = records.length - k + 1;
        int maximum = 0;

        for (int i = 0; i < loopCount; i++) {
            int sum = 0;

            for (int j = 0; j < k; j++) {
                sum += Integer.parseInt(records[i + j]);
            }

            if (maximum < sum) {
                maximum = sum;
            }
        }

        return maximum;
    }

    //O(1)
    public int slidingWindow(String record, int k) {
        String[] records = record.split(" ");
        int maximum = 0;

        for (int i = 0; i < k; i++) {
            maximum += Integer.parseInt(records[i]);
        }

        int sum = maximum;
        for (int i = k; i < records.length; i++) {
            sum -= Integer.parseInt(records[i - k]);
            sum += Integer.parseInt(records[i]);

            if (maximum < sum) {
                maximum = sum;
            }
        }

        return maximum;
    }
}
