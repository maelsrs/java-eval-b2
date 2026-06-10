package partie1;

public class Personnage {
    private final String nom; // obligatoire
    private final String classe; // obligatoire (ex: Guerrier, Mage, Voleur)
    private int pv; // défaut : 1

    private final int mana; // défaut : 50
    private final String arme; // défaut : "Poings"
    private final boolean estElite; // défaut : false

    private EtatPersonnage etat;

    private Personnage(Builder builder) {
        this.nom = builder.nom;
        this.classe = builder.classe;
        this.pv = builder.pv;
        this.mana = builder.mana;
        this.arme = builder.arme;
        this.estElite = builder.estElite;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPv() {
        return pv;
    }

    public String getNom() {
        return nom;
    }

    public EtatPersonnage getEtat() {
        return etat;
    }

    public void setEtat(EtatPersonnage etat) {
        this.etat = etat;
    }

    private class Builder {
        private String nom;
        private String classe;
        private int pv = 1;
        private int mana = 50;
        private String arme = "Poings";
        private boolean estElite = false;

        public Builder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder setClasse(String classe) {
            this.classe = classe;
            return this;
        }

        public Builder setPv(int pv) {
            this.pv = pv;
            return this;
        }

        public Builder setMana(int mana) {
            this.mana = mana;
            return this;
        }

        public Builder setArme(String arme) {
            this.arme = arme;
            return this;
        }

        public Builder setEstElite(boolean estElite) {
            this.estElite = estElite;
            return this;
        }

        public Personnage build() {
            if (nom == null || nom.isEmpty()) {
                throw new IllegalArgumentException("Le nom est obligatoire.");
            }
            if (classe == null || classe.isEmpty()) {
                throw new IllegalArgumentException("La classe est obligatoire.");
            }
            return new Personnage(this);
        }
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "nom='" + nom + '\'' +
                ", classe='" + classe + '\'' +
                ", pv=" + pv +
                ", mana=" + mana +
                ", arme='" + arme + '\'' +
                ", estElite=" + estElite +
                '}';
    }
}