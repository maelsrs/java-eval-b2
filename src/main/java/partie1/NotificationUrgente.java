package partie1;

public class NotificationUrgente extends Notification{
    public NotificationUrgente(CanalEnvoi canal) {
        super(canal);
    }

    @Override
    public void notifier(String destinataire, String contenu) {
        String messageUrgent = "[URGENT] " + contenu;
        canal.envoyer(destinataire, messageUrgent);
    }
}
