package com.antonbondoc.backend.repository;

import com.antonbondoc.backend.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StatementRepository extends JpaRepository<Statement, UUID> {

    @Query("SELECT MAX(s.rank) FROM Statement s")
    int findLastRank();

    boolean existsByRank(int rank);
}
