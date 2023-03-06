package com.multiplex;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import com.multiplex.entities.Movie;

public class MovieTests {

	private Movie movie;

	@Before
	public void setUp() {
		movie = new Movie();
	}

	@Test
	public void testMovieConstructor() {
		Integer movieId = 1;
		String movieName = "Lion King";
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();

		movie = new Movie(movieId, movieName, date, time);

		assertEquals(movieId, movie.getMovieId());
		assertEquals(movieName, movie.getMovieName());
		assertEquals(date, movie.getDate());
		assertEquals(time, movie.getTime());
	}

	@Test
	public void testGettersAndSetters() {
		Integer movieId = 1;
		String movieName = "Lion King";
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();

		movie.setMovieId(movieId);
		movie.setMovieName(movieName);
		movie.setDate(date);
		movie.setTime(time);

		assertEquals(movieId, movie.getMovieId());
		assertEquals(movieName, movie.getMovieName());
		assertEquals(date, movie.getDate());
		assertEquals(time, movie.getTime());
	}

	@Test
	public void testHashCodeAndEquals() {
		Integer movieId1 = 1;
		String movieName1 = "Lion King";
		LocalDate date1 = LocalDate.now();
		LocalTime time1 = LocalTime.now();

		Integer movieId2 = 2;
		String movieName2 = "Life of Pie";
		LocalDate date2 = LocalDate.now().plusDays(1);
		LocalTime time2 = LocalTime.now().plusHours(1);

		Movie movie1 = new Movie(movieId1, movieName1, date1, time1);
		Movie movie2 = new Movie(movieId1, movieName1, date1, time1);
		Movie movie3 = new Movie(movieId2, movieName2, date2, time2);

		assertTrue(movie1.equals(movie2));
		assertFalse(movie1.equals(movie3));

		assertEquals(movie1.hashCode(), movie2.hashCode());
		assertFalse(movie1.hashCode() == movie3.hashCode());
	}

	@Test
	public void testToString() {
		assertNotNull(movie.toString());
	}

}
