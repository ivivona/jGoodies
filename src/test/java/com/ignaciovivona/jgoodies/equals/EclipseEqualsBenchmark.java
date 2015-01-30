package com.ignaciovivona.jgoodies.equals;

import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

@BenchmarkMethodChart(filePrefix = "equals-benchmark-eclipse")
public class EclipseEqualsBenchmark extends EqualsBenchmark {

	@Override
	protected boolean equals(Object a, Object b) {
		return a.equals(b);
	}

}