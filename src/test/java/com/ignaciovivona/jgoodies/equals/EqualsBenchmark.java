package com.ignaciovivona.jgoodies.equals;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.LabelType;

@BenchmarkOptions
@AxisRange(min = 0, max = 1)
@BenchmarkHistoryChart(labelWith = LabelType.TIMESTAMP, maxRuns = 20)
public abstract class EqualsBenchmark extends AbstractBenchmark {

	@Test
	public void testSameObjectWithFewFields() {
		Few a = newFew();
		assertTrue(equals(a, a));
	}
	
	@Test
	public void testEqualObjectsWithFewFields() {
		Few a = newFew();
		Few b = newFew();
		assertTrue(equals(a, b));
	}
	
	@Test
	public void testDifferentObjectsWithFewFields() {
		Few a = newFew();
		Few b = newFew();
		b.getC().setA(0);
		assertFalse(equals(a, b));
	}
	
	@Test
	public void testSameObjectWithManyFields() {
		Many a = newMany();
		assertTrue(equals(a, a));
	}
	
	@Test
	public void testEqualObjectsWithManyFields() {
		Many a = newMany();
		Many b = newMany();
		assertTrue(equals(a, b));
	}
	
	@Test
	public void testDifferentObjectsWithManyFields() {
		Many a = newMany();
		Many b = newMany();
		b.getI().setA(0);
		assertFalse(equals(a, b));
	}
	
	@Test
	public void testFewInList() {
		List<Few> fews = new ArrayList<>();
		for(int i=0; i < 10000; i++) {
			fews.add(newFew());
		}
		Few one = fews.get(9999);
		one.getC().setA(1);
		assertTrue(fews.stream().anyMatch(f -> equals(f, one)));
	}
	
	@Test
	public void testManyInList() {
		List<Many> manys = new ArrayList<>();
		for(int i=0; i < 10000; i++) {
			manys.add(newMany());
		}
		Many one = manys.get(9999);
		one.getC().setA(1);
		assertTrue(manys.stream().anyMatch(f -> equals(f, one)));
	}
	
	protected Few newFew() {
		Few newInstance = new Few();
		newInstance.setA(10);
		newInstance.setB("Hello World!");
		newInstance.setC(newNested());
		return newInstance;
	}
	
	protected Many newMany() {
		Many newInstance = new Many();
		newInstance.setA(12031203);
		newInstance.setB("akshfakfhaslfjdalsdkasldkas");
		newInstance.setC(newNested());
		newInstance.setD(123123123);
		newInstance.setE("aksfjakjdaksndbobkorgkofkgofkgofgkodfkgfokgoskfg");
		newInstance.setF(newNested());
		newInstance.setG(0);
		newInstance.setH(".....................................................................");
		newInstance.setI(newNested());
		return newInstance;
	}

	private Nested newNested() {
		Nested nested = new Nested();
		nested.setA(1023782);
		return nested;
	}

	protected abstract boolean equals(Object a, Object b);

	public static class Many {
		private int a;
		private String b;
		private Nested c;
		private int d;
		private String e;
		private Nested f;
		private int g;
		private String h;
		private Nested i;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + ((b == null) ? 0 : b.hashCode());
			result = prime * result + ((c == null) ? 0 : c.hashCode());
			result = prime * result + d;
			result = prime * result + ((e == null) ? 0 : e.hashCode());
			result = prime * result + ((f == null) ? 0 : f.hashCode());
			result = prime * result + g;
			result = prime * result + ((h == null) ? 0 : h.hashCode());
			result = prime * result + ((i == null) ? 0 : i.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Many other = (Many) obj;
			if (a != other.a)
				return false;
			if (b == null) {
				if (other.b != null)
					return false;
			} else if (!b.equals(other.b))
				return false;
			if (c == null) {
				if (other.c != null)
					return false;
			} else if (!c.equals(other.c))
				return false;
			if (d != other.d)
				return false;
			if (e == null) {
				if (other.e != null)
					return false;
			} else if (!e.equals(other.e))
				return false;
			if (f == null) {
				if (other.f != null)
					return false;
			} else if (!f.equals(other.f))
				return false;
			if (g != other.g)
				return false;
			if (h == null) {
				if (other.h != null)
					return false;
			} else if (!h.equals(other.h))
				return false;
			if (i == null) {
				if (other.i != null)
					return false;
			} else if (!i.equals(other.i))
				return false;
			return true;
		}
		public int getA() {
			return a;
		}
		public void setA(int a) {
			this.a = a;
		}
		public String getB() {
			return b;
		}
		public void setB(String b) {
			this.b = b;
		}
		public Nested getC() {
			return c;
		}
		public void setC(Nested c) {
			this.c = c;
		}
		public int getD() {
			return d;
		}
		public void setD(int d) {
			this.d = d;
		}
		public String getE() {
			return e;
		}
		public void setE(String e) {
			this.e = e;
		}
		public Nested getF() {
			return f;
		}
		public void setF(Nested f) {
			this.f = f;
		}
		public int getG() {
			return g;
		}
		public void setG(int g) {
			this.g = g;
		}
		public String getH() {
			return h;
		}
		public void setH(String h) {
			this.h = h;
		}
		public Nested getI() {
			return i;
		}
		public void setI(Nested i) {
			this.i = i;
		}
	}
	
	public static class Few {
		private int a;
		private String b;
		private Nested c;
		
		public int getA() {
			return a;
		}
		public void setA(int a) {
			this.a = a;
		}
		public String getB() {
			return b;
		}
		public void setB(String b) {
			this.b = b;
		}
		public Nested getC() {
			return c;
		}
		public void setC(Nested c) {
			this.c = c;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + ((b == null) ? 0 : b.hashCode());
			result = prime * result + ((c == null) ? 0 : c.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Few other = (Few) obj;
			if (a != other.a)
				return false;
			if (b == null) {
				if (other.b != null)
					return false;
			} else if (!b.equals(other.b))
				return false;
			if (c == null) {
				if (other.c != null)
					return false;
			} else if (!c.equals(other.c))
				return false;
			return true;
		}
		
	}
	
	public static class Nested {
		private int a;
		
		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Nested other = (Nested) obj;
			if (a != other.a)
				return false;
			return true;
		}

	}
	
}