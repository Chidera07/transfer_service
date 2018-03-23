/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamapt.challenge.transferservice.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DERAH PC
 */
public class Transfer implements Serializable{
    @NotNull
    private Long fromAcct;
    
    @NotNull
    private Long toAcct;
    
    @NotNull
    private Long amount;

    public Long getFromAcct() {
        return fromAcct;
    }

    public void setFromAcct(Long fromAcct) {
        this.fromAcct = fromAcct;
    }

    public Long getToAcct() {
        return toAcct;
    }

    public void setToAcct(Long toAcct) {
        this.toAcct = toAcct;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}