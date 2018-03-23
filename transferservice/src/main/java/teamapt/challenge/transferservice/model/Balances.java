/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamapt.challenge.transferservice.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author DERAH PC
 */
@Entity
@Table(name = "balances")
@EntityListeners(AuditingEntityListener.class)
public class Balances implements Serializable{
    @Id
    @Column(nullable = false)
    private Long account_nr;
    
    @NotNull
    private Long balance;
    
    public Long getAccount_nr(){
        return account_nr;
    }
    
    public void setAccount_nr(Long account_nr){
        this.account_nr = account_nr;
    }
    
    public Long getBalance(){
        return balance;
    }
    
    public void setBalance(Long balance){
        this.balance = balance;
    }
}
