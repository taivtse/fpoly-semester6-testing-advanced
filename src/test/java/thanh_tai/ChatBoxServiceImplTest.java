package thanh_tai;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.constant.SystemConstant;
import com.connectnow.dto.ChatBoxDto;
import com.connectnow.dto.MessageDto;
import com.connectnow.paging.PageRequest;
import com.connectnow.paging.Pageable;
import com.connectnow.paging.Sorter;
import com.connectnow.service.ChatBoxService;
import com.connectnow.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class ChatBoxServiceImplTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ChatBoxService chatBoxService;

    @Autowired
    private MessageService messageService;

    @Test
    public void finAllByUserIdTest() {
        List<ChatBoxDto> chatBoxDtoList = chatBoxService.findAllByUserId(null, 6L);
        int actualSize = chatBoxDtoList.size();
        int expectedSize = 3;

        assertEquals(actualSize, expectedSize);
    }

    @Test
    public void finAllByUserId_pageableTest() {
        Sorter sorter = new Sorter("id", SystemConstant.SORT_DESC);
        Pageable pageable = new PageRequest(1, 2, sorter);

        List<ChatBoxDto> chatBoxDtoList = chatBoxService.findAllByUserId(pageable, 6L);

        int actualSize = chatBoxDtoList.size();
        int expectedSize = 2;
        assertEquals(actualSize, expectedSize);
        assertEquals(chatBoxDtoList.get(0).getId(), Long.valueOf(4));
    }

    @Test
    public void findOneByMemberIdTest() {
        ChatBoxDto chatBoxDto = chatBoxService.findOneByMemberId(5L, 6L);

        assertEquals(chatBoxDto.getId(), Long.valueOf(4));
    }

    @Test
    public void updateLastDataByMessageTest() throws Exception {
        MessageDto messageDto = messageService.findOneById(171L);
        ChatBoxDto chatBoxDto = chatBoxService.updateLastDataByMessage(messageDto);

        assertEquals(chatBoxDto.getLastMessageDate(), messageDto.getDate());
    }
}