package partie1;

public class ForgeronEpee extends Forgeron {
    @Override
    public Arme forger() {
        return new Arme() {
            @Override
            public String nom() {
                return "Epee";
            }

            @Override
            public int degats() {
                return 80;
            }
        };
    }
}
