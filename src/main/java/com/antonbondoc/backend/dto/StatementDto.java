package com.antonbondoc.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class StatementDto {
    private final UUID id;
    private final int rank;
    private final String statement;
}
