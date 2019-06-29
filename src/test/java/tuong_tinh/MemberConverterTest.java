package tuong_tinh;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.connectnow.converter.MemberConverter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.connectnow.dto.ChatBoxDto;
import com.connectnow.dto.MemberDto;
import com.connectnow.dto.UserDto;
import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.entity.MemberEntity;
import com.connectnow.entity.UserEntity;

public class MemberConverterTest {
	private MemberConverter memberConverter;
	
	@BeforeClass
	public void setUp() {
		memberConverter = new MemberConverter();
	}
	
	@Test
	void entityToDtoTest() {
		ChatBoxEntity chatBoxEntity = new ChatBoxEntity();
		chatBoxEntity.setId(1L);
		chatBoxEntity.setLastMessageDate(new Timestamp(new Date().getTime()));
		
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1L);
		userEntity.setEmail("abc@gmail.com");;
		userEntity.setPhotoUrl("xyz");

		MemberEntity entity = new MemberEntity();
		entity.setId(1L);
		entity.setChatBox(chatBoxEntity);
		entity.setReadStatus(true);
		entity.setUser(userEntity);
		MemberDto dto = memberConverter.entityToDto(entity);
		
		assertNotNull(dto);
		assertEquals(dto.getId(), entity.getId());
		assertEquals(dto.getChatBox().getId(), entity.getChatBox().getId());
		assertEquals(dto.getChatBox().getLastMessageDate(), entity.getChatBox().getLastMessageDate());
		assertEquals(dto.getUser().getId(),entity.getUser().getId());
		assertEquals(dto.getUser().getEmail(), entity.getUser().getEmail());
		assertEquals(dto.getUser().getPhotoUrl(), entity.getUser().getPhotoUrl());
		
	}
	@Test
	void entityToDto_nullTest() {
		MemberDto dto = memberConverter.entityToDto(null);
		
		assertNull(dto);
	}
	
	@Test
	void dtoToEntityTest() {
		ChatBoxDto chatBoxDto = new ChatBoxDto();
		chatBoxDto.setId(1L);
		chatBoxDto.setLastMessageDate(new Timestamp(new Date().getTime()));
		
		UserDto userDto = new UserDto();
		userDto.setId(1L);
		userDto.setEmail("abc@gmail.com");
		userDto.setPhotoUrl("xyz");
		

		
		MemberDto dto = new MemberDto();
		dto.setId(1L);
		dto.setChatBox(chatBoxDto);
		dto.setUser(userDto);
		MemberEntity entity = memberConverter.dtoToEntity(dto);
		
		assertNotNull(entity);
		assertEquals(entity.getId(), entity.getId());
		assertEquals(entity.getChatBox().getId(), dto.getChatBox().getId());
		assertEquals(entity.getUser().getId(), dto.getUser().getId());
		assertEquals(entity.getUser().getEmail(), dto.getUser().getEmail());
		assertEquals(entity.getUser().getPhotoUrl(), dto.getUser().getPhotoUrl());
	}
	
	@Test
	void dtoToEntity_nullTest() {
		MemberEntity entity = memberConverter.dtoToEntity(null);
		
		assertNull(entity);
	}
	
	@Test
	void entityListToDtoListTest() {
		MemberEntity memberEntity0 = new MemberEntity();
		memberEntity0.setId(1L);
		memberEntity0.setReadStatus(false);
		
		MemberEntity memberEntity1 = new MemberEntity();
		memberEntity1.setId(2L);
		memberEntity1.setReadStatus(true);
		
		List<MemberDto> memberDtoList = memberConverter.entityListToDtoList(Arrays.asList(memberEntity0, memberEntity1));
				
		assertEquals(memberDtoList.size(), 2);
		assertEquals(memberDtoList.get(0).getId(), memberEntity0.getId());
		assertEquals(memberDtoList.get(0).getReadStatus(), memberEntity0.getReadStatus());
		assertEquals(memberDtoList.get(1).getId(), memberEntity1.getId());
		assertEquals(memberDtoList.get(1).getReadStatus(), memberEntity1.getReadStatus());
	}
	@Test
	void dtoListToEntityListTest() {
		MemberDto memberDto0 = new MemberDto();
		memberDto0.setId(1L);
		memberDto0.setReadStatus(false);
		
		MemberDto memberDto1 = new MemberDto();
		memberDto1.setId(2L);
		memberDto1.setReadStatus(true);
		
		List<MemberEntity> memberDtoList = memberConverter.dtoListToEntityList(Arrays.asList(memberDto0, memberDto1));
				
		assertEquals(memberDtoList.size(), 2);
		assertEquals(memberDtoList.get(0).getId(), memberDto0.getId());
		assertEquals(memberDtoList.get(0).getReadStatus(), memberDto0.getReadStatus());
		assertEquals(memberDtoList.get(1).getId(), memberDto1.getId());
		assertEquals(memberDtoList.get(1).getReadStatus(), memberDto1.getReadStatus());
	}
}
