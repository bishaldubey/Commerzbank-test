package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: There is something wrong here. A few things actually... 
 */
public class NaivePyramidSolver implements PyramidSolver {
    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        return getTotalAbove(pyramid.getRows() - 1, 0, pyramid);
    }

    /**
     * As a result, what I'm getting currently is incorrect. So I examined the NaivePyramidSolver implementation. 
     * At this point, I can tell the issue is with getTotalAbove(int row, int column, Pyramid pyramid) and the problem is with if condition i.e. if (row == 0) return 0; 
     * we are returning 0 when row index value is 0 which is incorrect because array is 0 index based. 
     * As a result, I altered it to if (row == -1) return 0; to consider 0th index row too.
     * I've added NaivePyramidSolverTest class with test cases to demonstrate that NaivePyramidSolver finds the max sum path in a pyramid.
     */
    private long getTotalAbove(int row, int column, Pyramid pyramid) {    	
    	//if (row == 0) return 0;
    	if (row == -1) return 0;

        int myValue = pyramid.get(row, column);
        long left  = myValue + getTotalAbove(row - 1, column, pyramid);
        long right = myValue + getTotalAbove(row - 1, column + 1, pyramid);
        return Math.max(left, right);
    }
}