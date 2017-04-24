package liverton.co.nz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {

    @Value(value = "${api.email.recipient}")
    public String emailRecipient;
}
