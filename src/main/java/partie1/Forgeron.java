package partie1;


public abstract class Forgeron {

    public abstract Arme forger();
    public final String presenterArme() {
        Arme arme = forger();
        return "Arme : " + arme.nom() + " degats: " + arme.degats();
    }
}

//// Implémente : ForgeronEpee (Epee : 80 dégâts) (2 pts)
//// Implémente : ForgeronArc (Arc : 60 dégâts) (2 pts
