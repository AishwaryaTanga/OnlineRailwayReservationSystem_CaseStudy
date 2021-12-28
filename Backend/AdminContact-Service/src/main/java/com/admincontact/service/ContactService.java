package com.admincontact.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.admincontact.exception.ContactNotfoundException;
import com.admincontact.exception.EmptyInputException;
import com.admincontact.model.Contact;
import com.admincontact.repository.ContactRepository;


@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public Contact addContact (Contact contact) throws EmptyInputException {
		if(contact.getName().isEmpty() || contact.getName().length()==0){
			throw new EmptyInputException();
		}
		return contactRepository.save(contact);
	}
	
	public List<Contact> getContact() {
		List<Contact> contact = contactRepository.findAll();
		System.out.println("Getting data from DB : " + contact);
		return contact;
	}

	public Optional<Contact> getContactbyId(String id) {
		boolean isContactExist=contactRepository.existsById(id);
		if(isContactExist)
		{
			return contactRepository.findById(id);
		}
		else {
			
			throw new ContactNotfoundException();
		}
	}

	public void deleteContact(String id) {
		boolean isContactExist=contactRepository.existsById(id);
		if(isContactExist)
		{
			contactRepository.deleteById(id);
		}
		else {
			
			throw new ContactNotfoundException();
		}
		
	}

	public Contact updateContact(String id, Contact contact) {
	   	 boolean isContactExist=contactRepository.existsById(id);
			if(isContactExist)
			{
				contact.getId();
				contactRepository.save(contact);
				return contact;
			}
			else 
			{
				throw new ContactNotfoundException();
				
			}
	    }	
}