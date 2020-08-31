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
@Table(name="anagram"
    ,catalog="kviskoteka")
public class Anagram {
    
    private Integer id = 0;
    private String zagonetka;
    private String resenje;

    
    @Id
    //@GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="zagonetka", nullable=false )
    public String getZagonetka() {
        return zagonetka;
    }

    public void setZagonetka(String zagonetka) {
        this.zagonetka = zagonetka;
    }

    
    @Column(name="resenje", nullable=false )
    public String getResenje() {
        return resenje;
    }

    public void setResenje(String resenje) {
        this.resenje = resenje;
    }
    
    
    
    
}
