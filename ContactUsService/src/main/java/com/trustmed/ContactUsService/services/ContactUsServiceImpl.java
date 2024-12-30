package com.trustmed.ContactUsService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustmed.ContactUsService.entity.ContactUs;
import com.trustmed.ContactUsService.exception.BadRequestException;
import com.trustmed.ContactUsService.exception.NotFoundException;
import com.trustmed.ContactUsService.repository.ContactUsRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class ContactUsServiceImpl implements ContactUsService {
	
	@Autowired
	private	ContactUsRepository contactUsRepository;

	@Override
	public ContactUs saveUser(ContactUs contact) {
		if(contact==null) {
			throw new BadRequestException("Contact or contactid cant be null");
		}
//		if(contactUsRepository.existsById(contact.getId())) {
//			throw new BadRequestException("contactId already exist");
//		}
		return contactUsRepository.save(contact);
	}

	@Override
	public List<ContactUs> getAllContactRecords() {
		List<ContactUs> result= contactUsRepository.findAll();
		if(!result.isEmpty()) {
			return result;
		}
		else {
			throw new NotFoundException("Contact Records are empty");
		}
	}

	@Override
	public Optional<ContactUs> getContacteDetailsById(String contactId) {
		Optional<ContactUs> result=contactUsRepository.findById(contactId);
		if(!(result.isPresent())) {
			throw new NotFoundException("Contact Details not found for contactId: "+contactId);
		}
		return result;
	}

	@Override
	public void deleteContact(String contactId) {
		// TODO Auto-generated method stub
		Optional<ContactUs> result=contactUsRepository.findById(contactId);
		if(contactId==null) {
			throw new BadRequestException("contactId cant be null");
		}
		if(result.isPresent()) {
			contactUsRepository.deleteById(contactId);
		}
		else {
			throw new NotFoundException("Contact Details not found for contactId: "+contactId);
		}

	}

//	@Override
//	public Optional<ContactUs> updateContact(String userName, ContactUs contact) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}

}
