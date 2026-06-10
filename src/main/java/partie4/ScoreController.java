package partie4;

import partie2.Paire;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Annotations.Rest(path = "/api/scores")
public class ScoreController {

    private final String SCORE_FILE = "test.txt";

    /** (1 pt) GET /api/scores/top?limit=5
     * Retourne les limit meilleurs scores du ScoreManager sous forme de String.
     * Format : "pseudo1:score1,pseudo2:score2,..." */
    @Annotations.Get(path = "/top")
    public String getTop(@Annotations.QueryParam(name = "limit") int limit) {
        try {
            List<Paire<String, Integer>> score = ScoreManager.charger(SCORE_FILE);
            score.sort((a, b) -> b.getSecond().compareTo(a.getSecond()));
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < Math.min(limit, score.size()); i++) {
                Paire<String, Integer> entry = score.get(i);
                result.append(entry.getFirst()).append(":").append(entry.getSecond());
                if (i < Math.min(limit, score.size()) - 1) {
                    result.append(",");
                }
            }

            return result.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** (1 pt) POST /api/scores/add
     * Reçoit un ScoreDTO (pseudo + score), l'enregistre via ScoreManager.
     * Retourne "OK" si succès. */
    @Annotations.Post(path = "/add")
    public String add(ScoreDTO dto) {
        try {
            List<Paire<String, Integer>> scores = ScoreManager.charger(SCORE_FILE);
            scores.add(new Paire<>(dto.pseudo(), dto.score()));
            ScoreManager.sauvegarder(SCORE_FILE, scores);
            return "OK";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createFileIfNotExists() {
        try {
            new File(SCORE_FILE).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}