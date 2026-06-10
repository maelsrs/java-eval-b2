package partie1;

public class AvecAntidote extends PotionDecorator {
    public AvecAntidote(Potion potion) {
        super(potion);
    }

    @Override
    public int getPV() {
        return super.getPV();
    }

    @Override
    public String getEffets() {
        return super.getEffets() + " + Antidote";
    }
}
