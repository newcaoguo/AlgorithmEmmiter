package com.company;

import org.junit.Test;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /**
         * I have thought for a long time and got two ideas:
         *
         * If car starts at A and can not reach B.
         * Any station between A and B can not reach B.
         * (B is the first station that A can not reach.)
         * If the total number of gas is bigger than the total number of cost.
         * There must be a solution.(Should I prove them?)
         * Here is my solution based on those ideas:
         */
        int start = 0;
        int total = 0;
        int tank = 0;
        //if car fails at 'start', record the next station
        for (int i = 0; i < gas.length; i++)
            if ((tank = tank + gas[i] - cost[i]) < 0) {
                start = i + 1;
                total += tank;
                tank = 0;
            }
        return (total + tank < 0) ? -1 : start;
    }

    @Test
    public void test() {

    }
}
