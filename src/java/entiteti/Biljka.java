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
@Table(name="biljka"
    ,catalog="kviskoteka")
public class Biljka {
    
    private String biljka;
    
    @Id
    //@GeneratedValue(strategy=IDENTITY)
    @Column(name="biljka", unique=true, nullable=false )
    public String getBiljka() {
        return biljka;
    }

    public void setBiljka(String biljka) {
        this.biljka = biljka;
    }
    
    
}
