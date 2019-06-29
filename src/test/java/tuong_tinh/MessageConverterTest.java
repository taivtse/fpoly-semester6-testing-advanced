package tuong_tinh;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.connectnow.converter.MessageConverter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.connectnow.dto.MessageDto;
import com.connectnow.dto.MessageDto;
import com.connectnow.dto.MessageType;
import com.connectnow.entity.MessageEntity;
import com.connectnow.entity.MessageEntity;
public class MessageConverterTest {
private MessageConverter messageConverter;
	
	@BeforeClass
	public void setUp() {
		messageConverter = new MessageConverter();
	}
	
	@Test
	void entityToDtoTest() {
		MessageEntity entity = new MessageEntity();
		entity.setId(1L);
		entity.setDate(new Timestamp(new Date().getTime()));
		entity.setType(MessageType.TEXT);
		entity.setContent("abc");
		
		MessageDto dto = messageConverter.entityToDto(entity);
		
		assertNotNull(dto);
		assertEquals(dto.getId(), entity.getId());
		assertEquals(dto.getContent(), entity.getContent());
		assertEquals(dto.getDate(), entity.getDate());
		assertEquals(dto.getType(), entity.getType());		
	}
	@Test
	void entityToDto_nullTest() {
		MessageDto dto = messageConverter.entityToDto(null);
		
		assertNull(dto);
	}

	@Test
	void dtoToEntityTest() {
		MessageDto dto = new MessageDto();
		dto.setId(1L);
		dto.setDate(new Timestamp(new Date().getTime()));
		dto.setType(MessageType.TEXT);
		dto.setContent("abc");
		
		MessageEntity entity = messageConverter.dtoToEntity(dto);
		
		assertNotNull(entity);
		assertEquals(entity.getId(), dto.getId());
		assertEquals(entity.getContent(), dto.getContent());
		assertEquals(entity.getDate(), dto.getDate());
		assertEquals(entity.getType(), dto.getType());		
	}

	@Test
	void dtoToEntity_nullTest() {
		MessageEntity entity = messageConverter.dtoToEntity(null);
		
		assertNull(entity);
	}
	@Test
	void entityListToDtoListTest() {
		MessageEntity messageEntity0 = new MessageEntity();
		messageEntity0.setId(1L);
		messageEntity0.setType(MessageType.TEXT);
		
		MessageEntity messageEntity1 = new MessageEntity();
		messageEntity1.setId(2L);
		messageEntity1.setType(MessageType.TEXT);
		
		List<MessageDto> messageDtoList = messageConverter.entityListToDtoList(Arrays.asList(messageEntity0, messageEntity1));
				
		assertEquals(messageDtoList.size(), 2);
		assertEquals(messageDtoList.get(0).getId(), messageEntity0.getId());
		assertEquals(messageDtoList.get(0).getType(), messageEntity0.getType());
		assertEquals(messageDtoList.get(1).getId(), messageEntity1.getId());
		assertEquals(messageDtoList.get(1).getType(), messageEntity1.getType());
	}
}
