package partie2;

import java.util.List;
import java.util.NoSuchElementException;

public class OutilsGeneriques {

    /** (2 pts) Retourne le max d'une List<T> où T est Comparable.
     * Lève NoSuchElementException si la liste est vide. */
    public static <T extends Comparable<T>> T max(List<T> liste) {
        if (liste.isEmpty()) {
            throw new NoSuchElementException("La liste est vide.");
        }

        T maximum = liste.getFirst();
        for (T elt : liste) {
            if (elt.compareTo(maximum) > 0) {
                maximum = elt;
            }
        }
        return maximum;
    }

    /** (2 pts) Retourne une String qui concatène les éléments d'une List<T> séparés par sep. */
    public static <T> String concat(List<T> liste, String sep) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < liste.size(); i++) {
            String elt = liste.get(i).toString();
            builder.append(elt);

            if (i < liste.size() - 1) {
                builder.append(sep);
            }
        }

        return builder.toString();
    }
}
