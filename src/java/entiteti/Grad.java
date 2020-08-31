/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiteti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ana
 */
@Entity
@Table(name="grad"
    ,catalog="kviskoteka")
public class Grad {
    
    private String grad;

    @Id
    //@GeneratedValue(strategy=IDENTITY)
    @Column(name="grad", unique=true, nullable=false )
    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }
    
}
