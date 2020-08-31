/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entiteti.*;
import entiteti.Zahtev;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import util.FacesUtil;
import util.HashFunction;
import util.HibernateUtil;
import util.SessionUtils;

/**
 *
 * @author Ana
 */

@ManagedBean 
@Named(value = "supervizorController")
@SessionScoped
public class supervizorController implements Serializable{
    
    public static List<Zahtev> pregledaniZahtevi = new ArrayList<>();
    public static List<Zahtev> zahtevi = new ArrayList<>();
   
    private String zagonetka;
    private String resenje;
    private String rec;
    private String pitanje1;
    private String odgovor1;
    private String pitanje2;
    private String odgovor2;
    private String pitanje3;
    private String odgovor3;
    private String pitanje4;
    private String odgovor4;
    private String pitanje5;
    private String odgovor5;
    private String pitanje6;
    private String odgovor6;
    private String pitanje7;
    private String odgovor7;
    private String pitanje8;
    private String odgovor8;
    private String pitanje9;
    private String odgovor9;
    private String pitanje10;
    private String odgovor10;
    private String pitanje11;
    private String odgovor11;
    private String pitanje12;
    private String odgovor12;
    private String pitanje13;
    private String odgovor13;
    
    private boolean anagramDis = false;
    private boolean vesanjeDis = false;
    private boolean peharDis = false;
    
    private String porukaAnagram;
    private String porukaVesanje;
    private String porukaPehar;
    
    private boolean anagramBoja = false;
    private boolean vesanjeBoja = false;
    private boolean peharBoja = false;
    
    
    public void snimi(Zahtev zahtev){
        zahtev.setPregledano(true);
        pregledaniZahtevi.add(zahtev);
        zahtevi.remove(zahtev);
        
    }
    
    public void dodajAnagram(){
        String p = resenje.toLowerCase();
        resenje = p;
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        
        session.beginTransaction();
        Criteria cr = session.createCriteria(Anagram.class);
            
        Anagram a = (Anagram)cr.add(Restrictions.eq("resenje", resenje)).uniqueResult();
        
        if(a!=null){
            session.getTransaction().commit();
            session.close();
            zagonetka = "";
            resenje = "";
            anagramBoja = false;
            anagramDis = true;
            porukaAnagram = "Ovakav anagram već postoji.";
            return;
        }
        
        Anagram novi = new Anagram();
        
        novi.setResenje(resenje);
        novi.setZagonetka(zagonetka);
        //session.save(a);
        session.persist(novi);
        
        session.getTransaction().commit();
        session.close();
        zagonetka = "";
        resenje = "";
        anagramBoja = true;
        anagramDis = true;
        porukaAnagram = "Uspešno dodat anagram.";
        /*
        String p = resenje.toLowerCase();
        resenje = p;
        
        boolean m = daLiImaAnagram();//true je ako je ima 
        if(m){
            zagonetka = "";
            resenje = "";
            anagramBoja = false;
            anagramDis = true;
            porukaAnagram = "Ovakav anagram već postoji.";
            return;
        }
        
        Anagram a = new Anagram();
        a.setResenje(resenje);
        a.setZagonetka(zagonetka);
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        
        session.beginTransaction();
            
        //session.save(a);
        session.persist(a);  
        
        session.getTransaction().commit();
        session.close();
        zagonetka = "";
        resenje = "";
        anagramBoja = true;
        anagramDis = true;
        porukaAnagram = "Uspešno dodat anagram.";
        
        */
    }
    
    public void dodajVesanje(){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        
        session.beginTransaction();
        Criteria cr = session.createCriteria(Vesanje.class);
            
        Vesanje v = (Vesanje)cr.add(Restrictions.eq("rec", rec)).uniqueResult(); 
        
        if(v!=null){
            session.getTransaction().commit();
            session.close();
            rec = "";
            vesanjeBoja = false;
            vesanjeDis = true;
            porukaVesanje = "Ovakva reč za igru vešanje već postoji.";
            return;
        }
        
        Vesanje nova = new Vesanje();
        
        nova.setRec(rec);
        //session.save(v);
        session.persist(nova);
        
        session.getTransaction().commit();
        session.close();
        rec = "";
        vesanjeBoja = true;
        vesanjeDis = true;
        porukaVesanje = "Uspešno dodat pojam.";
           
        
    }

    public void dodajPehar(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        try{
        session.beginTransaction();
        Criteria cr = session.createCriteria(Pehar.class);
        
        Pehar novi = new Pehar();
        
        novi.setOdgovor1(odgovor1.toLowerCase());
        novi.setOdgovor2(odgovor2.toLowerCase());
        novi.setOdgovor3(odgovor3.toLowerCase());
        novi.setOdgovor4(odgovor4.toLowerCase());
        novi.setOdgovor5(odgovor5.toLowerCase());
        novi.setOdgovor6(odgovor6.toLowerCase());
        novi.setOdgovor7(odgovor7.toLowerCase());
        novi.setOdgovor8(odgovor8.toLowerCase()); 
        novi.setOdgovor9(odgovor9.toLowerCase());
        novi.setOdgovor10(odgovor10.toLowerCase()); 
        novi.setOdgovor11(odgovor11.toLowerCase());
        novi.setOdgovor12(odgovor12.toLowerCase()); 
        novi.setOdgovor13(odgovor13.toLowerCase());
        
        novi.setPitanje1(pitanje1);
        novi.setPitanje2(pitanje2);
        novi.setPitanje3(pitanje3);
        novi.setPitanje4(pitanje4);
        novi.setPitanje5(pitanje5);
        novi.setPitanje6(pitanje6);
        novi.setPitanje7(pitanje7);
        novi.setPitanje8(pitanje8);
        novi.setPitanje9(pitanje9);
        novi.setPitanje10(pitanje10);
        novi.setPitanje11(pitanje11);
        novi.setPitanje12(pitanje12);
        novi.setPitanje13(pitanje13);
        
        
        session.persist(novi);
        
        
        peharBoja = true;
        peharDis = true;
        porukaPehar = "Uspešno dodat pehar.";
        }
        catch(Exception e){
            e.printStackTrace();
            peharBoja = false;
            peharDis = true;
            porukaPehar = "Desila se greška prilikom dodavanja pehara u bazu.";
        }
        finally{
            pitanje1 = "";
            pitanje2 = "";
            pitanje3 = "";
            pitanje4 = "";
            pitanje5 = "";
            pitanje6 = "";
            pitanje7 = "";
            pitanje8 = "";
            pitanje9 = "";
            pitanje10 = "";
            pitanje11 = "";
            pitanje12 = "";
            pitanje13 = "";

            odgovor1 = "";
            odgovor2 = "";
            odgovor3 = "";
            odgovor4 = "";
            odgovor5 = "";
            odgovor6 = "";
            odgovor7 = "";
            odgovor8 = "";
            odgovor9 = "";
            odgovor10 = "";
            odgovor11 = "";
            odgovor12 = "";
            odgovor13 = "";
            session.getTransaction().commit();
            session.close();
        }
    }
    
    
    
    
    public void resetujVesanje(){
        porukaVesanje = "";
        vesanjeDis = false;
    }
    
    public void resetujPehar(){
        porukaPehar = "";
        peharDis = false;
    }

    
    
    
    
    
    
    
    
    public boolean daLiImaAnagram(){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        
        
        try {
            session.beginTransaction();
            Criteria cr = session.createCriteria(Anagram.class);
        
            Anagram a = (Anagram)cr.add(Restrictions.eq("resenje", resenje)).uniqueResult(); 
            if(a!=null){
            return true;
        }
        else{ return false;}
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return true;
            
        } finally {
            session.getTransaction().commit();
            session.close();
        }
        
        
        /*
        SessionFactory sessionF = util.HibernateUtil.getSessionFactory();
        Session session = sessionF.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(Anagram.class);
        
        Anagram a = (Anagram)cr.add(Restrictions.eq("resenje", resenje)).uniqueResult(); 
        
        session.getTransaction().commit();
        session.close(); 
        
        if(a!=null){
            return true;
        }
        else{ return false;}*/
    }
    
    

    public boolean daLiImaVesanje(){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        
        
        try {
            session.beginTransaction();
            Criteria cr = session.createCriteria(Vesanje.class);
            
            Vesanje v = (Vesanje)cr.add(Restrictions.eq("rec", rec)).uniqueResult(); 
        
            if(v!=null){
                return true;
            }
            else{ return false;}
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return true;
            
        } finally {
            session.getTransaction().commit();
            session.close();
        }
        /*
        SessionFactory sessionF = util.HibernateUtil.getSessionFactory();
        Session session = sessionF.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(Vesanje.class);
        
        Vesanje v = (Vesanje)cr.add(Restrictions.eq("rec", rec)).uniqueResult(); 
        
        session.getTransaction().commit();
        session.close(); 
        
        if(v!=null){
            return true;
        }
        else{ return false;}*/
    } 
     
    
    public List<Zahtev> getPregledaniZahtevi() {
        return pregledaniZahtevi;
    }

    public void setPregledaniZahtevi(List<Zahtev> pregledaniZahtevi) {
        supervizorController.pregledaniZahtevi = pregledaniZahtevi;
    }

    public List<Zahtev> getZahtevi() {
        return zahtevi;
    }

    public void setZahtevi(List<Zahtev> zahtevi) {
        supervizorController.zahtevi = zahtevi;
    }

    public String getZagonetka() {
        return zagonetka;
    }

    public void setZagonetka(String zagonetka) {
        this.zagonetka = zagonetka;
    }

    public String getResenje() {
        return resenje;
    }

    public void setResenje(String resenje) {
        this.resenje = resenje;
    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public String getPitanje1() {
        return pitanje1;
    }

    public void setPitanje1(String pitanje1) {
        this.pitanje1 = pitanje1;
    }

    public String getOdgovor1() {
        return odgovor1;
    }

    public void setOdgovor1(String odgovor1) {
        this.odgovor1 = odgovor1;
    }

    public String getPitanje2() {
        return pitanje2;
    }

    public void setPitanje2(String pitanje2) {
        this.pitanje2 = pitanje2;
    }

    public String getOdgovor2() {
        return odgovor2;
    }

    public void setOdgovor2(String odgovor2) {
        this.odgovor2 = odgovor2;
    }

    public String getPitanje3() {
        return pitanje3;
    }

    public void setPitanje3(String pitanje3) {
        this.pitanje3 = pitanje3;
    }

    public String getOdgovor3() {
        return odgovor3;
    }

    public void setOdgovor3(String odgovor3) {
        this.odgovor3 = odgovor3;
    }

    public String getPitanje4() {
        return pitanje4;
    }

    public void setPitanje4(String pitanje4) {
        this.pitanje4 = pitanje4;
    }

    public String getOdgovor4() {
        return odgovor4;
    }

    public void setOdgovor4(String odgovor4) {
        this.odgovor4 = odgovor4;
    }

    public String getPitanje5() {
        return pitanje5;
    }

    public void setPitanje5(String pitanje5) {
        this.pitanje5 = pitanje5;
    }

    public String getOdgovor5() {
        return odgovor5;
    }

    public void setOdgovor5(String odgovor5) {
        this.odgovor5 = odgovor5;
    }

    public String getPitanje6() {
        return pitanje6;
    }

    public void setPitanje6(String pitanje6) {
        this.pitanje6 = pitanje6;
    }

    public String getOdgovor6() {
        return odgovor6;
    }

    public void setOdgovor6(String odgovor6) {
        this.odgovor6 = odgovor6;
    }

    public String getPitanje7() {
        return pitanje7;
    }

    public void setPitanje7(String pitanje7) {
        this.pitanje7 = pitanje7;
    }

    public String getOdgovor7() {
        return odgovor7;
    }

    public void setOdgovor7(String odgovor7) {
        this.odgovor7 = odgovor7;
    }

    public String getPitanje8() {
        return pitanje8;
    }

    public void setPitanje8(String pitanje8) {
        this.pitanje8 = pitanje8;
    }

    public String getOdgovor8() {
        return odgovor8;
    }

    public void setOdgovor8(String odgovor8) {
        this.odgovor8 = odgovor8;
    }

    public String getPitanje9() {
        return pitanje9;
    }

    public void setPitanje9(String pitanje9) {
        this.pitanje9 = pitanje9;
    }

    public String getOdgovor9() {
        return odgovor9;
    }

    public void setOdgovor9(String odgovor9) {
        this.odgovor9 = odgovor9;
    }

    public String getPitanje10() {
        return pitanje10;
    }

    public void setPitanje10(String pitanje10) {
        this.pitanje10 = pitanje10;
    }

    public String getOdgovor10() {
        return odgovor10;
    }

    public void setOdgovor10(String odgovor10) {
        this.odgovor10 = odgovor10;
    }

    public String getPitanje11() {
        return pitanje11;
    }

    public void setPitanje11(String pitanje11) {
        this.pitanje11 = pitanje11;
    }

    public String getOdgovor11() {
        return odgovor11;
    }

    public void setOdgovor11(String odgovor11) {
        this.odgovor11 = odgovor11;
    }

    public String getPitanje12() {
        return pitanje12;
    }

    public void setPitanje12(String pitanje12) {
        this.pitanje12 = pitanje12;
    }

    public String getOdgovor12() {
        return odgovor12;
    }

    public void setOdgovor12(String odgovor12) {
        this.odgovor12 = odgovor12;
    }

    public String getPitanje13() {
        return pitanje13;
    }

    public void setPitanje13(String pitanje13) {
        this.pitanje13 = pitanje13;
    }

    public String getOdgovor13() {
        return odgovor13;
    }

    public void setOdgovor13(String odgovor13) {
        this.odgovor13 = odgovor13;
    }

    public boolean isAnagramDis() {
        return anagramDis;
    }

    public void setAnagramDis(boolean anagramDis) {
        this.anagramDis = anagramDis;
    }

    public boolean isVesanjeDis() {
        return vesanjeDis;
    }

    public void setVesanjeDis(boolean vesanjeDis) {
        this.vesanjeDis = vesanjeDis;
    }

    public boolean isPeharDis() {
        return peharDis;
    }

    public void setPeharDis(boolean peharDis) {
        this.peharDis = peharDis;
    }

    public String getPorukaAnagram() {
        return porukaAnagram;
    }

    public void setPorukaAnagram(String porukaAnagram) {
        this.porukaAnagram = porukaAnagram;
    }

    public String getPorukaVesanje() {
        return porukaVesanje;
    }

    public void setPorukaVesanje(String porukaVesanje) {
        this.porukaVesanje = porukaVesanje;
    }

    public boolean isAnagramBoja() {
        return anagramBoja;
    }

    public void setAnagramBoja(boolean anagramBoja) {
        this.anagramBoja = anagramBoja;
    }

    public boolean isVesanjeBoja() {
        return vesanjeBoja;
    }

    public void setVesanjeBoja(boolean vesanjeBoja) {
        this.vesanjeBoja = vesanjeBoja;
    }

    public boolean isPeharBoja() {
        return peharBoja;
    }

    public void setPeharBoja(boolean peharBoja) {
        this.peharBoja = peharBoja;
    }

    public String getPorukaPehar() {
        return porukaPehar;
    }

    public void setPorukaPehar(String porukaPehar) {
        this.porukaPehar = porukaPehar;
    }

    
    
    
    
    
    
}
