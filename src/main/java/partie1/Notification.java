package partie1;

public abstract class Notification { // (1 pt)
    protected CanalEnvoi canal;

    public Notification(CanalEnvoi canal) {
        this.canal = canal;
    }

    public abstract void notifier(String destinataire, String contenu);
}
