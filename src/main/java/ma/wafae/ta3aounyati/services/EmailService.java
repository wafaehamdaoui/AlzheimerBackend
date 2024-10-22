package ma.wafae.ta3aounyati.services;

public interface EmailService {
    void sendOrderNotification(String to, String subject, String text);
}
