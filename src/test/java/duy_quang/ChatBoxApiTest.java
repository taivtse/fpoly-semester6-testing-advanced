package duy_quang;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.constant.SystemConstant;
import com.connectnow.controller.api.ChatBoxApi;
import com.connectnow.dto.ChatBoxDto;
import com.connectnow.paging.PageRequest;
import com.connectnow.paging.Pageable;
import com.connectnow.paging.Sorter;
import com.connectnow.service.ChatBoxService;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class ChatBoxApiTest extends AbstractTestNGSpringContextTests {

    private MockMvc mockMvc;

    @Autowired
    private ChatBoxApi chatBoxApi;

    @Autowired
    private ChatBoxService chatBoxService;

    private Long lastSavedId;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(chatBoxApi)
                .build();
    }

    @Test
    public void getListTest() throws Exception {
        mockMvc.perform(get("http://localhost:7991/api/chatbox?userId=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(4)))
                .andExpect(jsonPath("$[0].name", is("Võ Thành Tài")))
                .andExpect(jsonPath("$[0].photoUrl", is("https://graph.facebook.com/982392238618347/picture?type=normal")))
                .andExpect(jsonPath("$[0].lastMessageDate", is(1554384321000L)))
                .andExpect(jsonPath("$[0].chatBoxParam", is("982392238618347")))
                .andExpect(jsonPath("$[0].readStatus", is(false)))
                .andExpect(jsonPath("$[0].memberId", is(6)))
                .andExpect(jsonPath("$[0].partnerUserId", is(6)));
    }

    @Test
    public void getByMemberIdTest() throws Exception {
        mockMvc.perform(get("http://localhost:7991/api/chatbox/find-by/member?memberId=3&userId=6"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.name", is("Trần Hải My")))
                .andExpect(jsonPath("$.photoUrl", is("https://scontent.fsgn5-7.fna.fbcdn.net/v/t1.0-1/p100x100/51585750_800173830329890_2939834964411154432_n.jpg?_nc_cat=103&_nc_ht=scontent.fsgn5-7.fna&oh=e9508c84f440971e678c1d735cb055f6&oe=5D3ED5B3")))
                .andExpect(jsonPath("$.lastMessageContent", is("Em uống nước rồi")))
                .andExpect(jsonPath("$.lastMessageDate", is(1554207921000L)))
                .andExpect(jsonPath("$.chatBoxParam", is("9129312319231823")))
                .andExpect(jsonPath("$.readStatus", is(true)))
                .andExpect(jsonPath("$.memberId", is(3)))
                .andExpect(jsonPath("$.partnerUserId", is(7)));
    }

    @Test
    public void createTest() throws Exception {
        Sorter sorter = new Sorter("id", SystemConstant.SORT_DESC);
        Pageable pageable = new PageRequest(null, null, sorter);

        ResultActions resultActions = mockMvc.perform(
                post("http://localhost:7991/api/chatbox")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        lastSavedId = chatBoxService.findAll(pageable).get(0).getId();

        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(Math.toIntExact(lastSavedId))))
                .andExpect(jsonPath("$.name", is(nullValue())))
                .andExpect(jsonPath("$.photoUrl", is(nullValue())))
                .andExpect(jsonPath("$.lastMessageContent", is(nullValue())))
                .andExpect(jsonPath("$.lastMessageDate", is(nullValue())))
                .andExpect(jsonPath("$.chatBoxParam", is(nullValue())))
                .andExpect(jsonPath("$.readStatus", is(false)))
                .andExpect(jsonPath("$.memberId", is(nullValue())))
                .andExpect(jsonPath("$.partnerUserId", is(nullValue())));
    }

    @AfterClass
    public void tearDown() throws Exception {
        ChatBoxDto chatBoxDto = chatBoxService.findOneById(lastSavedId);
        chatBoxService.delete(chatBoxDto);
    }
}