package com.antonbondoc.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatementDto {
    private final int rank;
    private final String statement;
}
