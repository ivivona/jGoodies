package com.ignaciovivona.jgoodies;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public final class Equality<T> {

	private List<Function<T, Object>> properties = new ArrayList<>();

	public Equality() {
		super();
	}

	public Equality(Function<T, Object> property) {
		this();
		this.over(property);
	}

	public Equality<T> over(Function<T, Object> property) {
		properties.add(property);
		return this;
	}

	public <R> Equality<T> over(Function<T, R> property,
			Function<R, Object> nested) {
		properties.add((T t) -> {
			if (t == null)
				return singleton();
			R result = property.apply(t);
			if (result == null)
				return singleton();
			return nested.apply(result);
		});
		return this;
	}

	protected Object singleton() {
		return new Object();
	}

	public <R, R1> Equality<T> over(Function<T, R> property,
			Function<R, R1> nested, Function<R1, Object> nested1) {
		properties.add((T t) -> {
			if (t == null)
				return singleton();
			R result = property.apply(t);
			if (result == null)
				return singleton();
			R1 result1 = nested.apply(result);
			if (result1 == null)
				return singleton();
			return nested1.apply(result1);
		});
		return this;
	}

	@SuppressWarnings("unchecked") // Stupid Java and type erasure
	public boolean asserts(T lhs, Object rhs) {
		if (lhs == rhs)
			return true;
		if (lhs == null)
			return false;
		if (rhs == null)
			return false;
		if (lhs.getClass() != rhs.getClass())
			return false;
		return properties.stream().allMatch(
				p -> Objects.equals(p.apply(lhs), p.apply((T) rhs)));
	}

}
