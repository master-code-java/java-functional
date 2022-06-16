package com.mastercode.javafuncional.factory;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Functional<T> {

	private final T value;

	private Functional() {
		this.value = null;
	}

	private Functional(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}

	public static <T> Functional<T> of(T value) {
		return new Functional<T>(value);
	}

	public <R> Functional<R> andThen(Function<T, R> function) {
		return of(function.apply(value));
	}

	public void andRun(Consumer<T> consumer) {
		consumer.accept(value);
	}

	public Functional<T> andLog(Consumer<T> consumer) {
		consumer.accept(value);
		return this;
	}

	public Functional<T> orElse(Function<T, T> function) {
		if (this.value != null) {
			return this;
		} else {
			return of(function.apply(value));
		}
	}

	public <X extends Throwable> Functional<T> orElse(Supplier<? extends X> exceptionSupplier) throws X {
		if (value != null) {
			return this;
		} else {
			throw exceptionSupplier.get();
		}
	}
}
