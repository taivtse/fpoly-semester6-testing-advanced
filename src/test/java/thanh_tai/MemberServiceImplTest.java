package thanh_tai;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.dto.MemberDto;
import com.connectnow.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class MemberServiceImplTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MemberService memberService;

    @Test(priority = 0)
    public void updateReadStatusByChatBoxIdAndUserIdTest() throws Exception {
        memberService.updateReadStatusByChatBoxIdAndUserId(2L, 7L, true);

        MemberDto memberDto = memberService.findOneById(4L);

        assertTrue(memberDto.getReadStatus());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void updateReadStatusByChatBoxIdAndUserId_exceptionTest() throws Exception {
        memberService.updateReadStatusByChatBoxIdAndUserId(100L, 100L, true);
    }

    @Test(priority = 1)
    public void updateReadStatusByMemberIdTest() throws Exception {
        memberService.updateReadStatusByMemberId(4L, false);

        MemberDto memberDto = memberService.findOneById(4L);

        assertFalse(memberDto.getReadStatus());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void updateReadStatusByMemberIdTest_exceptionTest() throws Exception {
        memberService.updateReadStatusByMemberId(100L, false);
    }
}