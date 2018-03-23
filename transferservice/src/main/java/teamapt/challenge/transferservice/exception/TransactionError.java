/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamapt.challenge.transferservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author DERAH PC
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class TransactionError extends RuntimeException{
    public TransactionError(String response){
        super(response);
    }
}
