package partie3;

import java.util.ArrayList;
import java.util.List;

public class Inspecteur {

    /** (2 pts) Retourne le nom de la table si @Entite est présent,
     * sinon lève IllegalArgumentException. */
    public static String getNomTable(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Entite.class)) {
            throw new IllegalArgumentException("La classe n'est pas annotée avec @Entite");
        }

        Entite entite = clazz.getAnnotation(Entite.class);
        return entite.table().isEmpty() ? clazz.getSimpleName() : entite.table();
    }

    /** (3 pts) Retourne les noms des champs annotés @Colonne.
     * Si @Colonne.nom() est vide, utilise le nom du champ Java à la place. */
    public static List<String> getColonnes(Class<?> clazz) {
        List<String> colonnes = new ArrayList<>();

        for (var field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Colonne.class)) {
                Colonne colonne = field.getAnnotation(Colonne.class);

                String nomColonne = colonne.nom().isEmpty() ? field.getName() : colonne.nom();
                colonnes.add(nomColonne);
            }
        }

        return colonnes;
    }

    /** (2 pts) Retourne les noms des champs @Colonne où nullable = false. */
    public static List<String> getColonnesObligatoires(Class<?> clazz) {
        List<String> colonnes = new ArrayList<>();

        for (var field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Colonne.class)) {
                Colonne colonne = field.getAnnotation(Colonne.class);

                if (!colonne.nullable()) {
                    String nomColonne = colonne.nom().isEmpty() ? field.getName() : colonne.nom();
                    colonnes.add(nomColonne);
                }
            }
        }

        return colonnes;
    }


    /** (3 pts) Retourne les noms des méthodes annotées @Loggable
     * dont le niveau correspond au paramètre donné (ex: "WARN"). */
    public static List<String> getMethodesLoggables(Class<?> clazz, String niveau) {
        List<String> methodes = new ArrayList<>();

        for (var method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Loggable.class)) {
                Loggable loggable = method.getAnnotation(Loggable.class);

                if (loggable.niveau().equals(niveau)) {
                    methodes.add(method.getName());
                }
            }
        }

        return methodes;
    }
}
