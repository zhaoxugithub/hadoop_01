package com.ch01;

import java.util.ArrayList;
import java.util.List;

public class Offer_041_MovingAverage {
    private List<Integer> list = new ArrayList<Integer>();
    int start =0;
    int end =0;
    /** Initialize your data structure here. */
    public Offer_041_MovingAverage(int size) {
        start = -1;
        end = size + start-1;
    }

    public double next(int val) {
        list.add(val);
        start++;
        end++;
        int sum = 0;
        if(end >= list.size()){
            end = list.size();
        }
        for(int i = start;i<end;i++){
            sum+=list.get(i);
        }
        return sum*1.0 / (end-start);
    }

    public static void main(String[] args) {
        Offer_041_MovingAverage offer_041_movingAverage = new Offer_041_MovingAverage(3);
        double next = offer_041_movingAverage.next(1);
        System.out.println(next);
    }
}
