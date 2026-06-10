package partie4;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateurJeu {
    /** (1 pt) Retourne true si le pseudo est valide :
     * 3 à 16 caractères, lettres, chiffres, tiret bas uniquement. */
    public static boolean pseudoValide(String pseudo) {
        return pseudo.matches("^[a-zA-Z0-9_]{3,16}$");
    }

    /** (2 pts) Extrait tous les scores d'un texte de la forme
     * "ex: Alice:1500 points, Bob:320 points"
     * Retourne Map<String, Integer> : pseudo -> score. */
    public static Map<String, Integer> extraireScores(String texte) {
        Map<String, Integer> scores = new HashMap<>();
        Pattern pattern = Pattern.compile("(\\w+):(\\d+) points");
        Matcher matcher = pattern.matcher(texte);

        while (matcher.find()) {
            String pseudo = matcher.group(1);
            int score = Integer.parseInt(matcher.group(2));
            scores.put(pseudo, score);
        }
        return scores;
    }

    /** (1 pt) Remplace les suites de chiffres par "***" dans un texte.
     * Ex: "Code 1234 et pin 5678" → "Code *** et pin ***" */
    public static String masquerNombres(String texte) {
        return texte.replaceAll("\\d+", "***");
    }
}