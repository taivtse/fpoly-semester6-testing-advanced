package thanh_tai;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.constant.SystemConstant;
import com.connectnow.dto.MessageDto;
import com.connectnow.paging.PageRequest;
import com.connectnow.paging.Pageable;
import com.connectnow.paging.Sorter;
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
public class MessageServiceImplTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MessageService messageService;

    @Test
    public void findAllByChatBoxIdTest() {
        List<MessageDto> messageDtoList = messageService.findAllByChatBoxId(null, 1L);
        assertEquals(messageDtoList.size(), 3);
    }

    @Test
    public void findAllByChatBoxId_pageableTest() {
        Sorter sorter = new Sorter("id", SystemConstant.SORT_DESC);
        Pageable pageable = new PageRequest(1, 2, sorter);
        List<MessageDto> messageDtoList = messageService.findAllByChatBoxId(pageable, 1L);

        assertEquals(messageDtoList.size(), 2);
        assertEquals(messageDtoList.get(0).getId(), Long.valueOf(171));
    }
}