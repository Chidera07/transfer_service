/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamapt.challenge.transferservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teamapt.challenge.transferservice.model.Transaction;

/**
 *
 * @author DERAH PC
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
}
