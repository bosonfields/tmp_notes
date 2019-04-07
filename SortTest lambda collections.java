//This is a test to compare time consumptions
//between collections.sort(based on class) and lambda sort.
//The result shows that using lambda cost a lot of time.

package com.company;

import java.lang.reflect.Array;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        int[][] courses = {{100,200},{200, 1300},{1000, 1250}, {2000, 3200}};
        long start_1 = System.nanoTime();
        Arrays.sort(courses, (a, b) -> a[1]-b[1]);
        //PriorityQueue<Integer> selected = new PriorityQueue<>((a,b)->(b-a));
        long end_1 = System.nanoTime();
        System.out.println("lambda sort time:" + (end_1-start_1));


        long start_2 = System.nanoTime();
        List<Pair> list = new ArrayList<>();
        for(int i=0; i<courses.length;i++){
            Pair p = new Pair(courses[i][1],courses[i][0]);
            list.add(p);
        }
        Collections.sort(list);
        long end_2 = System.nanoTime();
        System.out.println("collection sort based on class:" + (end_2-start_2));


    }
    static class Pair implements Comparable<Pair>{
        int limit;
        int length;
        public Pair(int limit, int length){
            this.limit = limit;
            this.length =length;
        }

        @Override
        public int compareTo(Pair p1){
            return this.limit -p1.limit;
        }

    }
}
