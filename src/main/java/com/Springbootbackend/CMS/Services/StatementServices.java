package com.Springbootbackend.CMS.Services;
import com.Springbootbackend.CMS.Model.Statement;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface StatementServices {
    void createTransaction(Statement transaction);

    Optional<Statement> getTransaction(Long id);

    Statement updateTransaction(Statement transaction);

    void deleteTransaction(Long id);

}
