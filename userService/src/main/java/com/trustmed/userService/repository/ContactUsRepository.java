package com.trustmed.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trustmed.userService.entity.ContactUs;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, String> {

}
