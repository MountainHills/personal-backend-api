package com.antonbondoc.backend.controller;

import com.antonbondoc.backend.dto.StatementDto;
import com.antonbondoc.backend.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/missions")
public class MissionController {

    private final MissionService missionService;

    @GetMapping
    public ResponseEntity<List<StatementDto>> getStatements() {
        return ResponseEntity.ok(missionService.getStatements());
    }

    @PostMapping
    public ResponseEntity<StatementDto> createStatement() {
        return ResponseEntity.ok(missionService.createStatement());
    }

    @PutMapping("/{statement-id}")
    public ResponseEntity<StatementDto> updateStatement() {
        return ResponseEntity.ok(missionService.updateStatement());
    }

    @DeleteMapping("/{statement-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteStatement() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
