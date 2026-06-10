package partie1;

public abstract class PotionDecorator implements Potion {

    protected Potion potion;

    public PotionDecorator(Potion potion) {
        this.potion = potion;
    }

    @Override
    public int getPV() {
        return potion.getPV();
    }

    @Override
    public String getEffets() {
        return potion.getEffets();
    }
}