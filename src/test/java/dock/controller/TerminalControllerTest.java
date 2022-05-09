package dock.controller;


import dock.Application;
import dock.model.TerminalModel;
import dock.model.TerminalModelBuilder;
import dock.service.TerminalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = {Application.class})
public class TerminalControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private TerminalService terminalService;

    private String payloadTestRequest;

    private String payloadTestResponse;

    @BeforeEach
    void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        payloadTestRequest = "44332213;123;PWWIN;4;F04A2E4088B;2;8.00b3;0;16777216;PWWIN";
        payloadTestResponse = "{\"logic\":44332213," + "\"serial\":\"123\"," + "\"model\":\"PWWIN\"," + "\"sam\":4," + "\"ptid\":\"F04A2E4088B\"," + "\"plat\":2," + "\"version\":\"8.00b3\"," + "\"mxr\":0," + "\"mxf\":16777216," + "\"PVERFM\":\"PWWIN\"}";
    }

    @Test
    public void test_convert_endpoint_success() throws Exception {
        TerminalModel terminalModel = TerminalModelBuilder
                .builder()
                .addLogic(44332213)
                .addSerial("123")
                .addModel("PWWIN")
                .addSam(4)
                .addPtid("F04A2E4088B")
                .addPlat(2)
                .addVersion("8.00b3")
                .addMxr(0)
                .addMxf(16777216)
                .addPverfm("PWWIN").build();

        when(terminalService.convert(any(String.class))).thenReturn(terminalModel);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/api-dock/convert")
                        .content(payloadTestRequest)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML))
                .andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
        assertEquals("{\"logic\":44332213," + "\"serial\":\"123\"," + "\"model\":\"PWWIN\"," + "\"sam\":4," + "\"ptid\":\"F04A2E4088B\"," + "\"plat\":2," + "\"version\":\"8.00b3\"," + "\"mxr\":0," + "\"mxf\":16777216," + "\"PVERFM\":\"PWWIN\"}"
                , mvcResult.getResponse().getContentAsString());
        verify(terminalService, times(1)).convert(payloadTestRequest);
    }

    @Test
    public void test_convert_endpoint_when_body_is_empty() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/api-dock/convert")
                        .content("")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML))
                .andReturn();

        assertEquals(400, mvcResult.getResponse().getStatus());
    }

    @Test
    public void test_convert_endpoint_when_body_is_null() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/api-dock/convert")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML))
                .andReturn();

        assertEquals(HttpMessageNotReadableException.class, mvcResult.getResolvedException().getClass());
    }


}
