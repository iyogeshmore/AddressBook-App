package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements iAddressBookService {
    private List<AddressBook> AddressBookList = new ArrayList<>();
    @Autowired
    AddressBookRepository addressBookRepository;
    @Override
    public List<AddressBook> getAddressBookData() {
        return addressBookRepository.findAll();
    }
    @Override
    public AddressBook getAddressBookDataById(int empId) {
        return addressBookRepository.findById(empId).orElseThrow(() -> new AddressBookException("AddressBook Id With " +
                empId + "Does Not Exist"));
    }
    @Override
    public AddressBook createAddressBookData(AddressBookDTO AddressBookDTO){
        AddressBook empData = new AddressBook(AddressBookDTO);
        return addressBookRepository.save(empData);

    }
    @Override
    public AddressBook updateAddressBookData(int empId, AddressBookDTO AddressBookDTO){
        AddressBook AddressBookDetails=new AddressBook(empId,AddressBookDTO);
        addressBookRepository.save(AddressBookDetails);
        return AddressBookDetails;
    }
    @Override
    public String deleteAddressBookData(int empID) {
        addressBookRepository.deleteById(empID);
        return "Data Deleted";
    }
    @Override
    public AddressBook findByCity(String city){
        return addressBookRepository.findByCity(city);
    }

    @Override
    public AddressBook findByState(String state){
        return addressBookRepository.findByState(state);
    }
}