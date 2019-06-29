package duy_quang;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.controller.api.MessageApi;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class MessageApiTest extends AbstractTestNGSpringContextTests {
    private MockMvc mockMvc;

    @Autowired
    private MessageApi messageApi;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(messageApi)
                .build();
    }

    @Test
    public void getListTest() throws Exception {
        mockMvc.perform(get("http://localhost:7991/api/message?chatBoxId=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].content", is("Aloooo. Có đó không?")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].content", is("Không")))
                .andExpect(jsonPath("$[2].id", is(171)))
                .andExpect(jsonPath("$[2].content", is("Không vậy thôi")));
    }
}