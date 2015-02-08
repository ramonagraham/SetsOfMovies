/**
 * Created by Ramona Graham on 1/22/2015.
 * IT 333, Data Structures, Winter Quarter 2015.
 * Instructor: Ken Hang
 * Assignment: SetProgramming.
 * Movie objects are created, then added to created Sets (movie categories),
 * made selective lists, then playList Queue.
 */
public class Movie {

    private String name;
    private int year;

    /**
     * Initialize new Movie object with Movie title, Year Released
     * @param name Movie object title
     * @param year Movie object year released
     */
    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }


    /**
     * Return Movie Name
     * @return Movie Name
     */
    public String getName(){
        return name;
    }

    /**
     * Return Year Movie Released
     * @return Year movie released
     */
    public int getYear() {
        return year;
    }

    /**
     * Return String format to print Movie name to the console
     * @return String console printout
     */
    public String toString() {
        String result = this.name + " (" + this.year + ")";
        return result;
    }

    /**
     *
     * @param otherMovie compares two Movie objects
     * @return True or False
     */
    public  boolean equals(Movie otherMovie) {
        if (this.name.equals(otherMovie.name) &&
            this.year ==(otherMovie.year)) {
            return true;
        }
        return false;
    }

}
