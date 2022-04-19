package in.ashokit.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.ashokit.entiry.Contact;

public interface ContactService {


public Contact getContact(int cid);

public List<Contact> getAllContacts();

public Contact upsert(Contact contact);

public String deleteContact(Integer cid);
}
