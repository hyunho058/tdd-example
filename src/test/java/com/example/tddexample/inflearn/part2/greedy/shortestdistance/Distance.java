package com.example.tddexample.inflearn.part2.greedy.shortestdistance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Distance {
    public int calculateMinimumHarvestTime(int[] plantTime, int[] growTime) {
        List<Flower> flowers = new ArrayList<>();
        for (int i = 0; i < plantTime.length; i++) {
            flowers.add(new Flower(plantTime[i], growTime[i]));
        }
        Collections.sort(flowers);

        int plantDate = Integer.MIN_VALUE;
        int harvest = Integer.MIN_VALUE;
        for (Flower flower : flowers) {
            int period = flower.harvestPeriod();

            if (harvest < plantDate + period) {
                harvest = plantDate + period;
            }

            plantDate += flower.getPlantTime();
        }

        return harvest;
    }

    protected static class Flower implements Comparable<Flower> {
        private final int plantTime;
        private final int growTime;

        public Flower(int plantTime, int growTime) {
            this.plantTime = plantTime;
            this.growTime = growTime;
        }

        public int harvestPeriod() {
            return this.plantTime + this.growTime;
        }

        @Override
        public int compareTo(Flower o) {
            //grow 내림차순 정렬
            if (this.growTime == o.getGrowTime()) {
                return this.plantTime - o.getPlantTime();
            }
            return o.getGrowTime() - this.growTime;
        }

        public int getPlantTime() {
            return plantTime;
        }

        public int getGrowTime() {
            return growTime;
        }
    }
}
