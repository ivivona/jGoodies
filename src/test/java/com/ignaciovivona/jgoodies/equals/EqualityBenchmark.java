package com.ignaciovivona.jgoodies.equals;

import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;
import com.ignaciovivona.jgoodies.Equality;

@BenchmarkMethodChart(filePrefix = "equals-benchmark-equality")
public class EqualityBenchmark extends EqualsBenchmark {

	@Override
	protected boolean equals(Object a, Object b) {
		if (a instanceof Few)
			return new Equality<>(Few::getA)
							.over(Few::getB)
							.over(Few::getC, Nested::getA)
						.asserts((Few)a, b);
		if (a instanceof Many)
			return new Equality<>(Many::getA)
							.over(Many::getB)
							.over(Many::getC, Nested::getA)
							.over(Many::getD)
							.over(Many::getE)
							.over(Many::getF, Nested::getA)
							.over(Many::getG)
							.over(Many::getH)
							.over(Many::getI, Nested::getA)
						.asserts((Many)a, b);
		return false;
	}

}