package partie1;

public class EtatVivant extends EtatPersonnage {

    public EtatVivant(Personnage personnage) {
        this.personnage = personnage;
    }

    @Override
    public String attaquer(String cible) {
        return this.personnage.getNom() + " attaque " + cible + ".";
    }

    @Override
    public String recevoirPoison() {
        this.personnage.setEtat(new EtatEmpoisonne(this.personnage));
        return this.personnage.getNom() + " est empoisonné.";
    }

    @Override
    public String mourir() {
        this.personnage.setEtat(new EtatMort(this.personnage));
        return this.personnage.getNom() + " est mort.";
    }
}
