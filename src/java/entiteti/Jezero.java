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
@Table(name="jezero"
    ,catalog="kviskoteka")
public class Jezero {
    
    private String jezero;

    @Id
    //@GeneratedValue(strategy=IDENTITY)
    @Column(name="jezero", unique=true, nullable=false )
    public String getJezero() {
        return jezero;
    }

    public void setJezero(String jezero) {
        this.jezero = jezero;
    }
    
}
