package partie3;

public class GenerateurSQL {
    /** (4 pts) Génère un SELECT : (4 pts)
     * "SELECT pseudo, score FROM joueurs"
     * Utilise @Entite.table() et les noms de @Colonne.
     * Lève IllegalArgumentException si @Entite absent. */
    public static String genererSelect(Class<?> clazz) {
        String nomTable = Inspecteur.getNomTable(clazz);
        var colonnes = Inspecteur.getColonnes(clazz);

        if (colonnes.isEmpty()) {
            throw new IllegalArgumentException("Aucune colonne annotée avec @Colonne trouvée");
        }

        String colonnesStr = String.join(", ", colonnes);
        return String.format("SELECT %s FROM %s", colonnesStr, nomTable);
    }

    /** (5 pts) Génère un INSERT à partir d'une instance : (5 pts)
     * "INSERT INTO joueurs (pseudo, score) VALUES ('Alice', 1500)"
     * Lis les valeurs par réflexion (field.get(objet)).
     * Les champs non-nullable qui sont null lèvent IllegalStateException. */
    public static String genererInsert(Object objet) throws Exception {
        Class<?> clazz = objet.getClass();
        String nomTable = Inspecteur.getNomTable(clazz);
        var colonnes = Inspecteur.getColonnes(clazz);

        if (colonnes.isEmpty()) {
            throw new IllegalArgumentException("Aucune colonne annotée avec @Colonne");
        }

        StringBuilder colonnesStr = new StringBuilder();
        StringBuilder valeursStr = new StringBuilder();

        for (var field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Colonne.class)) {
                Colonne colonne = field.getAnnotation(Colonne.class);
                String nomColonne = colonne.nom().isEmpty() ? field.getName() : colonne.nom();

                field.setAccessible(true);
                Object valeur = field.get(objet);

                if (!colonne.nullable() && valeur == null) {
                    throw new IllegalStateException("La colonne " + nomColonne + " est non-nullable mais sa valeur est null");
                }

                if (!colonnesStr.isEmpty()) {
                    colonnesStr.append(", ");
                    valeursStr.append(", ");
                }

                colonnesStr.append(nomColonne);
                valeursStr.append(valeur instanceof String ? "'" + valeur + "'" : valeur);
            }
        }

        return String.format("INSERT INTO %s (%s) VALUES (%s)", nomTable, colonnesStr, valeursStr);
    }
}