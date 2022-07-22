package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieStore implements IRequestHandler {
    private ArrayList<Movie> movies;
    private HashMap<String, Movie> movieMap;

    public MovieStore() {
        this.movies = new ArrayList<>();
        this.movieMap = new HashMap<>();
    }

    public void add(Movie movie) {
        this.movies.add(movie);
        this.movieMap.put(movie.getTitle(), movie);
    }

    public boolean remove(int index) {
        if (index >= this.movies.size()) {
            return false;
        }

        Movie movie = this.movies.get(index);

        this.movies.remove(index);
        this.movieMap.remove(movie.getTitle());
        return true;
    }

    @Override
    public ResultBase handle(Request request) {
        if (this.movies.contains(request.getTitle())) {
            return new OkResult(this.movieMap.get(request.getTitle()));
        }
        return new NotFoundResult();
    }
}
