package com.Springbootbackend.CMS.Controller;
import com.Springbootbackend.CMS.Model.Statement;
import com.Springbootbackend.CMS.Services.StatementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transaction;

@RestController
public class StatementController {

    @Autowired
    StatementServices statementServices;

    @PostMapping("transaction/create")
    ResponseEntity<Statement> createStatement(@RequestBody Statement statement){
        statementServices.createTransaction(statement);
        if(statement.getTransactionType().equals("DEBIT")) {
            Statement chargeTransaction = new Statement();
            chargeTransaction.setTransactionType("DEBIT");
            chargeTransaction.setCreditAmount(String.valueOf(Long.valueOf(statement.getDebitAmount()) * .02));
            chargeTransaction.setDebitAmount(chargeTransaction.getCreditAmount());
            chargeTransaction.setCreditNarration("2% Debit Charge");
            chargeTransaction.setDebitNarration("2% Debit Charge");
            statementServices.createTransaction(chargeTransaction);
        }
        return new ResponseEntity<>(statement, HttpStatus.CREATED);
    }
    @PostMapping("transaction/get")
    ResponseEntity<Statement> getTransaction(@RequestBody String id){
        Statement transaction = statementServices.getTransaction(Long.valueOf(id)).orElse(new Statement());
        if(transaction.getId().toString().isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Statement>(transaction, HttpStatus.CREATED);
    }
    @PostMapping("transaction/update")
    ResponseEntity<Statement> updateTransaction(@RequestBody Statement transaction){
        Statement updatedTransaction;
        if(statementServices.updateTransaction(transaction).getId().toString().isEmpty())
            return new ResponseEntity<>(new Statement(), HttpStatus.NOT_FOUND);
        updatedTransaction = statementServices.updateTransaction(transaction);
        return new ResponseEntity<Statement>(updatedTransaction, HttpStatus.OK);
    }
    @PostMapping("transaction/delete")
    ResponseEntity<String> deleteTransaction(@RequestBody String id){
        if(!statementServices.getTransaction(Long.valueOf(id)).isPresent()){
            return new ResponseEntity<>("Transaction Not Found!",HttpStatus.NOT_FOUND);
        }
        statementServices.deleteTransaction(Long.valueOf(id));

        return new ResponseEntity<>("Transaction with id " + id + " has been successfully deleted!", HttpStatus.OK);
    }

}