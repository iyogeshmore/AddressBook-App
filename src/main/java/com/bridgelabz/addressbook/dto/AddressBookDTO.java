package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor

public @ToString class AddressBookDTO {
    @NotNull(message = "First Name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First Name Invalid")
    public String firstName;

    @NotNull(message = "Last Name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Last Name Invalid")
    public String lastName;

    @NotNull(message = "Phone No cannot be null")
    @Pattern(regexp = "^[0-9]{2}\\s{0,1}[0-9]{10}$",message = "Phone No Is Invalid")
    public String phoneNo;

    @NotNull(message = "City cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "City Is Invalid")
    public String city;

    @NotNull(message = "State cannot be null")
    @Pattern(regexp = "^[a-zA-Z\\s]{2,}$", message = "State Is Invalid")
    public String state;

    @NotNull(message = "ZipCode Cannot Be Empty")
    @Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$",message = "Zip Code Is Invalid")
    public String zipCode;

    @NotNull(message = "Address Cannot Be Empty")
    @Pattern(regexp = "^((.){1,}(\\d){1,}(.){0,})$",message = "Address Is Invalid")
    public String address;
}