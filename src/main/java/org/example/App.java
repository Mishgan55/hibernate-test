package org.example;


import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main( String[] args ) {
        Configuration configuration= new Configuration().addAnnotatedClass(Director.class).
                addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            currentSession.beginTransaction();

//            Director director= currentSession.get(Director.class,1);
//            List<Movie> movies = director.getMovies();
//            System.out.println(movies);

//            Movie movie = currentSession.get(Movie.class, 2);
//            Director owner = movie.getOwner();
//            System.out.println(owner);

//            Director director = currentSession.get(Director.class, 5);
//            Movie test_movie = new Movie(director, "Test movie", 2022);
//            director.getMovies().add(test_movie);
//            currentSession.save(test_movie);

//            Director director = new Director("Mikhail Khorsun", 25);
//            Movie movie = new Movie(director, "Test movie 2", 1998);
//            director.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            currentSession.save(director);
//            currentSession.save(movie);
//
//            Director director = currentSession.get(Director.class, 7);
//            Movie movie = currentSession.get(Movie.class, 2);
//            movie.getOwner().getMovies().remove(movie);
//            movie.setOwner(director);
//            director.getMovies().add(movie);

            Director director = currentSession.get(Director.class, 3);
            List<Movie> movies = director.getMovies();
            for (Movie movie : movies) {
                currentSession.remove(movie);
            }
            director.getMovies().clear();

            currentSession.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }


    }
}
