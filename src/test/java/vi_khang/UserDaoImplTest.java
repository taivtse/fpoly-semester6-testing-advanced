package vi_khang;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.dao.UserDao;
import com.connectnow.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class UserDaoImplTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void findPartnerUserByChatBoxIdTest() {
        UserEntity partnerUserEntity = userDao.findPartnerUserByChatBoxId(6L, 1L);

        Assert.assertNotNull(partnerUserEntity);
        Assert.assertEquals(partnerUserEntity.getId(), Long.valueOf(3));


    }
}