package com.antonbondoc.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateStatementDto {

    @NotBlank
    private String statement;
}
