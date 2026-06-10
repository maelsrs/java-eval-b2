package partie1;

public class AvecMana extends PotionDecorator{
    public AvecMana(Potion potion) {
        super(potion);
    }

    @Override
    public int getPV() {
        return super.getPV() + 20;
    }

    @Override
    public String getEffets() {
        return super.getEffets() + " + Mana";
    }
}
