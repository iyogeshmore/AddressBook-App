package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook,Integer > {
    @Query(value = "select * from address_book where id=id and city = :city",nativeQuery = true)
    List<AddressBook> findByCity(@Param("city") String city);

    @Query(value = "select * from address_book where id=id and state = :state",nativeQuery = true)
    List<AddressBook> findByState(@Param("state") String state);

    @Query(value = "select * from address_book order by city asc",nativeQuery = true)
    List<AddressBook> findAllByOrderByCity();

    @Query(value = "select * from address_book order by state asc",nativeQuery = true)
    List<AddressBook> findAllByOrderByState();
//List<AddressBook> findByCity(String city);
//    List<AddressBook> findByState(String state);
//    List<AddressBook> findAllByOrderByCity();
//    List<AddressBook> findAllByOrderByState();
}