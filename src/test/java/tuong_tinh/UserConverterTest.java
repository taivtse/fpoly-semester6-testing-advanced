package tuong_tinh;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import com.connectnow.converter.UserConverter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.connectnow.dto.MessageDto;
import com.connectnow.dto.MessageType;
import com.connectnow.dto.UserDto;
import com.connectnow.entity.UserEntity;

public class UserConverterTest {
private UserConverter userConverter;
	
	@BeforeClass
	public void setUp() {
		userConverter = new UserConverter();
	}
	
	@Test
	void entityToDtoTest() {
		UserEntity entity = new UserEntity();
		entity.setId(1L);
		entity.setEmail("abc@gmail.com");;
		entity.setName("abc");;
		entity.setPhotoUrl("xyz");
		entity.setProvider("xyz");
		entity.setProviderId("xyz");
		
		UserDto dto = userConverter.entityToDto(entity);
		
		assertNotNull(dto);
		assertEquals(dto.getId(), entity.getId());
		assertEquals(dto.getEmail(), entity.getEmail());
		assertEquals(dto.getName(), entity.getName());
		assertEquals(dto.getPhotoUrl(), entity.getPhotoUrl());		
		assertEquals(dto.getProvider(), entity.getProvider());	
		assertEquals(dto.getProviderId(), entity.getProviderId());
	}
	@Test
	void entityToDto_nullTest() {
		UserDto dto = userConverter.entityToDto(null);
		
		assertNull(dto);
	}
	@Test
	void dtoToEntityTest() {
		UserDto dto = new UserDto();
		dto.setId(1L);
		dto.setEmail("abc@gmail.com");
		dto.setName("abc");
		dto.setPhotoUrl("xyz");
		dto.setProvider("xyz");
		dto.setProviderId("xyz");
		
		UserEntity entity = userConverter.dtoToEntity(dto);
		
		assertNotNull(entity);
		assertEquals(entity.getId(), dto.getId());
		assertEquals(entity.getEmail(),dto.getEmail());
		assertEquals(entity.getName(), dto.getName());
		assertEquals(entity.getPhotoUrl(), dto.getPhotoUrl());		
		assertEquals(entity.getProvider(), dto.getProvider());	
		assertEquals(entity.getProviderId(), dto.getProviderId());
	}
	@Test
	void dtoToEntity_nullTest() {
		UserEntity entity = userConverter.dtoToEntity(null);
		
		assertNull(entity);
	}
	@Test
	void entityListToDtoListTest() {
		UserEntity userEntity0 = new UserEntity();
		userEntity0.setId(1L);
		userEntity0.setEmail("abc@gmail.com");
		
		UserEntity userEntity1 = new UserEntity();
		userEntity1.setId(2L);
		userEntity1.setEmail("abc@gmail.com");
		
		List<UserDto> userDtoList = userConverter.entityListToDtoList(Arrays.asList(userEntity0, userEntity1));
				
		assertEquals(userDtoList.size(), 2);
		assertEquals(userDtoList.get(0).getId(), userEntity0.getId());
		assertEquals(userDtoList.get(0).getEmail(), userEntity0.getEmail());
		assertEquals(userDtoList.get(1).getId(), userEntity1.getId());
		assertEquals(userDtoList.get(1).getEmail(), userEntity1.getEmail());
	}
}
