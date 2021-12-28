package com.admincontact.resources;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admincontact.exception.ContactNotfoundException;
import com.admincontact.exception.EmptyInputException;
import com.admincontact.model.Contact;
import com.admincontact.repository.ContactRepository;
import com.admincontact.service.ContactService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private ContactService contactService;
	
    //add contact
	@PostMapping("/addContact")
	public String addContact(@RequestBody Contact contact) throws EmptyInputException {
    contactService.addContact(contact);
	return "Added contact with id :  " + contact.getId();
	}
	
    //find all contact
	@GetMapping("/findAllContact")
	public List<Contact> getContact(){
			return contactService.getContact();	
	}
	
    //find all contact by id
	@GetMapping("/findAllContact/{id}")
	public Optional<Contact> getContactbyId(@PathVariable String id){
			return contactService.getContactbyId(id);
	
	}
	
    //update contact by id
	@PutMapping("/updateContact/{id}")
	public Contact updateContact(@PathVariable String id,@RequestBody Contact contact) {
	       return contactService.updateContact(id,contact);
	}
		
	
	
    //delete contact by id
	@DeleteMapping("/deleteContact/{id}")
	public String deleteContact (@PathVariable String id) {
		contactService.deleteContact(id);
			return "Contact deleted with id : "+id;
		
	}
}