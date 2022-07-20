package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook,Integer > {
    @Query(value = "select * from address_book where city = :city",nativeQuery = true)
    AddressBook findByCity(@Param("city") String city);

    @Query(value = "select * from address_book where state = :state",nativeQuery = true)
    AddressBook findByState(@Param("state") String state);
}