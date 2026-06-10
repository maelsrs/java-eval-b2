package partie1;

public class EtatEmpoisonne extends EtatPersonnage {

    public EtatVivant(Personnage personnage) {
        this.personnage = personnage;
    }

    @Override
    public String attaquer(String cible) {
        this.personnage.setPv(this.personnage.getPv() - 10);

        return this.personnage.getNom() + " attaque " + cible + ". " + this.personnage.getNom() + " perd 10 PV (poison).";
    }

    @Override
    public String recevoirPoison() {
        return "Déjà empoisonné.";
    }

    @Override
    public String mourir() {
        this.personnage.setEtat(new EtatMort(this.personnage));
        return this.personnage.getNom() + " est mort.";
    }
}