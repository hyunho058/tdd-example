package com.example.tddexample.programmers.q42884;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Camera {
    private final int[][] routes;
    private final List<Route> routeList;

    public Camera(int[][] routes) {
        this.routes = routes;
        this.routeList = new ArrayList<>();
    }

    public int minCount() {
        for (int[] route : routes) {
            int in = route[0];
            int out = route[1];
            routeList.add(new Route(in, out));
        }

        Collections.sort(routeList);

        int outTime = routeList.get(0).getOut();
        int count = 1;

        for (int i = 1; i < routeList.size(); i++) {
            Route route = routeList.get(i);
            if (route.isNotIntersection(outTime)) {
                continue;
            }

            outTime = route.getOut();
            count++;
        }

        return count;
    }

    protected static class Route implements Comparable<Route> {
        private final int in;
        private final int out;

        public Route(int in, int out) {
            this.in = in;
            this.out = out;
        }

        public int getIn() {
            return in;
        }

        public int getOut() {
            return out;
        }
        public boolean isNotIntersection(int out) {
            return this.in <= out;
        }
        @Override
        public int compareTo(Route o) {
            return this.out - o.out;
        }
    }
}
