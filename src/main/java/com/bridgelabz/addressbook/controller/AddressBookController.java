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
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class AddressBookController {

    @Autowired
    iAddressBookService iAddressBookService;

    List<AddressBook> addressDatalist = new ArrayList<>();

    @RequestMapping(value = {"","/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        addressDatalist = iAddressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", addressDatalist);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("empId") int empID) {
        AddressBook addressBookData = iAddressBookService.getAddressBookDataById(empID);
        ResponseDTO responseDTO= new ResponseDTO("Get Call For ID Successful", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> createAddressBookData(
            @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook addressBookData = iAddressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO= new ResponseDTO("Created AddressBook  Data Successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable int id,@Valid @RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO responseDTO= new ResponseDTO("Updated AddressBook Details Successfully", iAddressBookService.updateAddressBookData(id,addressBookDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity <ResponseDTO> deleteAddressBookData(@PathVariable("Id") int Id) {
        iAddressBookService.deleteAddressBookData(Id);
        ResponseDTO responseDTO= new ResponseDTO("Deleted Successfully", "Deleted id: "+Id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<ResponseDTO> getCityAddressBookData(@PathVariable("city") String city) {
        AddressBook addressBookDataList = iAddressBookService.findByCity (city);
        ResponseDTO responseDTO= new ResponseDTO("Get Call For ID Successful", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<ResponseDTO> getStateAddressBookData(@PathVariable("state") String state) {
        AddressBook addressBookDataList = iAddressBookService.findByState(state);
        ResponseDTO responseDTO= new ResponseDTO("Get Call For ID Successful", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}