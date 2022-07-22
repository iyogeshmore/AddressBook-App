package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressBookService implements iAddressBookService {
    @Autowired
    private AddressBookRepository repository;

    public void isEmpty(List<AddressBook> addressBookList){
        if(addressBookList.isEmpty())
            throw new AddressBookException("Address Book is empty!");
    }
    @Override
    public List<AddressBook> getAddressBook() {
        List<AddressBook> addressBookList = repository.findAll();
        isEmpty(addressBookList);
        return addressBookList;
    }
    @Override
    public AddressBook addAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        log.debug("Address Book data: "+addressBook.toString());
        return repository.save(addressBook);
    }
    @Override
    public AddressBook getAddressBookById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new AddressBookException("Address Book with id "+id+" not found!"));
    }
    @Override
    public AddressBook editAddressBook(int id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = this.getAddressBookById(id);
        addressBook.updateData(addressBookDTO);
        log.debug("Address Book data: "+addressBook.toString());
        return repository.save(addressBook);
    }
    @Override
    public void deleteAddressBook(int id) {
        AddressBook addressBook = this.getAddressBookById(id);
        repository.delete(addressBook);
    }
    @Override
    public List<AddressBook> getAddressBookByCity(String city) {
        List<AddressBook> addressBookList = repository.findByCity(city);
        if(addressBookList.isEmpty()) {
            throw new AddressBookException("Address Book with city "+city+" not found!");
        }
        return addressBookList;
    }

    @Override
    public List<AddressBook> getAddressBookByState(String state) {
        List<AddressBook> addressBookList = repository.findByState(state);
        if(addressBookList.isEmpty()) {
            throw new AddressBookException("Address Book with state "+state+" not found!");
        }
        return addressBookList;
    }
    @Override
    public List<AddressBook> sortAddressBookByCity() {
        List<AddressBook> addressBookList = repository.findAllByOrderByCity();
        isEmpty(addressBookList);
        return addressBookList;
    }

    @Override
    public List<AddressBook> sortAddressBookByState() {
        List<AddressBook> addressBookList = repository.findAllByOrderByState();
        isEmpty(addressBookList);
        return addressBookList;
    }
}