package partie1;

public abstract class EtatPersonnage { // (1 pt)
    protected Personnage personnage;

    public abstract String attaquer(String cible);

    public abstract String recevoirPoison();

    public abstract String mourir();
}