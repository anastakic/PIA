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
@Table(name="planina"
    ,catalog="kviskoteka")
public class Planina {
    private String planina;

    @Id
    //@GeneratedValue(strategy=IDENTITY)
    @Column(name="planina", unique=true, nullable=false )
    public String getPlanina() {
        return planina;
    }

    public void setPlanina(String planina) {
        this.planina = planina;
    }
    
}
