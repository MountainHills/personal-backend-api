package com.antonbondoc.backend.service;

import com.antonbondoc.backend.dto.CreateStatementDto;
import com.antonbondoc.backend.dto.StatementDto;
import com.antonbondoc.backend.model.Statement;
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

    public StatementDto createStatement(CreateStatementDto request) {
        int lastRank = statementRepository.findLastRank();

        Statement statement = Statement.builder()
                .statement(request.getStatement())
                .rank(lastRank + 1)
                .build();

        statement = statementRepository.save(statement);

        return StatementDto.builder()
                .id(statement.getId())
                .rank(statement.getRank())
                .statement(statement.getStatement())
                .build();
    }

    public StatementDto updateStatement() {
        return StatementDto.builder().build();
    }

    public void deleteStatement() {
        // No-op
    }
}
