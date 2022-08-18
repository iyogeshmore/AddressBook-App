package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNo;

    public AddressBook(AddressBookDTO addressBookDTO){
        this.updateData(addressBookDTO);
    }
    public void updateData(AddressBookDTO addressBookDTO){
        this.fullName=addressBookDTO.fullName;
        this.address=addressBookDTO.address;
        this.city=addressBookDTO.city;
        this.state=addressBookDTO.state;
        this.zipCode=addressBookDTO.zipCode;
        this.phoneNo=addressBookDTO.phoneNo;
    }
}