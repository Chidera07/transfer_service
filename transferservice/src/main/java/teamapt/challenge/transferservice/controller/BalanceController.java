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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teamapt.challenge.transferservice.exception.ResourceNotFoundException;
import teamapt.challenge.transferservice.model.Balances;
import teamapt.challenge.transferservice.repository.BalanceRepository;

/**
 *
 * @author DERAH PC
 */
@RestController
@RequestMapping("/api")
public class BalanceController {
    @Autowired
    BalanceRepository balanceRepository;
    
    //Get all Balances
    @GetMapping("/balance")
    public List<Balances> getAllBalances(){
        return balanceRepository.findAll();
    }
    
    //Add a new Balance
    @PostMapping("/balance")
    public Balances createTransaction(@Valid @RequestBody Balances balance){
        return balanceRepository.save(balance);
    }
    
    //Get a single Balance
    @GetMapping("/balance/{account_nr}")
    public Balances getBalanceByAccount_nr(@PathVariable(value = "account_nr") Long balanceId){
        return balanceRepository.findById(balanceId).orElseThrow(() -> new ResourceNotFoundException("Balance", "account_nr", balanceId));
    }
}