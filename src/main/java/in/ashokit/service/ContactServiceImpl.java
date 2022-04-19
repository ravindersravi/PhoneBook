package in.ashokit.service;

import in.ashokit.entiry.Contact;
import in.ashokit.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact getContact(int cid) {
        return contactRepository.getById(cid);
    }

    @Override
    public List<Contact> getAllContacts() {
        return  contactRepository.findAll();
    }

    @Override
    public Contact upsert(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public String deleteContact(Integer cid) {

         contactRepository.deleteById(cid);

         return "success";
    }
}
