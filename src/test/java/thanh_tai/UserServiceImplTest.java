package thanh_tai;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.dto.SearchUserDto;
import com.connectnow.dto.UserDto;
import com.connectnow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class UserServiceImplTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private UserService userService;

    @Test
    public void findOneByProviderAndProviderIdTest() {
        UserDto userDto = userService.findOneByProviderAndProviderId("FACEBOOK", "982392238618347");

        assertNotNull(userDto);
        assertEquals(userDto.getId(), Long.valueOf(6));
        assertEquals(userDto.getName(), "Võ Thành Tài");
        assertEquals(userDto.getEmail(), "thanhtai17071997@gmail.com");
    }

    @Test
    public void findSearchUserByNameTest() {
        List<SearchUserDto> searchUserDtoList = userService.findSearchUserByName("my", 6L);

        assertEquals(searchUserDtoList.size(), 2);
        assertEquals(searchUserDtoList.get(0).getName(), "Võ Thanh Mỹ Tiên");
        assertEquals(searchUserDtoList.get(1).getName(), "Trần Hải My");
    }
}