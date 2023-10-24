package com.example.sign_up_validation.model;

import org.apache.catalina.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    //    Firstname, lastname bắt buộc, có độ dài tối thiểu 5, tối đa 45 ký tự
//
//    Phonenumber đúng quy tắc của sđt
//
//    Age >=18
//
//    Email đúng quy tắc của email
    @NotEmpty(message = "Fist name is required!")
    @NotBlank(message = "Fist name is required!")
    @Size(min=5, max=45, message = "The length of first name must be minimum at 5 and maximum at 45")
    private String firstName;
    @NotEmpty(message = "Last name is required!")
    @NotBlank(message = "Last name is required!")
    @Size(min=5, max=45, message = "The length of last name must be minimum at 5 and maximum at 45")
    private String lastName;
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})")
    private String phoneNumber;
    @Min(18)
    private int age;
    @Email
    private String email;
    public UserDto() {}

    public UserDto(String firstName, String lastName, String phoneNumber, int age, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if("admin".equals(userDto.getFirstName())){
            errors.rejectValue("firstName",
                    "null",
                    "Do not enter as admin!");
        }

    }
}
