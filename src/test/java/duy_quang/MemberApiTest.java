package duy_quang;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.constant.SystemConstant;
import com.connectnow.controller.api.MemberApi;
import com.connectnow.dto.MemberDto;
import com.connectnow.paging.PageRequest;
import com.connectnow.paging.Pageable;
import com.connectnow.paging.Sorter;
import com.connectnow.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class MemberApiTest extends AbstractTestNGSpringContextTests {
    private MockMvc mockMvc;

    @Autowired
    private MemberApi memberApi;

    @Autowired
    private MemberService memberService;

    private Long lastSavedId;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(memberApi)
                .build();
    }


    @Test(priority = 0)
    public void createTest() throws Exception {
        Sorter sorter = new Sorter("id", SystemConstant.SORT_DESC);
        Pageable pageable = new PageRequest(null, null, sorter);

        ResultActions resultActions = mockMvc.perform(
                post("http://localhost:7991/api/member")
                        .content("{ \"user\": { \"id\": 7 }, \"chatBox\": { \"id\": 4 } }")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        lastSavedId = memberService.findAll(pageable).get(0).getId();
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(Math.toIntExact(lastSavedId))))
                .andExpect(jsonPath("$.readStatus", is(false)));
    }

    @Test(priority = 1)
    public void updateReadStatusTest() throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("memberId", lastSavedId);
        data.put("readStatus", true);

        ResultActions resultActions = mockMvc.perform(
                put("http://localhost:7991/api/member")
                        .content(new ObjectMapper().writeValueAsString(data))
                        .contentType(MediaType.APPLICATION_JSON)
        );

        resultActions
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(Math.toIntExact(lastSavedId))))
                .andExpect(jsonPath("$.readStatus", is(true)));
    }

    @Test(priority = 2)
    public void updateReadStatus_exceptionTest() throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("abc", lastSavedId);
        data.put("xyz", true);

        ResultActions resultActions = mockMvc.perform(
                put("http://localhost:7991/api/member")
                        .content(new ObjectMapper().writeValueAsString(data))
                        .contentType(MediaType.APPLICATION_JSON)
        );

        resultActions.andExpect(status().isBadRequest());
    }

    @AfterClass
    public void tearDown() throws Exception {
        MemberDto memberDto = memberService.findOneById(lastSavedId);
        memberService.delete(memberDto);
    }
}