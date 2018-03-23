/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamapt.challenge.transferservice.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import teamapt.challenge.transferservice.exception.ResourceNotFoundException;
import teamapt.challenge.transferservice.model.Transaction;
import teamapt.challenge.transferservice.repository.TransactionRepository;

/**
 *
 * @author DERAH PC
 */
@RestController
@RequestMapping("/api")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;
    
    //Get all Transactions
    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }
    
    //Create a new Transaction
    @PostMapping("/transactions")
    public Transaction createTransaction(@Valid @RequestBody Transaction transaction){
        return transactionRepository.save(transaction);
    }
    
    //Get a single Transaction
    @GetMapping("/transactions/{reference}")
    public Transaction getTransactionByReference(@PathVariable(value = "reference") Long transRef){
        return transactionRepository.findById(transRef).orElseThrow(() -> new ResourceNotFoundException("Transaction", "reference", transRef));
    }
    
    //Update a Transaction
    @PutMapping("/transactions/{reference}")
    public Transaction updateTransaction(@PathVariable(value = "reference")Long transRef,
            @Valid @RequestBody Transaction transactionDetails){
        Transaction transaction = transactionRepository.findById(transRef).orElseThrow(() -> new ResourceNotFoundException("Transaction", "reference", transRef));
        transaction.setAmount(transactionDetails.getAmount());
        transaction.setAccount_nr(transactionDetails.getAccount_nr());
        
        Transaction updatedTransaction = transactionRepository.save(transaction);
        return updatedTransaction;
    }
    
    //Delete a Transaction
    @DeleteMapping("/transactions/{reference}")
    public ResponseEntity<?> deleteTransaction(@PathVariable(value = "reference") Long transRef){
        Transaction transaction = transactionRepository.findById(transRef).orElseThrow(() -> new ResourceNotFoundException("Transaction", "reference", transRef));
        transactionRepository.delete(transaction);
        return ResponseEntity.ok().build();
    }
}