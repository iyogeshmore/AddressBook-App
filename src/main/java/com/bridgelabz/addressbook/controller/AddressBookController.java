package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.iAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(allowedHeaders = "*" , origins = "*")
@RestController
@Slf4j
@RequestMapping("/addressBook")
public class AddressBookController {
    @Autowired
    iAddressBookService addressBookService;

    //--------------------------------- Get All Contact ---------------------------------
    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBook> addressBookList = addressBookService.getAddressBook();
        ResponseDTO responseDTO = new ResponseDTO("Get call successful", addressBookList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Add New Contact ---------------------------------
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook addressBook = addressBookService.addAddressBook(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book data successfully", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Update Contact ---------------------------------
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> editAddressBook(@PathVariable int id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook addressBook = addressBookService.editAddressBook(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Address Book data successfully", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Delete Contact ---------------------------------
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable int id) {
        addressBookService.deleteAddressBook(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted for id: " + id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Get Contact By Id ---------------------------------
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookById(@PathVariable int id) {
        AddressBook addressBook = addressBookService.getAddressBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get call for id successful", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Get Contact By City ---------------------------------
    @GetMapping("/getByCity/{city}")
    public ResponseEntity<ResponseDTO> getAddressBookByCity(@PathVariable String city) {
        List<AddressBook> addressBook = addressBookService.getAddressBookByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Get call for city successful", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Get Contact By State ---------------------------------
    @GetMapping("/getByState/{state}")
    public ResponseEntity<ResponseDTO> getAddressBookByState(@PathVariable String state) {
        List<AddressBook> addressBook = addressBookService.getAddressBookByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Get call for state successful", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Sort Contact By City ---------------------------------
    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDTO> sortAddressBookByCity() {
        List<AddressBook> addressBook = addressBookService.sortAddressBookByCity();
        ResponseDTO responseDTO = new ResponseDTO("Get call for sorted data by city successful", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Sort Contact By State ---------------------------------
    @GetMapping("/sortByState")
    public ResponseEntity<ResponseDTO> sortAddressBookByState() {
        List<AddressBook> addressBook = addressBookService.sortAddressBookByState();
        ResponseDTO responseDTO = new ResponseDTO("Get call for sorted data by state successful", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}




