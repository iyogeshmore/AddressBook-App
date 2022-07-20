package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;

import java.util.List;

public interface iAddressBookService {
    List<AddressBook> getAddressBookData();

    AddressBook  getAddressBookDataById(int empId);

    AddressBook createAddressBookData(AddressBookDTO AddressBookDTO);

    AddressBook updateAddressBookData(int empId, AddressBookDTO AddressBookDTO);

    String deleteAddressBookData(int empID);

    AddressBook findByCity(String city);

    AddressBook findByState(String city);
}