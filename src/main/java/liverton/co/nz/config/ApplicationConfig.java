package liverton.co.nz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value(value = "${api.url}")
    public String apiUrl;

    @Value(value = "${api.username}")
    public String apiUsername;

    @Value(value = "${api.password}")
    public String apiPassword;
}
