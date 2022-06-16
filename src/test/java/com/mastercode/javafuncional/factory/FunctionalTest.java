package com.mastercode.javafuncional.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FunctionalTest {
	
	@Test
	public void given_object_then_return_an_object() {
		
		Functional.of(new Object())
		.run(System.out::println);

		Object object = Functional.of(new Object())
				.get();

		assertNotNull(object);
		assertTrue(object instanceof Object);

	}

	@Test
	public void given_object_then_return_functional_object() {

		Functional<Object> of = Functional.of(new Object());

		assertNotNull(of);
		assertTrue(of instanceof Functional);
	}

	@Test
	public void given_string_then_return_string_object() {

		String result = Functional.of("Hello World")
				.also(msg -> msg).get();

		assertNotNull(result);
		assertTrue(result instanceof String);

		assertEquals("Hello World", result);

	}

	@Test
	public void given_string_then_return_integer_object() {

		Integer expected = 1;

		Integer result = Functional.of("Hello world")
				.let(msg -> 1)
				.get();

		assertNotNull(result);
		assertTrue(result instanceof Integer);

		assertEquals(expected, result);

	}

	@Test
	public void given_msg_then_print_the_msg() {

		Functional.of("Hello world")
		.run(System.out::println);

	}

	@Test
	public void given_obj_then_return_the_same_object() {
		
		String result = Functional.of("Hello world")
				.orElse(msg -> "Hello world fail")
				.get();
		
		assertNotNull(result);
		assertTrue(result instanceof String);

		assertEquals("Hello world", result);
	
	}
	
	@Test
	public void given_null_then_return_the_other_object() {
		
		Object object = Functional.of(null)
				.orElse(msg -> "Hello world")
				.get();
		
		assertNotNull(object);
		assertTrue(object instanceof String);

		assertEquals("Hello world", object);
	
	}
	

	@Test(expected = Exception.class)
	public void given_null_then_throw_exception() throws Exception {
		
		Functional.of(null)
				.orElse(() -> new Exception())
				.get();
	}
	
	@Test()
	public void given_object_then_not_throw_exception() throws Exception {
		
		Object object = Functional.of(new Object())
				.orElse(() -> new Exception())
				.get();
		
		assertNotNull(object);
		assertTrue(object instanceof Object);

	}
}
