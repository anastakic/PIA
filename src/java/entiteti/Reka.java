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
@Table(name="reka"
    ,catalog="kviskoteka")
public class Reka {
    private String reka;

    @Id
    //@GeneratedValue(strategy=IDENTITY)
    @Column(name="reka", unique=true, nullable=false )
    public String getReka() {
        return reka;
    }

    public void setReka(String reka) {
        this.reka = reka;
    }
    
}
