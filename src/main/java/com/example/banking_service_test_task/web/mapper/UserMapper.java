package com.example.banking_service_test_task.web.mapper;

import com.example.banking_service_test_task.model.User;
import com.example.banking_service_test_task.web.dto.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDTO> {
}
