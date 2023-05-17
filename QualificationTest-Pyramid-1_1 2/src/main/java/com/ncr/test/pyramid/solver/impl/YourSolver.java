package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: This is your 3rd task. Please implement the class to satisfy the
 * interface. *
 */
public class YourSolver implements PyramidSolver {

	@Override
	public long pyramidMaximumTotal(Pyramid pyramid) {
		return getTotalAbove(pyramid.getRows(), 0, pyramid.getData());
	}

	/**
	 * The NaivePyramidSolver solution is a recursive strategy that takes time to process the enormous data set. 
	 * I employed the DP in a bottom-up approach to reduce time complexity. 
	 * With my implementation, the solver's time complexity is lowered, and all YourSolverTest test cases pass.
	 */
	static int getTotalAbove(int row, int column, int pyramid[][]) {
		int maxSum = 0;

		// Loop for bottom-up calculation
		for (int i = row - 2; i >= 0; i--) {
			for (int j = 0; j < row - i; j++) {
				if (j - 1 >= 0)
					pyramid[i][j] += Math.max(pyramid[i + 1][j], pyramid[i + 1][j - 1]);
				else
					pyramid[i][j] += pyramid[i + 1][j];

				maxSum = Math.max(maxSum, pyramid[i][j]);
			}
		}

		return maxSum;
	}

}
