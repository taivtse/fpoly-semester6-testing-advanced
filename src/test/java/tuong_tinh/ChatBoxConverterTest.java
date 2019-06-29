package tuong_tinh;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.*;

import com.connectnow.converter.ChatBoxConverter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.connectnow.dto.ChatBoxDto;
import com.connectnow.dto.MemberDto;
import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.entity.MemberEntity;

public class ChatBoxConverterTest {
	
	private ChatBoxConverter chatBoxConverter;
	
	@BeforeClass
	public void setUp() {
		chatBoxConverter = new ChatBoxConverter();
	}

	@Test
	void entityToDtoTest() {
		ChatBoxEntity entity = new ChatBoxEntity();
		entity.setId(1L);
		entity.setLastMessageDate(new Timestamp(new Date().getTime()));
		
		ChatBoxDto dto = chatBoxConverter.entityToDto(entity);
		
		assertNotNull(dto);
		assertEquals(dto.getId(), entity.getId());
		assertEquals(dto.getLastMessageDate(), entity.getLastMessageDate());
	}
	
	@Test
	void entityToDto_nullTest() {
		ChatBoxDto dto = chatBoxConverter.entityToDto(null);
		
		assertNull(dto);
	}

	@Test
	void dtoToEntityTest() {
		ChatBoxDto dto = new ChatBoxDto();
		dto.setId(1L);
		dto.setLastMessageDate(new Timestamp(new Date().getTime()));
		ChatBoxEntity entity = chatBoxConverter.dtoToEntity(dto);
		
		assertNotNull(entity);
		assertEquals(entity.getId(), dto.getId());
		assertEquals(entity.getLastMessageDate(), dto.getLastMessageDate());
	}
	@Test
	void dtoToEntity_nullTest() {
		ChatBoxEntity entity = chatBoxConverter.dtoToEntity(null);
		
		assertNull(entity);
	}
	
	
	@Test
	void entityListToDtoListTest() {
		ChatBoxEntity chatboxEntity0 = new ChatBoxEntity();
		chatboxEntity0.setId(1L);
		chatboxEntity0.setLastMessageDate(new Timestamp(new Date().getTime()));
		
		ChatBoxEntity chatboxEntity1 = new ChatBoxEntity();
		chatboxEntity1.setId(2L);
		chatboxEntity1.setLastMessageDate(new Timestamp(new Date().getTime()));
		
		List<ChatBoxDto> chatboxDtoList = chatBoxConverter.entityListToDtoList(Arrays.asList(chatboxEntity0, chatboxEntity1));
				
		assertEquals(chatboxDtoList.size(), 2);
		assertEquals(chatboxDtoList.get(0).getId(), chatboxEntity0.getId());
		assertEquals(chatboxDtoList.get(0).getLastMessageDate(), chatboxEntity0.getLastMessageDate());
		assertEquals(chatboxDtoList.get(1).getId(), chatboxEntity1.getId());
		assertEquals(chatboxDtoList.get(1).getLastMessageDate(), chatboxEntity1.getLastMessageDate());
	}
	@Test
	void dtoListToEntityListTest() {
		ChatBoxDto chatboxDto0 = new ChatBoxDto();
		chatboxDto0.setId(1L);
		chatboxDto0.setLastMessageDate(new Timestamp(new Date().getTime()));
		
		ChatBoxDto chatboxDto1 = new ChatBoxDto();
		chatboxDto1.setId(2L);
		chatboxDto1.setLastMessageDate(new Timestamp(new Date().getTime()));
		
		List<ChatBoxEntity> chatboxEntityList = chatBoxConverter.dtoListToEntityList(Arrays.asList(chatboxDto0, chatboxDto1));
				
		assertEquals(chatboxEntityList.size(), 2);
		assertEquals(chatboxEntityList.get(0).getId(), chatboxDto0.getId());
		assertEquals(chatboxEntityList.get(0).getLastMessageDate(), chatboxDto0.getLastMessageDate());
		assertEquals(chatboxEntityList.get(1).getId(), chatboxDto1.getId());
		assertEquals(chatboxEntityList.get(1).getLastMessageDate(), chatboxDto1.getLastMessageDate());
	}
	
}
