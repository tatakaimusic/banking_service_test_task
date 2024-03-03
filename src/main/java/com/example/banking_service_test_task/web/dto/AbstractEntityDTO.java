package com.example.banking_service_test_task.web.dto;


import com.example.banking_service_test_task.web.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class AbstractEntityDTO {

    @Schema(hidden = true)
    @NotNull(
            message = "Id must be not null!",
            groups = OnUpdate.class
    )
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
