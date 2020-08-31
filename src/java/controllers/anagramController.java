/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entiteti.*;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import entiteti.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.PrimeFaces;
import util.HibernateUtil;

/**
 *
 * @author Ana
 */
@ManagedBean 
@Named(value = "anagramController")
@SessionScoped
public class anagramController implements Serializable{
    
    private Integer brPoena = 0;
   
    public static String brPoenaIgrano;
    public static Integer brPoenaDanas; 
    
    private Integer brPoenaPosleAnagrama = 0;
    
    private String zagonetka;
    private String resenje;
    
    private String tacnoResenje;

    
    
    
    
    public Integer getBrPoena() {
        return brPoena;
    }

    public void setBrPoena(Integer brPoena) {
        this.brPoena = brPoena;
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

    public anagramController(){
        
        //treba da bude 
        nijeigrao = DaLiJeIgrao();
        Integer id = AnagramIzIgreDana();
        
        SessionFactory sessionFactory = util.HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(Anagram.class);
        
        
        Anagram a = (Anagram)cr.add(Restrictions.eq("id", id)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        
        zagonetka = "greska";
        
        if(a!=null){
            zagonetka = a.getZagonetka();
            tacnoResenje = a.getResenje();
        }
        
    }
    
    
    private List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
    
    public void dohvatiUsers(){
        SessionFactory sessionF = util.HibernateUtil.getSessionFactory();
        Session session = sessionF.openSession();
        session.beginTransaction();
        
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession s = (HttpSession) fc.getExternalContext().getSession(false);
        
        User ulogovan = (User) s.getAttribute("user");
        
        Criteria query = session.createCriteria(User.class);
        
        users = query.add(Restrictions.eq("tip", ulogovan.getTip())).list();
        session.getTransaction().commit();
        session.close();
   }

    public String getTacnoResenje() {
        return tacnoResenje;
    }

    public void setTacnoResenje(String tacnoResenje) {
        this.tacnoResenje = tacnoResenje;
    }
    
    
    
    private boolean nijeigrao = true;

    public boolean isNijeigrao() {
        return nijeigrao;
    }

    public void setNijeigrao(boolean nijeigrao) {
        this.nijeigrao = nijeigrao;
    }
    
    
    
    
    
    public String igra(){
        
        Date datum = Date.valueOf(LocalDate.now());
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession s = (HttpSession) fc.getExternalContext().getSession(false);
        
        User ulogovan = (User) s.getAttribute("user");
        
        Rezultati r = new Rezultati();
        r.setDatum(datum);
        r.setUsername(ulogovan.getUsername());
        r.setPoeni(0);
        
        session.save(r);
        
        
        session.getTransaction().commit();
        session.close();
        
        nijeigrao = false;
        
        return "anagram.xhtml";
       
        
        
        
        //provera u bazi da li je igrao

    }
    
    
    
    
    
    
    public Integer AnagramIzIgreDana(){
        Date datum = Date.valueOf(LocalDate.now());
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        
        Criteria cr = session.createCriteria(IgraDana.class);
        IgraDana i = (IgraDana)cr.add(Restrictions.eq("datum", datum)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
            
        if(i==null){
            return 11;
        }  
        else{
            return i.getAnagram_id();}
    }

    
    
    
    
    
    
    
    
    public boolean DaLiJeIgrao(){
        Date datum = Date.valueOf(LocalDate.now());
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession s = (HttpSession) fc.getExternalContext().getSession(false);
        
        User ulogovan = (User) s.getAttribute("user");
        
        
        Criteria cr = session.createCriteria(Rezultati.class);
        Rezultati r = (Rezultati)cr.add(Restrictions.eq("datum", datum)).add(Restrictions.eq("username", ulogovan.getUsername())).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
            
        if(r!=null){
            anagramController.brPoenaDanas = r.getPoeni();
            anagramController.brPoenaIgrano = ""+r.getPoeni();
            return false;
        }  
        else{
            anagramController.brPoenaIgrano = "/";
            return true;}
    }
    
    
    
    
    public String potvrdi(){
        String a = resenje.toLowerCase();
        String b = tacnoResenje.toLowerCase();
        if(a.equals(b)){
            brPoena = 10;
        }
        
        Date datum = Date.valueOf(LocalDate.now());
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession s = (HttpSession) fc.getExternalContext().getSession(false);
        
        User ulogovan = (User) s.getAttribute("user");
        
        Criteria cr = session.createCriteria(Rezultati.class);
        Rezultati r = (Rezultati)cr.add(Restrictions.eq("datum", datum)).add(Restrictions.eq("username", ulogovan.getUsername())).uniqueResult();
        
        int pom = r.getPoeni();
        pom+=brPoena;
        
        brPoenaPosleAnagrama = pom;
        
        r.setPoeni(pom);
        
        session.update(r);
        
        
        session.getTransaction().commit();
        session.close();
        
        
        
        //azuriraj brPoena u bazu
        
        return Navigation.MOJBROJ + Navigation.FACES_REDIRECT;
    }

    
    public static Integer dohvatiPoene(Date datum, String username){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(Rezultati.class);
        Rezultati r = (Rezultati)cr.add(Restrictions.eq("datum", datum)).add(Restrictions.eq("username", username)).uniqueResult();
        
        int pom = r.getPoeni();
        
        session.getTransaction().commit();
        session.close();
        
        return pom;
    }
    
    
    
    
    public Integer getBrPoenaPosleAnagrama() {
        return brPoenaPosleAnagrama;
    }

    public void setBrPoenaPosleAnagrama(Integer brPoenaPosleAnagrama) {
        this.brPoenaPosleAnagrama = brPoenaPosleAnagrama;
    }

    public String getBrPoenaIgrano() {
        return brPoenaIgrano;
    }

    public void setBrPoenaIgrano(String brPoenaIgrano) {
        anagramController.brPoenaIgrano = brPoenaIgrano;
    }

    public Integer getBrPoenaDanas() {
        return brPoenaDanas;
    }

    public void setBrPoenaDanas(Integer brPoenaDanas) {
        anagramController.brPoenaDanas = brPoenaDanas;
    }
 
    
    
    
    
    
}
