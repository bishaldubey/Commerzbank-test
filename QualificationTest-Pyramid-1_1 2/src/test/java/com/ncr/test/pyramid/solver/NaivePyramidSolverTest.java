package com.ncr.test.pyramid.solver;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.data.PyramidGenerator;
import com.ncr.test.pyramid.data.impl.RandomPyramidGenerator;
import com.ncr.test.pyramid.solver.impl.NaivePyramidSolver;

public class NaivePyramidSolverTest {

    private static final int[][] SAMPLE_DATA = {
            { 1, 7, 8, 4 },
            { 10, 4, 5, 0 },
            { 2, 5, 0, 0 },
            { 3, 0, 0, 0 }
    };
    private static final int[][] DEMO_DATA = {
            { 44, 100, 98, 79 },
            { 62,   1, 44,  0 },
            { 3,  24,  0,  0 },
            { 23,   0,  0,  0 }
    };

    protected PyramidSolver solver;
    
    @Before
    public void setUp() {
        solver = new NaivePyramidSolver();
    }

    @Test
    public void naivePyramidSolverHandlesSampleData() {
        Pyramid pyramid = new Pyramid(SAMPLE_DATA);
        assertEquals("Max path in Sample pyramid", 22, solver.pyramidMaximumTotal(pyramid));
    }

    @Test
    public void naivePyramidSolverHandlesDemoData() {
        Pyramid pyramid = new Pyramid(DEMO_DATA);
        assertEquals("Max path in Demo pyramid", 189, solver.pyramidMaximumTotal(pyramid));
    }

    @Test
    public void naivePyramidSolverHandlesRandomData() {
        RandomPyramidGenerator.setRandSeed(25321L);
        final PyramidGenerator generator = new RandomPyramidGenerator(5, 99);
        final Pyramid pyramid = generator.generatePyramid();

        assertEquals("Max path in 'random' pyramid", 398, this.solver.pyramidMaximumTotal(pyramid));
    }

}
