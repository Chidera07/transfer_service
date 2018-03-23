/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamapt.challenge.transferservice.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teamapt.challenge.transferservice.exception.TransactionError;
import teamapt.challenge.transferservice.model.Balances;
import teamapt.challenge.transferservice.model.Transaction;
import teamapt.challenge.transferservice.model.Transfer;
import teamapt.challenge.transferservice.repository.BalanceRepository;
import teamapt.challenge.transferservice.repository.TransactionRepository;

/**
 *
 * @author DERAH PC
 */
@RestController
@RequestMapping("/api")
public class TransferController {
    @Autowired
    BalanceRepository balanceRepository;
    
    @Autowired
    TransactionRepository transactionRepository;
    
    @PostMapping("/transfer")
    public void transfer(@Valid @RequestBody Transfer transfer){
        Balances balanceFrom = balanceRepository.getOne(transfer.getFromAcct());
        Balances balanceTo = balanceRepository.getOne(transfer.getToAcct());
        
        if(balanceFrom.getBalance() - transfer.getAmount() < 0)
            throw new TransactionError("Insufficient Balance");
        else
            balanceFrom.setBalance(balanceFrom.getBalance() - transfer.getAmount());
        
        balanceTo.setBalance(balanceTo.getBalance() + transfer.getAmount());
        balanceRepository.save(balanceFrom);
        balanceRepository.save(balanceTo);
        
        Transaction transactionFrom = new Transaction();
        transactionFrom.setAccount_nr(transfer.getFromAcct());
        transactionFrom.setAmount((float)transfer.getAmount());
        transactionRepository.save(transactionFrom);
        
        Transaction transactionTo = new Transaction();
        transactionTo.setAccount_nr(transfer.getToAcct());
        transactionTo.setAmount((float)transfer.getAmount());
        transactionRepository.save(transactionTo);
    }
}
