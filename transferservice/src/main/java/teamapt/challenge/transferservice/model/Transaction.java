/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamapt.challenge.transferservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author DERAH PC
 */
@Entity
@Table(name = "transactions")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = "reference")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reference;
    
    @NotNull
    private float amount;
    
    @NotNull
    private Long account_nr;
    
    public Long getReference(){
        return reference;
    }
    
    public float getAmount(){
        return amount;
    }
    
    public void setAmount(float amount){
        this.amount = amount;
    }
    
    public Long getAccount_nr(){
        return account_nr;
    }
    
    public void setAccount_nr(Long account_nr){
        this.account_nr = account_nr;
    }
}