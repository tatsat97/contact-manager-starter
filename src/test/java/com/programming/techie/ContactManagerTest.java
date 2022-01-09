package com.programming.techie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {
    @Test
    public void shouldCreateContact(){
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("John", "Doe","0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("John") &&
                        contact.getLastName().equals("Doe") &&
                        contact.getPhoneNumber().equals("0123456789")));
    }

    @Test
    @DisplayName("Should not create contact when First Name is null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, ()->{
            contactManager.addContact(null, "Doe","0123456789");
        });
    }

    @Test
    @DisplayName("Should not create contact when Last Name is null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, ()->{
            contactManager.addContact("John", null,"0123456789");
        });
    }

    @Test
    @DisplayName("Should not create contact when Phone number is null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, ()->{
            contactManager.addContact("Jonn", "Doe",null);
        });
    }

//    Testing for bunch of things
//    for different functionality at the same time
    @DisplayName("This Test uses Value Source")
    @ParameterizedTest
    @ValueSource(strings = {"0123456789", "0123456789", "0123456789"})
    public void shouldTestContactCreationUsingValueSource(String phoneNumber){
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("John","Doe", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1,contactManager.getAllContacts().size());
    }

}