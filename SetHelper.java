import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ramona Graham on 1/22/2015.
 * IT 333, Data Structures, Winter Quarter 2015.
 * Instructor: Ken Hang
 * Assignment: SetProgramming
 * Movie objects are created, then added to created Sets (movie categories),
 * made selective lists, then playList Queue.
 */
public class SetHelper<E> {


    /**
     * Returns objects in common to both sets
     * @param s1 first set from Movie object created in main()
     * @param s2 second set from Movie object created in main()
     * @return intersection
     */
    public Set<E> intersect(Set<E> s1, Set<E> s2) {
        Set<E> intersection = new HashSet<E>(s1);
        intersection.retainAll(s2);
        return intersection;
    }


    /**
     * Returns all objects from both sets
     * @param s1 first set from Movie object created in main()
     * @param s2 second set from Movie object created in main()
     * @return union of both sets
     */
    public Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> union = new HashSet<E>(s1);
        union.addAll(s2);
        return union;
    }

    /**
     * Returns one set minus the other set
     * @param s1 first set from Movie object created in main()
     * @param s2 second set from Movie object created in main()
     * @return the difference
     */
    public Set<E> difference(Set<E> s1, Set<E> s2) {
        Set<E> difference = new HashSet<E>(s1);
        difference.removeAll(s2);
        return difference;
    }

    /**
     * Returns  what is exclusive to set1 then exclusive to set2, excludes the intersection
     * @param s1 first set from Movie object created in main()
     * @param s2 second set from Movie object created in main()
     * @return the symmetricDifference of both sets
     */
    public Set<E> symmetricDifference(Set<E> s1, Set<E> s2) {
        Set<E> unionOfS1AndS2 = union(s1, s2);
        Set<E> intersectOfS1AndS2 = intersect(s1, s2);
        Set<E> symDiff = difference(unionOfS1AndS2, intersectOfS1AndS2);
        return symDiff;
    }

}
