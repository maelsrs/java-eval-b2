package partie1;

public class ForgeronArc extends Forgeron {
    @Override
    public Arme forger() {
        return new Arme() {
            @Override
            public String nom() {
                return "Arc";
            }

            @Override
            public int degats() {
                return 60;
            }
        };
    }
}
