package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBook {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String city;
    private String state;
    private String zipCode;
    private String address;

    public AddressBook(AddressBookDTO addressBookDTO){
        this.firstName=addressBookDTO.firstName;
        this.lastName=addressBookDTO.lastName;
        this.phoneNo=addressBookDTO.phoneNo;
        this.city=addressBookDTO.city;
        this.state=addressBookDTO.state;
        this.zipCode=addressBookDTO.zipCode;
        this.address=addressBookDTO.address;
    }
    public AddressBook(int id,AddressBookDTO addressBookDTO)
    {
        this.id=id;
        this.firstName=addressBookDTO.firstName;
        this.lastName=addressBookDTO.lastName;
        this.phoneNo=addressBookDTO.phoneNo;
        this.city=addressBookDTO.city;
        this.state=addressBookDTO.state;
        this.zipCode=addressBookDTO.zipCode;
        this.address=addressBookDTO.address;
    }
}