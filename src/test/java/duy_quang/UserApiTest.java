package duy_quang;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.controller.api.UserApi;
import com.connectnow.service.UserService;
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
public class UserApiTest extends AbstractTestNGSpringContextTests {
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private UserApi userApi;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userApi)
                .build();
    }

    @Test
    public void searchOtherUserTest() throws Exception {
        mockMvc.perform(get("http://localhost:7991/api/user/search?name=my&userId=6"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(3)))
                .andExpect(jsonPath("$[0].name", is("Võ Thanh Mỹ Tiên")))
                .andExpect(jsonPath("$[1].id", is(7)))
                .andExpect(jsonPath("$[1].name", is("Trần Hải My")));
    }
}