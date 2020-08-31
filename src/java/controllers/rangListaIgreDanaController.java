/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entiteti.*;
import entiteti.Zahtev;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
@Named(value = "rangListaIgreDanaController")
@SessionScoped
public class rangListaIgreDanaController implements Serializable{
    
    
    public static String[] meseci = {"JANUAR", "FEBRUAR", "MART", "APRIL", "MAJ", "JUN", "JUL", "AVGUST", "SEPTEMBAR", "OKTOBAR", "NOVEMBAR", "DECEMBAR"};
    public static int[] daniUmesecu = {31,28,31,30,31,30,31,31,30,31,30,31};
    
    public static Date datum = Date.valueOf(LocalDate.now());
    public static int dan;
    public static int mesec;
    public static int godina;
    public static Date pocetniDatum = Date.valueOf(LocalDate.now());
    public static Date pre20danaDatum = Date.valueOf(LocalDate.now());
    public static String mesecNaziv;
    
    private List<Rezultati> rezultatiPoslMesec = new ArrayList<>();
    private List<Rezultati> rezultatiPosl20Dana = new ArrayList<>();
    private List<Rezultati> rezultatiDanas = new ArrayList<>();
    
    
    static{
        dan = datum.getDate();
        mesec = datum.getMonth();
        godina = datum.getYear();
        pocetniDatum.setDate(1);
        mesecNaziv = meseci[mesec];
        
        if(dan>20){dan-=20;}
        else{
            if(mesec!=0){
                if(mesec!=2){ //da nije trenutni mart jer je feb mozda 29
                    mesec--;
                    int pom = daniUmesecu[mesec] - 20 + dan;
                    dan = pom;
                }
                else{ //ako 20 dana hvata februar provera da li je god prestupna
                    if(godina%4 == 0){
                        mesec--;
                        int pom = daniUmesecu[mesec] - 20 + dan + 1;
                        dan = pom;
                    }
                }
            }
            else{
                mesec = 11;
                int pom = daniUmesecu[mesec] - 20 + dan;
                dan = pom;
                godina--;
            } 
        }
        
        pre20danaDatum.setDate(dan);
        pre20danaDatum.setMonth(mesec);
        pre20danaDatum.setYear(godina);
    
    }

    
    
    
    public rangListaIgreDanaController(){
        dohvatiRezultatePoslednjiMesec();
        dohvatiRezultatePre20Dana();
        dohvatiRezultateDanas();
    }
    
    
    public void osveziListe(){
        dohvatiRezultatePoslednjiMesec();
        dohvatiRezultatePre20Dana();
        dohvatiRezultateDanas();
    }
    
    
    public void dohvatiRezultatePoslednjiMesec(){
        SessionFactory sessionF = util.HibernateUtil.getSessionFactory();
        Session session = sessionF.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(Rezultati.class);
        
        rezultatiPoslMesec = cr.add(Restrictions.ge("datum", pocetniDatum)).list();//datum veci ili jednak od pocetnog
        
        session.getTransaction().commit();
        session.close();
        
        List<Rezultati> pomocnaLista = new ArrayList<>();
        
        if(rezultatiPoslMesec.isEmpty()){return;}
        for(Rezultati r: rezultatiPoslMesec){
            if(!pomocnaLista.isEmpty()){
                boolean ima = false;
                for(Rezultati rpom: pomocnaLista){
                    if(rpom.getUsername().equals(r.getUsername())){
                        int poeni = rpom.getPoeni();
                        poeni+=r.getPoeni();
                        rpom.setPoeni(poeni);
                        ima = true;
                        break;
                    }   
                }
                if(!ima){
                    pomocnaLista.add(r);
                } 
            }
            else{
                pomocnaLista.add(r);
            }
        }
        rezultatiPoslMesec = pomocnaLista;
        rezultatiPoslMesec.sort((p1,p2)->p2.getPoeni().compareTo(p1.getPoeni()));
        
    }
    
    
    
    public void dohvatiRezultatePre20Dana(){
        SessionFactory sessionF = util.HibernateUtil.getSessionFactory();
        Session session = sessionF.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(Rezultati.class);
        
        rezultatiPosl20Dana = cr.add(Restrictions.ge("datum", pre20danaDatum)).list();//datum veci ili jednak od pocetnog
        
        session.getTransaction().commit();
        session.close();
        
        List<Rezultati> pomocnaLista = new ArrayList<>();
        
        if(rezultatiPosl20Dana.isEmpty()){return;}
        for(Rezultati r: rezultatiPosl20Dana){
            if(!pomocnaLista.isEmpty()){
                boolean ima = false;
                for(Rezultati rpom: pomocnaLista){
                    if(rpom.getUsername().equals(r.getUsername())){
                        int poeni = rpom.getPoeni();
                        poeni+=r.getPoeni();
                        rpom.setPoeni(poeni);
                        ima = true;
                        break;
                    }   
                }
                if(!ima){
                    pomocnaLista.add(r);
                } 
            }
            else{
                pomocnaLista.add(r);
            }
        }
        rezultatiPosl20Dana = pomocnaLista;
        rezultatiPosl20Dana.sort((p1,p2)->p2.getPoeni().compareTo(p1.getPoeni()));
        
    }
    
    
    
    public void dohvatiRezultateDanas(){
        SessionFactory sessionF = util.HibernateUtil.getSessionFactory();
        Session session = sessionF.openSession();
        session.beginTransaction();
        
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession s = (HttpSession) fc.getExternalContext().getSession(false);
        
        User ulogovan = (User) s.getAttribute("user");
        
        
        Criteria cr = session.createCriteria(Rezultati.class);
        
        rezultatiDanas = cr.add(Restrictions.eq("datum", datum)).list();//datum veci ili jednak od pocetnog
        
        session.getTransaction().commit();
        session.close();
        
        List<Rezultati> pomocnaLista = new ArrayList<>();
        
        if(rezultatiDanas.isEmpty()){return;}
        
        
        /*
        for(Rezultati r: rezultatiPosl20Dana){
            if(!pomocnaLista.isEmpty()){
                boolean ima = false;
                
                for(Rezultati rpom: pomocnaLista){
                    if(rpom.getUsername().equals(r.getUsername())){
                        int poeni = rpom.getPoeni();
                        poeni+=r.getPoeni();
                        rpom.setPoeni(poeni);
                        ima = true;
                        break;
                    }   
                }
                if(!ima){
                    pomocnaLista.add(r);
                } 
            }
            else{
                pomocnaLista.add(r);
            }
        }
        
        rezultatiPosl20Dana = pomocnaLista;*/

        

        rezultatiDanas.sort((p1,p2)->p2.getPoeni().compareTo(p1.getPoeni()));
        //pomocnaLista = rezultatiDanas;
        if(rezultatiDanas.size()>10){
            
            
            boolean trenutniPrvih10 = false;
            
            for(int i = 0; i<10; i++){
                pomocnaLista.add(rezultatiDanas.get(i));
                if(rezultatiDanas.get(i).getUsername().equals(ulogovan.getUsername())){
                    trenutniPrvih10 = true;
                }
            }

            if(!trenutniPrvih10){
                Rezultati rez = new Rezultati();
                rez.setPoeni(anagramController.brPoenaDanas);
                rez.setUsername(ulogovan.getUsername());
                pomocnaLista.add(rez);
               
            }
        }
        rezultatiDanas = pomocnaLista;
        
    }
    
    
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        rangListeController.datum = datum;
    }

    public int getMesec() {
        return mesec;
    }

    public void setMesec(int mesec) {
        rangListeController.mesec = mesec;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        rangListeController.godina = godina;
    }

    public Date getPocetniDatum() {
        return pocetniDatum;
    }

    public void setPocetniDatum(Date pocetniDatum) {
        rangListeController.pocetniDatum = pocetniDatum;
    }

    public String getMesecNaziv() {
        return mesecNaziv;
    }

    public void setMesecNaziv(String mesecNaziv) {
        rangListeController.mesecNaziv = mesecNaziv;
    }

    public Date getPre20danaDatum() {
        return pre20danaDatum;
    }

    public void setPre20danaDatum(Date pre20danaDatum) {
        rangListeController.pre20danaDatum = pre20danaDatum;
    }

    public List<Rezultati> getRezultatiPoslMesec() {
        return rezultatiPoslMesec;
    }

    public void setRezultatiPoslMesec(List<Rezultati> rezultatiPoslMesec) {
        this.rezultatiPoslMesec = rezultatiPoslMesec;
    }

    public List<Rezultati> getRezultatiPosl20Dana() {
        return rezultatiPosl20Dana;
    }

    public void setRezultatiPosl20Dana(List<Rezultati> rezultatiPosl20Dana) {
        this.rezultatiPosl20Dana = rezultatiPosl20Dana;
    }

    public List<Rezultati> getRezultatiDanas() {
        return rezultatiDanas;
    }

    public void setRezultatiDanas(List<Rezultati> rezultatiDanas) {
        this.rezultatiDanas = rezultatiDanas;
    }
    
    
    
    
    
    
    
    
}
