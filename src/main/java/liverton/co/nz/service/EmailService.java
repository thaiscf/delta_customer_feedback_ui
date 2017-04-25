package liverton.co.nz.service;

public interface EmailService {

    void send(String subject, String message, String sender, String recipient);
}
