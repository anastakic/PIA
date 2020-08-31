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
@Table(name="muzickagrupa"
    ,catalog="kviskoteka")
public class MuzickaGrupa {
    
    private String muzickagrupa;

    @Id
    //@GeneratedValue(strategy=IDENTITY)
    @Column(name="muzickagrupa", unique=true, nullable=false )
    public String getMuzickagrupa() {
        return muzickagrupa;
    }

    public void setMuzickagrupa(String muzickagrupa) {
        this.muzickagrupa = muzickagrupa;
    }
    
}
