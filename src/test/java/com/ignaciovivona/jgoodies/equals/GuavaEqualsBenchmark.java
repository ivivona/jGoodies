package com.ignaciovivona.jgoodies.equals;

import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;
import com.google.common.base.Objects;

@BenchmarkMethodChart(filePrefix = "equals-benchmark-guava")
public class GuavaEqualsBenchmark extends EqualsBenchmark {

	@Override
	protected boolean equals(Object a, Object b) {
		if (a == b)
			return true;
		if (a == null)
			return false;
		if (b == null)
			return false;
		if (a.getClass() != b.getClass())
			return false;
		if (a instanceof Few && b instanceof Few) {
			Few fa = (Few) a;
			Few fb = (Few) b;
			return Objects.equal(fa.getA(), fb.getA())
					&& Objects.equal(fa.getB(), fb.getB())
					&& Objects.equal(fa.getC(), fb.getC());
		}
		if (a instanceof Many && b instanceof Many) {
			Many ma = (Many) a;
			Many mb = (Many) b;
			return Objects.equal(ma.getA(), mb.getA())
					&& Objects.equal(ma.getB(), mb.getB())
					&& Objects.equal(ma.getC(), mb.getC())
					&& Objects.equal(ma.getD(), mb.getD())
					&& Objects.equal(ma.getE(), mb.getE())
					&& Objects.equal(ma.getF(), mb.getF())
					&& Objects.equal(ma.getG(), mb.getG())
					&& Objects.equal(ma.getH(), mb.getH())
					&& Objects.equal(ma.getI(), mb.getI());
		}
		return false;
	}

}