package partie1;

public class EtatMort extends EtatPersonnage {
    public EtatMort(Personnage personnage) {
        this.personnage = personnage;
    }

    @Override
    public String attaquer(String cible) {
        return "Action impossible, " + this.personnage.getNom() + " est mort.";
    }

    @Override
    public String recevoirPoison() {
        return "";
    }

    @Override
    public String mourir() {
        return "";
    }
}
