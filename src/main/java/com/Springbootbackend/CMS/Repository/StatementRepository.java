package com.Springbootbackend.CMS.Repository;
import com.Springbootbackend.CMS.Model.Statement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRepository extends JpaRepository<Statement, Long> {
}

