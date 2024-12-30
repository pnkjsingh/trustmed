package com.trustmed.userService.service;

import java.util.List;
import java.util.Optional;

import com.trustmed.userService.entity.ContactUs;

public interface ContactUsService {
	
	ContactUs saveUser(ContactUs contact);

	List<ContactUs> getAllContactRecords();

	Optional<ContactUs> getContacteDetailsById(String contactId);

	void deleteContact(String userName);

//	Optional<ContactUs> updateContact(String userName, ContactUs contact);

}
