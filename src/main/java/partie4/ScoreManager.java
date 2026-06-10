package partie4;

import partie2.Paire;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreManager {
    /**
     * (2 pts) Écrit la liste dans un fichier CSV. Utilise try-with-resources.
     * Format : une ligne par entrée "pseudo,score\n"
     */
    public static void sauvegarder(String fichier, List<Paire<String, Integer>> scores) throws IOException {
        try (FileWriter writer = new FileWriter(fichier)) {
            for (Paire<String, Integer> paire : scores) {
                writer.write(paire.getFirst() + "," + paire.getSecond() + "\n");
            }
        }
    }


    /**
     * (2 pts) Lit le fichier et retourne la liste de paires.
     * Ignore les lignes malformées (pas de crash).
     */
    public static List<Paire<String, Integer>> charger(String fichier) throws IOException {
        List<Paire<String, Integer>> scores = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fichier))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 2) {
                    try {
                        String pseudo = parts[0].trim();
                        int score = Integer.parseInt(parts[1].trim());
                        scores.add(new Paire<>(pseudo, score));
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        }
        return scores;
    }
}