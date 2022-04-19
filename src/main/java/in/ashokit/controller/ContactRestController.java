package in.ashokit.controller;

import java.util.List;

import in.ashokit.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.ashokit.entiry.Contact;
import in.ashokit.service.ContactService;
import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/demo")
public class ContactRestController {

    @Autowired
    private ContactServiceImpl contactService;

    public ContactRestController(ContactServiceImpl contactService){
        this.contactService=  contactService;
    }

    @PostMapping("/contact")
    public Contact upsert(@RequestBody Contact contact) {
        return contactService.upsert(contact);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contactList = contactService.getAllContacts();
        return ResponseEntity.ok().body(contactList);
    }

    @GetMapping("/contact/{cid}")
    public ResponseEntity<Contact> getContact(@PathVariable int cid) {

        return ResponseEntity.ok(contactService.getContact(cid));
    }

    @DeleteMapping("/contact/{cid}")
    public ResponseEntity<String> deleteContact(@PathVariable Integer cid) {
         contactService.deleteContact(cid);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("deleted");
    }

}
