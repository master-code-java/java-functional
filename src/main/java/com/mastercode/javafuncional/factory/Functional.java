package com.mastercode.javafuncional.factory;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.mastercode.javafuncional.interfaces.Block;

public class Functional<T> {

	private final T value;

	private Functional() {
		this.value = null;
	}

	private Functional(T value) {
		this.value = value;
	}

	public T get() {
		if (value == null) {
			throw new NoSuchElementException("No value present");
		}
		return value;
	}

	public static <T> Functional<T> of(T value) {
		return new Functional<>(value);
	}

	public Functional<T> also(Block<T> block) {
		return of(block.read(value));
	}

	public <R> Functional<R> let(Function<T, R> function) {
		return of(function.apply(value));
	}

	public void run(Consumer<T> param) {
		param.accept(value);
	}

	public Functional<T> sameOrElse(Block<T> block) {
		if (this.value != null) {
			return this;
		} else {
			return of(block.read(value));
		}
	}

	public <X extends Throwable> Functional<T> 
	sameOrThrow(Supplier<? extends X> exceptionSupplier) throws X {
		if (value != null) {
			return this;
		} else {
			throw exceptionSupplier.get();
		}
	}
}
