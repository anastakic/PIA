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
@Table(name="drzava"
    ,catalog="kviskoteka")
public class Drzava {
    
    private String drzava;

    @Id
    //@GeneratedValue(strategy=IDENTITY)
    @Column(name="drzava", unique=true, nullable=false )
    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }
    
    
}
