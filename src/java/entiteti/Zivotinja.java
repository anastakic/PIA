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
@Table(name="zivotinja"
    ,catalog="kviskoteka")
public class Zivotinja {
    private String zivotinja;

    @Id
    //@GeneratedValue(strategy=IDENTITY)
    @Column(name="zivotinja", unique=true, nullable=false )
    public String getZivotinja() {
        return zivotinja;
    }

    public void setZivotinja(String zivotinja) {
        this.zivotinja = zivotinja;
    }
    
}
