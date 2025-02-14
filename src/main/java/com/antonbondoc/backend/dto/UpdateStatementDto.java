package com.antonbondoc.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdateStatementDto {

    @NotBlank
    private String statement;

    @Positive
    private int rank;
}
