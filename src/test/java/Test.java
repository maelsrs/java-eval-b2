import partie4.ScoreController;
import partie4.ValidateurJeu;

public class Test {

    private static void test() {
        System.out.println("'abcdefghijklmnop' valide : " + ValidateurJeu.pseudoValide("abcdefghijklmnop"));
        System.out.println("'ls' valide : " + ValidateurJeu.pseudoValide("lsb"));

        String texte1 = "Alice:1500 points, Bob:320 points";
        System.out.println("Scores de '" + texte1 + "' : " + ValidateurJeu.extraireScores(texte1));

        String texte2 = "Player1:999 points et Player2:1 points";
        System.out.println("Scores de '" + texte2 + "' : " + ValidateurJeu.extraireScores(texte2));

        String texte3 = "Pas de scores ici";
        System.out.println("Scores de '" + texte3 + "' : " + ValidateurJeu.extraireScores(texte3));

        System.out.println("Code 1234 et pin 5678 : " + ValidateurJeu.masquerNombres("Code 1234 et pin 5678"));
    }

    private static void test2() {
        ScoreController controller = new ScoreController();
        controller.createFileIfNotExists();

        String result = controller.add(new partie4.ScoreDTO("TestPlayer", 1234));
        System.out.println("Ajout score : " + result);

        String topScores = controller.getTop(5);
        System.out.println("Top scores après ajout : " + topScores);
    }

    public static void main(String[] args) {
        test2();
    }
}
