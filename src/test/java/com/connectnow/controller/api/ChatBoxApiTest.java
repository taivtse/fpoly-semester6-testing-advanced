package com.connectnow.controller.api;

import com.connectnow.config.SpringWebConfig;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class ChatBoxApiTest extends AbstractTestNGSpringContextTests {

    private RestTemplate restTemplate;
    private MockMvc mockMvc;

    @Autowired
    private ChatBoxApi chatBoxApi;

    @BeforeClass
    public void setUp() {
        restTemplate = new RestTemplate();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(chatBoxApi)
                .build();
    }

    @Test
    public void findAllTest() throws Exception {
        String apiUrl = "http://localhost:7649/api/chatbox?userId=6";
//        ResponseEntity<String> actualResponse = restTemplate.getForEntity(apiUrl, String.class);
//        String expectedResponse = "[{\"id\":1,\"name\":\"Võ Thanh Mỹ Tiên\",\"photoUrl\":\"https://scontent.fsgn5-4.fna.fbcdn.net/v/t1.0-1/c0.0.100.100a/p100x100/56681367_2194102287520252_7641178326358294528_n.jpg?_nc_cat=104&_nc_ht=scontent.fsgn5-4.fna&oh=06ca9f28805eb87edf745de467ac0dfb&oe=5D435C56\",\"lastMessageContent\":\"You: Không vậy thôi\",\"lastMessageDate\":1557221331000,\"chatBoxParam\":\"100007615053028\",\"readStatus\":true,\"memberId\":1,\"partnerUserId\":3},{\"id\":4,\"name\":\"Trương Tùng Lâm\",\"photoUrl\":\"https://scontent.fsgn5-4.fna.fbcdn.net/v/t1.0-1/p100x100/42404865_1873120216058036_8859179623565492224_n.jpg?_nc_cat=104&_nc_ht=scontent.fsgn5-4.fna&oh=c1c1390150ac384731be1f2b9834cad7&oe=5D4E6FEC\",\"lastMessageContent\":\"Deadline ngập mặt nhậu gì em ơi\",\"lastMessageDate\":1554384321000,\"chatBoxParam\":\"100000802288789\",\"readStatus\":true,\"memberId\":5,\"partnerUserId\":1},{\"id\":2,\"name\":\"Trần Hải My\",\"photoUrl\":\"https://scontent.fsgn5-7.fna.fbcdn.net/v/t1.0-1/p100x100/51585750_800173830329890_2939834964411154432_n.jpg?_nc_cat=103&_nc_ht=scontent.fsgn5-7.fna&oh=e9508c84f440971e678c1d735cb055f6&oe=5D3ED5B3\",\"lastMessageContent\":\"Em uống nước rồi\",\"lastMessageDate\":1554207921000,\"chatBoxParam\":\"9129312319231823\",\"readStatus\":true,\"memberId\":3,\"partnerUserId\":7}]";
//        Assert.assertEquals(actualResponse.getBody(), expectedResponse);
        mockMvc.perform(get(apiUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].username", is("Daenerys Targaryen")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].username", is("John Snow")));
    }

    @Test
    public void test_get_list_success() throws Exception {
        mockMvc.perform(get("http://localhost:7649/api/chatbox?userId=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.name", is("Võ Thành Tài")))
                .andExpect(jsonPath("$.photoUrl", is("https://graph.facebook.com/982392238618347/picture?type=normal")))
                .andExpect(jsonPath("$.lastMessageDate", is(1554384321000L)))
                .andExpect(jsonPath("$.chatBoxParam", is("982392238618347")))
                .andExpect(jsonPath("$.readStatus", is(false)))
                .andExpect(jsonPath("$.memberId", is(6)))
                .andExpect(jsonPath("$.partnerUserId", is(6)));
    }

    @AfterClass
    public void tearDown() {
    }
}