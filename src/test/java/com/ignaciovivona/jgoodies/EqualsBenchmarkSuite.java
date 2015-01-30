package com.ignaciovivona.jgoodies;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ignaciovivona.jgoodies.equals.EclipseEqualsBenchmark;
import com.ignaciovivona.jgoodies.equals.EqualityBenchmark;
import com.ignaciovivona.jgoodies.equals.GuavaEqualsBenchmark;

@RunWith(Suite.class)
@SuiteClasses({
	EclipseEqualsBenchmark.class,
	EqualityBenchmark.class,
	GuavaEqualsBenchmark.class
})
public class EqualsBenchmarkSuite {

}