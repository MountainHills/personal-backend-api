package com.antonbondoc.backend.service;

import com.antonbondoc.backend.dto.CreateStatementDto;
import com.antonbondoc.backend.dto.StatementDto;
import com.antonbondoc.backend.dto.UpdateStatementDto;
import com.antonbondoc.backend.model.Statement;
import com.antonbondoc.backend.repository.StatementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public StatementDto updateStatement(UUID statementId, UpdateStatementDto request) {
        if (statementRepository.existsByRank(request.getRank())) {
            throw new IllegalArgumentException("Statement can not have the same rank");
        }

        Statement statement = statementRepository.findById(statementId)
                .orElseThrow(() -> new IllegalArgumentException("Statement does not exist"));

        statement.setStatement(request.getStatement());
        statement.setRank(request.getRank());

        statement = statementRepository.save(statement);

        return StatementDto.builder()
                .id(statement.getId())
                .rank(statement.getRank())
                .statement(statement.getStatement())
                .build();
    }

    public void deleteStatement(UUID statementId) {
        Statement statement = statementRepository.findById(statementId)
                .orElseThrow(() -> new IllegalArgumentException("Statement does not exist"));

        statementRepository.delete(statement);
    }
}
