package com.admincontact.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.admincontact.model.Contact;

public interface ContactRepository extends MongoRepository<Contact, String> {

}
