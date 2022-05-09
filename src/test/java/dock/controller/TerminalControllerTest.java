package dock.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpStatus.OK;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TerminalControllerTest {

    @LocalServerPort
    int randomServerPort;
    private RestTemplate restTemplate;
    private String urlConvert;
    private HttpHeaders headers;

    private String payloadTestRequest;

    private String payloadTestResponse;

    private HttpEntity<String> request;

    @BeforeEach
    void setUp() {
        restTemplate = new RestTemplate();
        urlConvert = "http://localhost:" + randomServerPort + "/v1/api-dock/convert";

        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        payloadTestRequest = "44332213;123;PWWIN;4;F04A2E4088B;2;8.00b3;0;16777216;PWWIN";

        payloadTestResponse = "{\"logic\":44332213," +
                "\"serial\":\"123\"," +
                "\"model\":\"PWWIN\"," +
                "\"sam\":4," +
                "\"ptid\":\"F04A2E4088B\"," +
                "\"plat\":2," +
                "\"version\":\"8.00b3\"," +
                "\"mxr\":0," +
                "\"mxf\":16777216," +
                "\"PVERFM\":\"PWWIN\"}";

        request = new HttpEntity(payloadTestRequest, headers);
    }

    @Test
    public void test_convert_endpoint_success() {

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(urlConvert, request, String.class);

        Assertions.assertEquals(OK, responseEntity.getStatusCode());
        Assertions.assertEquals(payloadTestResponse, responseEntity.getBody());
    }

    @Test
    public void test_convert_endpoint_when_body_is_null() {

    }

}
