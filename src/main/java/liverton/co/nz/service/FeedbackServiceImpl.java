package liverton.co.nz.service;

import liverton.co.nz.config.ApplicationConfig;
import liverton.co.nz.schema.Feedback;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ApplicationConfig appConfig;

    @Override
    public boolean sendFeedback(Feedback feedback) {

        String endpointUrl = getFeedbackApiUrl(org.apache.commons.lang3.StringUtils.EMPTY);

        HttpEntity<Feedback> request = new HttpEntity<>(feedback, getHeaders());
        Boolean response = restTemplate.postForObject(endpointUrl, request, Boolean.class);
        return response;
    }

    @Override
    public List<Feedback> getFeedbacks() {

        String endpointUrl = getFeedbackApiUrl( org.apache.commons.lang3.StringUtils.EMPTY);
        HttpEntity entity = new HttpEntity(getHeaders());

        ResponseEntity<Feedback[]> response = restTemplate.exchange(endpointUrl, HttpMethod.GET, entity, Feedback[].class);

        return Arrays.asList(response.getBody());
    }


    private String getFeedbackApiUrl(String endpoint) {
        return StringUtils.trimTrailingCharacter(appConfig.apiUrl, '/')
                .concat("/feedback/")
                .concat(endpoint);
    }

    //TODO: Make it generic
    private HttpHeaders getHeaders(){
        String plainCredentials= appConfig.apiUsername.concat(":").concat(appConfig.apiPassword);
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
}
