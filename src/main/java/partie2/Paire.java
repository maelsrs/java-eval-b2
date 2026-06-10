package partie2;

public class Paire<A, B> {
    // 1. Attributs + constructeur (1 pt)
    // 2. getters getFirst(), getSecond() (1 pt)
    // 3. swap() — retourne une Paire<B,A> avec les valeurs inversées (2 pts)
    // 4. toString()

    private final A first;
    private final B second;

    public Paire(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public Paire<B, A> swap() {
        return new Paire<>(second, first);
    }

    @Override
    public String toString() {
        return "Paire{" + "first=" + first + ", second=" + second + '}';
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}
