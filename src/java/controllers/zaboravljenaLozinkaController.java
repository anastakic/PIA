/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import entiteti.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import util.FacesUtil;
import util.HashFunction;
import util.HibernateUtil;
import util.PasswordValidator;

/**
 *
 * @author Ana
 */

@ManagedBean 
@Named(value = "zaboravljenaLozinkaController")
@SessionScoped
public class zaboravljenaLozinkaController implements Serializable{
    
    private String username;
    private String jmbg;
    
    private String pitanje;
    private String odgovor;
    
    private String newPassword;
    private String newPasswordPotvrda;
    
    private boolean provera = false;
    private boolean provera2 = false;

    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordPotvrda() {
        return newPasswordPotvrda;
    }

    public void setNewPasswordPotvrda(String newPasswordPotvrda) {
        this.newPasswordPotvrda = newPasswordPotvrda;
    }

    public boolean isProvera() {
        return provera;
    }

    public void setProvera(boolean provera) {
        this.provera = provera;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public boolean isProvera2() {
        return provera2;
    }

    public void setProvera2(boolean provera2) {
        this.provera2 = provera2;
    }

    
    
    
    public void provera(){
        
        SessionFactory sessionFactory = util.HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(User.class);
        
        User u =(User)cr.add(Restrictions.eq("username",  username)).add(Restrictions.eq("jmbg", jmbg)).uniqueResult();
        
        if(u == null){
            session.getTransaction().commit();
            session.close();
            FacesUtil.reportError("Ne postoji korisnik sa tim username-om ili jmbg-om.");
            provera = false;
            return;
        }
        
        session.getTransaction().commit();
        session.close();
        pitanje = u.getTajnoPitanje();
        provera = true;
        return;

    }
    
    public String provera2(){
        
        String odgovorHash = HashFunction.getHashString(odgovor);
        
        SessionFactory sessionFactory = util.HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(User.class);
        
        User u =(User)cr.add(Restrictions.eq("username",  username)).add(Restrictions.eq("odgovorHash", odgovorHash)).uniqueResult();
        
        if(u == null){
            session.getTransaction().commit();
            session.close();
            FacesUtil.reportError("Odgovor nije dobar.");
            provera2 = false;
            provera = false;
            
            username = "";
            jmbg = "";
            odgovor = "";
            pitanje = "";
            
            
            return Navigation.INDEX + Navigation.FACES_REDIRECT;
        }
        
        session.getTransaction().commit();
        session.close();
        provera2 = true;
        return null;

    }
    
    public String promeniLozinku(){
        
        if (!PasswordValidator.valid(newPassword)) {
            FacesUtil.reportError("Lozinka treba da ima između 8 i 12 karaktera, od čega minimum: 3 mala slova, 1 veliko slovo, 1 cifru, 1 specijalan karakter, mora početi slovom, i jedno za drugim mogu biti najviše dva ista karaktera.");
            return null;
        }
        
        String newPasswordHash = HashFunction.getHashString(newPassword);
        
        SessionFactory sessionFactory = util.HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(User.class);
        
        User u =(User)cr.add(Restrictions.eq("username",  username)).uniqueResult();
        
        u.setPasswordHash(newPasswordHash);
        session.update(u);
        session.getTransaction().commit();
        session.close();
        
        FacesUtil.reportInfo("Uspešno promenjena lozinka.");
        
        username = "";
        jmbg = "";
        odgovor = "";
        pitanje = "";
            
        provera=false;
        provera2=false;
        return Navigation.INDEX + Navigation.FACES_REDIRECT;
    }
    
    
}
