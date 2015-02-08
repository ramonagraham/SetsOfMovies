import java.util.*;

/**
 * Created by Ramona Graham on 1/22/2015.
 * IT 333, Data Structures, Winter Quarter 2015.
 * Instructor: Ken Hang
 * Assignment: SetProgramming
 * Movie objects are created, then added to created Sets (movie categories),
 * made selective lists, then playList Queue.
 */
public class MovieDriver {
    /**
     * Created Movie objects, Sets (categories), Selective movie lists and maps
     * @param args none
     */
    public static void main(String[] args) {

        System.out.println("Welcome to Moviefone");

        /**
         * Movie objects created with movie title, year released
         */
        Movie m1 = new Movie("Frozen", 2013);
        Movie m2 = new Movie("Star Trek", 2009);
        Movie m3 = new Movie("Rumble in the Bronx", 1995);
        Movie m4 = new Movie("Star Trek: First Contact", 1996);
        Movie m5 = new Movie("Castaway", 2000);
        Movie m6 = new Movie("Get Shorty", 1995);
        Movie m7 = new Movie("Bewitched", 2005);
        Movie m8 = new Movie("The Matrix", 1999);


        /**
         * Movie sets created as movie categories
         */
        Set<Movie> library = new HashSet<Movie>();
        Set<Movie> favorites = new HashSet<Movie>();
        Set<Movie> watched = new HashSet<Movie>();
        Set<Movie> recentlyWatched = new HashSet<Movie>();
        Set<Movie> comedy = new HashSet<Movie>();
        Set<Movie> drama = new HashSet<Movie>();
        Set<Movie> scienceFiction = new HashSet<Movie>();
        Set<Movie> action = new HashSet<Movie>();

        Set<Movie> watched2 = new HashSet<Movie>(library);

        /**
         * Movie objects added to sets/categories
         */
        library.add(m1);
        library.add(m2);
        library.add(m3);
        library.add(m4);
        library.add(m5);
        library.add(m6);
        library.add(m7);
        library.add(m8);

        favorites.add(m2);
        favorites.add(m7);

        action.add(m2);
        action.add(m6);
        action.add(m8);

        comedy.add(m6);
        comedy.add(m7);

        drama.add(m5);
        drama.add(m6);

        scienceFiction.add(m2);
        scienceFiction.add(m4);
        scienceFiction.add(m8);

        recentlyWatched.add(m1);
        recentlyWatched.add(m2);
        recentlyWatched.add(m4);
        recentlyWatched.add(m7);
        recentlyWatched.add(m8);

        watched.add(m1);
        watched.add(m2);
        watched.add(m4);
        watched.add(m5);
        watched.add(m7);
        watched.add(m8);


        /**
         * Sets and contents printed
         */
        System.out.println("\n");
        System.out.println("Printout of Sets of Movies");
        System.out.println("Library is: " + library);
        System.out.println("Favorites is: " + favorites);
        System.out.println("Watched is: " + watched);
        System.out.println("Recently watched is: " + recentlyWatched);
        System.out.println("Comedy is: " + comedy);
        System.out.println("Drama is: " + drama);
        System.out.println("Science Fiction is: " + scienceFiction);
        System.out.println("Action is: " + action);

        /**
         * Favorite movies using an Iterator
         */
        Iterator<Movie> currentFav = favorites.iterator();
        System.out.println("\n");
        System.out.println("Favorite Movies: ");
        System.out.println(currentFav.next()); //moves to item1
        System.out.println(currentFav.next()); // moves to item2



        /**
         * Using the SetHelper class to retrieve selective movie lists
         */
        SetHelper helper = new SetHelper();

        /**
         * Drama movies watched
         */
        Set<Movie> watchedDramas = helper.intersect(watched, drama);
        System.out.println("\n");
        System.out.println("Watched Dramas: " + watchedDramas);


        /**
         * Movies not watched from the library
         */
        Set<Movie> unwatched = helper.difference(library, watched);
        System.out.println("Unwatched movies from the Library: " + unwatched);


        /**
         * Comedies not seen
         */
        Set<Movie> unwatchedComedy = helper.difference(unwatched, comedy);
        System.out.println("Unwatched non Comedies: " + watchedDramas);

        /**
         * Favorite comedies
         */
        Set<Movie> favoriteNonComedies = helper.intersect(favorites, comedy);
        System.out.println("Favorite comedies: " + favoriteNonComedies);


        /**
         * Movies not watched after 2010
         */
        Set<Movie> unwatchedNewReleases = new HashSet<Movie>();
        Iterator<Movie> currMovie = unwatched.iterator();
        while (currMovie.hasNext()) {
            Movie temp = currMovie.next();
            if (temp.getYear() >= 2010) {
                unwatchedNewReleases.add(temp);
            }
        }
        System.out.println("\n");
        System.out.println("Unwatched new releases: " + unwatchedNewReleases);


        /**
         * Watched movies before and including 2000
         */
        Set<Movie> watchedFormerRelease = new HashSet<Movie>();
        Iterator<Movie> formerMovie = watched.iterator();
        while (formerMovie.hasNext()) {
            Movie temp = formerMovie.next();
            if (temp.getYear() <= 2000) {
                watchedFormerRelease.add(temp);
            }
        }
        System.out.println("Watched former releases: " + watchedFormerRelease);


        /**
         * Unwatched action comedies
         */
        Set<Movie> actionComedy = helper.union(action, comedy);
        Set<Movie> unwatchedActionComedy = helper.intersect(actionComedy, unwatched);
        System.out.println("Unwatched action comedies: " + unwatchedActionComedy);


        // How many times a movie was watched
        Map<Movie, Integer> watchedCount = new HashMap<Movie, Integer>();
        watchedCount.put(m2, 3);
        watchedCount.put(m5, 1);
        watchedCount.put(m7, 2);
        watchedCount.put(m4, 6);
        watchedCount.put(m1, 2);
        watchedCount.put(m8, 4);

        int howManyTimes = watchedCount.get(m1);
        System.out.println("Watched count for movies is: " + watchedCount);


        // Movie Queue created and movies added to playList
        Queue<Movie> playList = new LinkedList<Movie>();
        playList.add(m1);
        playList.add(m2);
        playList.add(m3);
        playList.add(m4);
        playList.add(m8);

        // remove first two movies from the playList Queue
        playList.remove(m1);
        playList.remove(m2);

    }
}
