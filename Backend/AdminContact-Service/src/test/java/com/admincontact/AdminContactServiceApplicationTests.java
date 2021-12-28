package com.admincontact;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.admincontact.exception.EmptyInputException;
import com.admincontact.model.Contact;
import com.admincontact.repository.ContactRepository;
import com.admincontact.service.ContactService;

@SpringBootTest
@RunWith(SpringRunner.class)
class AdminContactServiceApplicationTests {
	
    @Autowired
	private ContactService contactService;
	
	@MockBean
	private ContactRepository conatctRepository;

	@Test
	public void getContactTest() {
		when(conatctRepository.findAll()).thenReturn(Stream
				.of(new Contact("1","Riya","89898989"), new Contact("2","Ananya","99008899")).collect(Collectors.toList()));
		assertEquals(2,contactService.getContact().size());
	}
		@Test
		public void saveContactTest() throws EmptyInputException {
			Contact contact = new Contact("3", "Ankita", "123456789");
			when(conatctRepository.save(contact)).thenReturn(contact);
			assertEquals(contact, contactService.addContact(contact));
		
		}
	}


