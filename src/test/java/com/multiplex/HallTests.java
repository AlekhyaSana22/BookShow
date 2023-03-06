package com.multiplex;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
 
import org.junit.Before;
import org.junit.Test;
 
import com.multiplex.entities.Hall;
import com.multiplex.entities.Movie;
 
public class HallTests {
 
    private Hall hall;
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        movie = new Movie();
        movie.setMovieId(1);
        hall = new Hall();
        hall.setHallId(1);
        hall.setMovie(movie);
        hall.setSeatsNo(100);
    }
 
    @Test
    public void testHall() {
        assertNotNull(hall);
    }
 
    @Test
    public void testGetHallId() {
        assertEquals(Integer.valueOf(1), hall.getHallId());
    }
 
    @Test
    public void testSetHallId() {
        hall.setHallId(2);
        assertEquals(Integer.valueOf(2), hall.getHallId());
    }
 
    @Test
    public void testGetMovie() {
        assertEquals(movie, hall.getMovie());
    }
 
    @Test
    public void testSetMovie() {
        Movie newMovie = new Movie();
        newMovie.setMovieId(2);

        hall.setMovie(newMovie);
        assertNotEquals(movie, hall.getMovie());
        assertEquals(newMovie, hall.getMovie());
    }
 
    @Test
    public void testGetSeatsNo() {
        assertEquals(Integer.valueOf(100), hall.getSeatsNo());
    }
 
    @Test
    public void testSetSeatsNo() {
        hall.setSeatsNo(200);
        assertEquals(Integer.valueOf(200), hall.getSeatsNo());
    }
 
    @Test
    public void testHashCode() {
        Hall newHall = new Hall();
        newHall.setHallId(1);
        newHall.setMovie(movie);
        newHall.setSeatsNo(100);

        assertEquals(newHall.hashCode(), hall.hashCode());
    }
 
    @Test
    public void testEqualsObject() {
        Hall newHall = new Hall();
        newHall.setHallId(1);
        newHall.setMovie(movie);
        newHall.setSeatsNo(100);

        assertEquals(newHall, hall);
    }
 
}



