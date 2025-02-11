package com.antonbondoc.backend.service;

import com.antonbondoc.backend.dto.StatementDto;
import com.antonbondoc.backend.repository.StatementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final StatementRepository statementRepository;

    public List<StatementDto> getStatements() {
        return statementRepository.findAll(Sort.by(Sort.Direction.ASC, "rank"))
                .stream()
                .map(s -> StatementDto.builder()
                        .id(s.getId())
                        .rank(s.getRank())
                        .statement(s.getStatement())
                        .build())
                .toList();
    }

    public StatementDto createStatement() {
        return StatementDto.builder().build();
    }

    public StatementDto updateStatement() {
        return StatementDto.builder().build();
    }

    public void deleteStatement() {
        // No-op
    }
}
