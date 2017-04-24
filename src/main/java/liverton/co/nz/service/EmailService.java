package liverton.co.nz.service;

public interface EmailService {

    void send(String message, String sender, String recipient);
}
