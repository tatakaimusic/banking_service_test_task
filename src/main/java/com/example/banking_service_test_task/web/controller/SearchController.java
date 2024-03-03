package com.example.banking_service_test_task.web.controller;

import com.example.banking_service_test_task.service.SearchService;
import com.example.banking_service_test_task.web.dto.UserDTO;
import com.example.banking_service_test_task.web.dto.validation.OnCreate;
import com.example.banking_service_test_task.web.dto.validation.OnUpdate;
import com.example.banking_service_test_task.web.mapper.UserMapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/app/search")
@Validated
@Tag(name = "Search controller")
public class SearchController {

    private final SearchService searchService;
    private final UserMapper userMapper;

    @Autowired
    public SearchController(SearchService service, UserMapper userMapper) {
        this.searchService = service;
        this.userMapper = userMapper;
    }

    @GetMapping("/birth")
    public List<UserDTO> filterByBirth(
            @RequestParam(value = "birth")
            @JsonFormat(pattern = "yyyy-MM-dd")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            Date birth
    ) {
        return userMapper.toDto(searchService.filterByBirth(birth));
    }

    @GetMapping("/phone")
    public UserDTO filterByPhoneNumber(
            @RequestParam(value = "phone")
            @Pattern(
                    regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$",
                    message = "Phone number must be Russian format!",
                    groups = {OnCreate.class, OnUpdate.class}
            )
            String phoneNumber
    ) {
        return userMapper.toDto(searchService.filterByPhoneNumber(phoneNumber));
    }

    @GetMapping("/name")
    public List<UserDTO> filterByName(
            @RequestParam(value = "name") String name
    ) {
        return userMapper.toDto(searchService.filterByName(name));
    }

    @GetMapping("/email")
    public UserDTO filterByEmail(
            @RequestParam(value = "email")
            @Email String email
    ) {
        return userMapper.toDto(searchService.filterByEmail(email));
    }

}
