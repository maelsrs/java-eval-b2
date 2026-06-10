package partie2;

import java.util.function.Function;

public class LambdaFactory {
    /**
     * (2 pts) Retourne une Transformation<String> qui met en majuscules
     * et préfixe avec ">> "
     */
    public static Transformation<String> majusculeEtPrefixe() {
        return s -> ">> " + s.toUpperCase();
    }

    /**
     * (2 pts) Retourne une Transformation<Integer> qui calcule n! (factorielle)
     */
    public static Transformation<Integer> factorielle() {
        return n -> {
            if (n < 0) {
                throw new IllegalArgumentException("Pas de nombre negatifs");
            }

            int result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }

            return result;
        };
    }

    /**
     * (3 pts) Retourne une Function<Integer,Integer> qui retourne
     * le n-ième terme de Fibonacci (F(0)=0, F(1)=1).
     */
    public static Function<Integer, Integer> fibonacci() {
        return n -> {
            if (n < 0) {
                throw new IllegalArgumentException("Pas de nombre negatifs");
            }

            if (n == 0) return 0;
            if (n == 1) return 1;

            int a = 0;
            int b = 1;

            for (int i = 2; i <= n; i++) {
                int c = a + b;
                a = b;
                b = c;
            }
            return b;
        };
    }
}