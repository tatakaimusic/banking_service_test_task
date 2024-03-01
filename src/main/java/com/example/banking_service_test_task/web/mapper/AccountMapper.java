package com.example.banking_service_test_task.web.mapper;

import com.example.banking_service_test_task.model.Account;
import com.example.banking_service_test_task.web.dto.AccountDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AccountMapper extends Mappable<Account, AccountDTO> {
}
