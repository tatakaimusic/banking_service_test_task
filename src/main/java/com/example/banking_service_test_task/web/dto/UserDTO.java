package com.example.banking_service_test_task.web.dto;

import com.example.banking_service_test_task.web.dto.validation.OnCreate;
import com.example.banking_service_test_task.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Schema(description = "User DTO")
public class UserDTO extends AbstractEntityDTO {

    @Schema(description = "username", example = "Bob")
    @NotNull(
            message = "Username must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @Length(
            max = 100,
            message = "Username must be smaller than 36 symbols!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private String username;

    @Schema(description = "password", example = "12345")
    @NotNull(
            message = "Password must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @Length(
            max = 100,
            message = "Password must be smaller than 36 symbols!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private String password;

    @Schema(description = "name", example = "Bob")
    @NotNull(
            message = "Name must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @Length(
            max = 100,
            message = "Name must be smaller than 36 symbols!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private String name;

    @Schema(description = "email", example = "bob@mail.ru")
    @Email(
            message = "Email must has an email format!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @NotNull(
            message = "Email must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private String email;

    @Schema(description = "Phone number", example = "89771983512")
    @Pattern(
            regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$",
            message = "Phone number must be Russian format!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @NotNull(
            message = "Phone number must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private String phoneNumber;

    @Schema(description = "Date of birth", example = "2003-02-26")
    @NotNull(
            message = "Date of birth must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Schema(description = "amount", example = "100")
    @NotNull(
            message = "Amount must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private double amount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
