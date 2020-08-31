/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entiteti.*;
import java.awt.Window;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
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
import util.PasswordValidator;
import util.SessionUtils;


/**
 *
 * @author Ana
 */
@ManagedBean 
@Named(value = "peharController")
@SessionScoped
public class peharController implements Serializable{
    
    private Integer brPoena = 0;
    public static Integer brPoenaPoslePehar;
    
    private Pehar trPehar;
    
    private boolean dis1 = true;
    private boolean dis2 = true;
    private boolean dis3 = true;
    private boolean dis4 = true;
    private boolean dis5 = true;
    private boolean dis6 = true;
    private boolean dis7 = true;
    private boolean dis8 = true;
    private boolean dis9 = true;
    private boolean dis10 = true;
    private boolean dis11 = true;
    private boolean dis12 = true;
    private boolean dis13 = true;
    
    private boolean tacno1 = true;
    private boolean tacno2 = true;
    private boolean tacno3 = true;
    private boolean tacno4 = true;
    private boolean tacno5 = true;
    private boolean tacno6 = true;
    private boolean tacno7 = true;
    private boolean tacno8 = true;
    private boolean tacno9 = true;
    private boolean tacno10 = true;
    private boolean tacno11 = true;
    private boolean tacno12 = true;
    private boolean tacno13 = true;
   
    private String id1;
    private String id2;
    private String id3;
    private String id4;
    private String id5;
    private String id6;
    private String id7;
    private String id8;
    private String id9;
    private String id10;
    private String id11;
    private String id12;
    private String id13;
    
    
    private boolean timerReset=false;
    private int timerValue = 30;
    
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
    
    private boolean krajIgreDis = true;
    
    
    public peharController(){
        
        Integer id = PeharIzIgreDana();
        
        SessionFactory sessionFactory = util.HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();

        Criteria cr = session.createCriteria(Pehar.class);

        Pehar pehar = (Pehar)cr.add(Restrictions.eq("id", id)).uniqueResult();

        session.getTransaction().commit();
        session.close();
    
        if(pehar!=null){
            trPehar = pehar;
        }
        id1 = "1.";
        pitanje1 = trPehar.getPitanje1();
        dis1 = false;
   
    }




    public Integer PeharIzIgreDana(){
        Date datum = Date.valueOf(LocalDate.now());
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        
        Criteria cr = session.createCriteria(IgraDana.class);
        IgraDana i = (IgraDana)cr.add(Restrictions.eq("datum", datum)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
            
        if(i==null){
            return 12;
        }  
        else{
            return i.getPehar_id();}
    }
    
    
    public void datOdgovor1(){
        if(!dis1){  
            if(odgovor1.toLowerCase().equals(trPehar.getOdgovor1())){
                brPoena+=2;
                brPoenaPoslePehar+=2;
                tacno1 = true;

            }
            else{
                //indikator da je netacno
                odgovor1 = trPehar.getOdgovor1();
                tacno1 = false;
            }
            pitanje2 = trPehar.getPitanje2();
            id2 = "2.";
            dis1 = true;
            dis2 = false;
            timerReset = true;
        }
    }
    
    
    
    public void datOdgovor2(){
        if(!dis2){
        if(odgovor2.toLowerCase().equals(trPehar.getOdgovor2())){
            brPoena+=2;
            brPoenaPoslePehar+=2;
            tacno2 = true;
            
        }
        else{
            //indikator da je netacno
            odgovor2 = trPehar.getOdgovor2();
            tacno2 = false;
        }
        pitanje3 = trPehar.getPitanje3();
        id3 = "3.";
        dis2 = true;
        dis3 = false;
        timerReset = true;
        }
    }

    
    
    public void datOdgovor3(){
        if(odgovor3.toLowerCase().equals(trPehar.getOdgovor3())){
            brPoena+=2;
            brPoenaPoslePehar+=2;
            tacno3 = true;
            
        }
        else{
            //indikator da je netacno
            odgovor3 = trPehar.getOdgovor3();
            tacno3 = false;
        }
        pitanje4 = trPehar.getPitanje4();
        id4 = "4.";
        dis3 = true;
        dis4 = false;
        timerReset = true;
    }

    
    
    public void datOdgovor4(){
        if(odgovor4.toLowerCase().equals(trPehar.getOdgovor4())){
            brPoena+=2;
            brPoenaPoslePehar+=2;
            tacno4 = true;
            
        }
        else{
            //indikator da je netacno
            odgovor4 = trPehar.getOdgovor4();
            tacno4 = false;
        }
        pitanje5 = trPehar.getPitanje5();
        id5 = "5.";
        dis4 = true;
        dis5 = false;
        timerReset = true;
    }

    
    
    public void datOdgovor5(){
        if(odgovor5.toLowerCase().equals(trPehar.getOdgovor5())){
            brPoena+=2;
            brPoenaPoslePehar+=2;
            tacno5 = true;
            
        }
        else{
            //indikator da je netacno
            odgovor5 = trPehar.getOdgovor5();
            tacno5 = false;
        }
        pitanje6 = trPehar.getPitanje6();
        id6 = "6.";
        dis5 = true;
        dis6 = false;
        timerReset = true;
    }

    
    
    public void datOdgovor6(){
        if(odgovor6.toLowerCase().equals(trPehar.getOdgovor6())){
            brPoena+=2;
            brPoenaPoslePehar+=2;
            tacno6 = true;
            
        }
        else{
            //indikator da je netacno
            odgovor6 = trPehar.getOdgovor6();
            tacno6 = false;
        }
        pitanje7 = trPehar.getPitanje7();
        id7 = "7.";
        dis6 = true;
        dis7 = false;
        timerReset = true;
    }

    
    
    public void datOdgovor7(){
        if(odgovor7.toLowerCase().equals(trPehar.getOdgovor7())){
            brPoena+=2;
            brPoenaPoslePehar+=2;
            tacno7 = true;
            
        }
        else{
            //indikator da je netacno
            odgovor7 = trPehar.getOdgovor7();
            tacno7 = false;
        }
        pitanje8 = trPehar.getPitanje8();
        id8 = "8.";
        dis7 = true;
        dis8 = false;
        timerReset = true;
    }
    
    
    
    public void datOdgovor8(){
        if(odgovor8.toLowerCase().equals(trPehar.getOdgovor8())){
            brPoena+=2;
            brPoenaPoslePehar+=2;
            tacno8 = true;
            
        }
        else{
            //indikator da je netacno
            odgovor8 = trPehar.getOdgovor8();
            tacno8 = false;
        }
        pitanje9 = trPehar.getPitanje9();
        id9 = "9.";
        dis8 = true;
        dis9 = false;
        timerReset = true;
    }


    
    
    public void datOdgovor9(){
        if(odgovor9.toLowerCase().equals(trPehar.getOdgovor9())){
            brPoena+=2;
            brPoenaPoslePehar+=2;
            tacno9 = true;
            
        }
        else{
            //indikator da je netacno
            odgovor9 = trPehar.getOdgovor9();
            tacno9 = false;
        }
        pitanje10 = trPehar.getPitanje10();
        id10 = "10.";
        dis9 = true;
        dis10 = false;
        timerReset = true;
    }

    
    
    public void datOdgovor10(){
        if(odgovor10.toLowerCase().equals(trPehar.getOdgovor10())){
            brPoena+=2;
            brPoenaPoslePehar+=2;
            tacno10 = true;
            
        }
        else{
            //indikator da je netacno
            odgovor10 = trPehar.getOdgovor10();
            tacno10 = false;
        }
        pitanje11 = trPehar.getPitanje11();
        id11 = "11.";
        dis10 = true;
        dis11 = false;
        timerReset = true;
    }

    
    
    public void datOdgovor11(){
        if(odgovor11.toLowerCase().equals(trPehar.getOdgovor11())){
            brPoena+=2;
            brPoenaPoslePehar+=2;
            tacno11 = true;
            
        }
        else{
            //indikator da je netacno
            odgovor11 = trPehar.getOdgovor11();
            tacno11 = false;
        }
        pitanje12 = trPehar.getPitanje12();
        id12 = "12.";
        dis11 = true;
        dis12 = false;
        timerReset = true;
    }

    
    
    public void datOdgovor12(){
        if(odgovor12.toLowerCase().equals(trPehar.getOdgovor12())){
            brPoena+=2;
            brPoenaPoslePehar+=2;
            tacno12 = true;
            
        }
        else{
            //indikator da je netacno
            odgovor12 = trPehar.getOdgovor12();
            tacno12 = false;
        }
        pitanje13 = trPehar.getPitanje13();
        id13 = "13.";
        dis12 = true;
        dis13 = false;
        timerReset = true;
    }

    
    
    public void datOdgovor13(){
        if(odgovor13.toLowerCase().equals(trPehar.getOdgovor13())){
            brPoena+=2;
            brPoenaPoslePehar+=2;
            tacno13 = true;
            
        }
        else{
            //indikator da je netacno
            odgovor13 = trPehar.getOdgovor13();
            tacno13 = false;
        }
        
        dis13 = true;
        timerReset = true;
        
        krajIgreDis = false;
        
    }

    
    public String krajIgre(){
        
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
            r.setPoeni(brPoenaPoslePehar);

            session.update(r);


            session.getTransaction().commit();
            session.close();

            
            anagramController.brPoenaIgrano = ""+brPoenaPoslePehar;
            return Navigation.TAKMICAR + Navigation.FACES_REDIRECT;
    }
    
    public void timer(){
        if(--timerValue<0 || timerReset){
            timerValue = 30;
            timerReset = false;
        }
        
    }

    public boolean isKrajIgreDis() {
        return krajIgreDis;
    }

    public void setKrajIgreDis(boolean krajIgreDis) {
        this.krajIgreDis = krajIgreDis;
    }
    
    
    
    
    
    
    
    
    
    public boolean isTimerReset() {
        return timerReset;
    }

    public void setTimerReset(boolean timerReset) {
        this.timerReset = timerReset;
    }
        
    public Integer getBrPoena() {
        return brPoena;
    }

    public void setBrPoena(Integer brPoena) {
        this.brPoena = brPoena;
    }

    public Pehar getTrPehar() {
        return trPehar;
    }

    public void setTrPehar(Pehar trPehar) {
        this.trPehar = trPehar;
    }

    public boolean isDis1() {
        return dis1;
    }

    public void setDis1(boolean dis1) {
        this.dis1 = dis1;
    }

    public boolean isDis2() {
        return dis2;
    }

    public void setDis2(boolean dis2) {
        this.dis2 = dis2;
    }

    public boolean isDis3() {
        return dis3;
    }

    public void setDis3(boolean dis3) {
        this.dis3 = dis3;
    }

    public boolean isDis4() {
        return dis4;
    }

    public void setDis4(boolean dis4) {
        this.dis4 = dis4;
    }

    public boolean isDis5() {
        return dis5;
    }

    public void setDis5(boolean dis5) {
        this.dis5 = dis5;
    }

    public boolean isDis6() {
        return dis6;
    }

    public void setDis6(boolean dis6) {
        this.dis6 = dis6;
    }

    public boolean isDis7() {
        return dis7;
    }

    public void setDis7(boolean dis7) {
        this.dis7 = dis7;
    }

    public boolean isDis8() {
        return dis8;
    }

    public void setDis8(boolean dis8) {
        this.dis8 = dis8;
    }

    public boolean isDis9() {
        return dis9;
    }

    public void setDis9(boolean dis9) {
        this.dis9 = dis9;
    }

    public boolean isDis10() {
        return dis10;
    }

    public void setDis10(boolean dis10) {
        this.dis10 = dis10;
    }

    public boolean isDis11() {
        return dis11;
    }

    public void setDis11(boolean dis11) {
        this.dis11 = dis11;
    }

    public boolean isDis12() {
        return dis12;
    }

    public void setDis12(boolean dis12) {
        this.dis12 = dis12;
    }

    public boolean isDis13() {
        return dis13;
    }

    public void setDis13(boolean dis13) {
        this.dis13 = dis13;
    }

    public String getOdgovor1() {
        return odgovor1;
    }

    public void setOdgovor1(String odgovor1) {
        this.odgovor1 = odgovor1;
    }

    public String getOdgovor2() {
        return odgovor2;
    }

    public void setOdgovor2(String odgovor2) {
        this.odgovor2 = odgovor2;
    }

    public String getOdgovor3() {
        return odgovor3;
    }

    public void setOdgovor3(String odgovor3) {
        this.odgovor3 = odgovor3;
    }

    public String getOdgovor4() {
        return odgovor4;
    }

    public void setOdgovor4(String odgovor4) {
        this.odgovor4 = odgovor4;
    }

    public String getOdgovor5() {
        return odgovor5;
    }

    public void setOdgovor5(String odgovor5) {
        this.odgovor5 = odgovor5;
    }

    public String getOdgovor6() {
        return odgovor6;
    }

    public void setOdgovor6(String odgovor6) {
        this.odgovor6 = odgovor6;
    }

    public String getOdgovor7() {
        return odgovor7;
    }

    public void setOdgovor7(String odgovor7) {
        this.odgovor7 = odgovor7;
    }

    public String getOdgovor8() {
        return odgovor8;
    }

    public void setOdgovor8(String odgovor8) {
        this.odgovor8 = odgovor8;
    }

    public String getOdgovor9() {
        return odgovor9;
    }

    public void setOdgovor9(String odgovor9) {
        this.odgovor9 = odgovor9;
    }

    public String getOdgovor10() {
        return odgovor10;
    }

    public void setOdgovor10(String odgovor10) {
        this.odgovor10 = odgovor10;
    }

    public String getOdgovor11() {
        return odgovor11;
    }

    public void setOdgovor11(String odgovor11) {
        this.odgovor11 = odgovor11;
    }

    public String getOdgovor12() {
        return odgovor12;
    }

    public void setOdgovor12(String odgovor12) {
        this.odgovor12 = odgovor12;
    }

    public String getOdgovor13() {
        return odgovor13;
    }

    public void setOdgovor13(String odgovor13) {
        this.odgovor13 = odgovor13;
    }

    public String getPitanje1() {
        return pitanje1;
    }

    public void setPitanje1(String pitanje1) {
        this.pitanje1 = pitanje1;
    }

    public String getPitanje2() {
        return pitanje2;
    }

    public void setPitanje2(String pitanje2) {
        this.pitanje2 = pitanje2;
    }

    public String getPitanje3() {
        return pitanje3;
    }

    public void setPitanje3(String pitanje3) {
        this.pitanje3 = pitanje3;
    }

    public String getPitanje4() {
        return pitanje4;
    }

    public void setPitanje4(String pitanje4) {
        this.pitanje4 = pitanje4;
    }

    public String getPitanje5() {
        return pitanje5;
    }

    public void setPitanje5(String pitanje5) {
        this.pitanje5 = pitanje5;
    }

    public String getPitanje6() {
        return pitanje6;
    }

    public void setPitanje6(String pitanje6) {
        this.pitanje6 = pitanje6;
    }

    public String getPitanje7() {
        return pitanje7;
    }

    public void setPitanje7(String pitanje7) {
        this.pitanje7 = pitanje7;
    }

    public String getPitanje8() {
        return pitanje8;
    }

    public void setPitanje8(String pitanje8) {
        this.pitanje8 = pitanje8;
    }

    public String getPitanje9() {
        return pitanje9;
    }

    public void setPitanje9(String pitanje9) {
        this.pitanje9 = pitanje9;
    }

    public String getPitanje10() {
        return pitanje10;
    }

    public void setPitanje10(String pitanje10) {
        this.pitanje10 = pitanje10;
    }

    public String getPitanje11() {
        return pitanje11;
    }

    public void setPitanje11(String pitanje11) {
        this.pitanje11 = pitanje11;
    }

    public String getPitanje12() {
        return pitanje12;
    }

    public void setPitanje12(String pitanje12) {
        this.pitanje12 = pitanje12;
    }

    public String getPitanje13() {
        return pitanje13;
    }

    public void setPitanje13(String pitanje13) {
        this.pitanje13 = pitanje13;
    }

    public boolean isTacno1() {
        return tacno1;
    }

    public void setTacno1(boolean tacno1) {
        this.tacno1 = tacno1;
    }

    public boolean isTacno2() {
        return tacno2;
    }

    public void setTacno2(boolean tacno2) {
        this.tacno2 = tacno2;
    }

    public boolean isTacno3() {
        return tacno3;
    }

    public void setTacno3(boolean tacno3) {
        this.tacno3 = tacno3;
    }

    public boolean isTacno4() {
        return tacno4;
    }

    public void setTacno4(boolean tacno4) {
        this.tacno4 = tacno4;
    }

    public boolean isTacno5() {
        return tacno5;
    }

    public void setTacno5(boolean tacno5) {
        this.tacno5 = tacno5;
    }

    public boolean isTacno6() {
        return tacno6;
    }

    public void setTacno6(boolean tacno6) {
        this.tacno6 = tacno6;
    }

    public boolean isTacno7() {
        return tacno7;
    }

    public void setTacno7(boolean tacno7) {
        this.tacno7 = tacno7;
    }

    public boolean isTacno8() {
        return tacno8;
    }

    public void setTacno8(boolean tacno8) {
        this.tacno8 = tacno8;
    }

    public boolean isTacno9() {
        return tacno9;
    }

    public void setTacno9(boolean tacno9) {
        this.tacno9 = tacno9;
    }

    public boolean isTacno10() {
        return tacno10;
    }

    public void setTacno10(boolean tacno10) {
        this.tacno10 = tacno10;
    }

    public boolean isTacno11() {
        return tacno11;
    }

    public void setTacno11(boolean tacno11) {
        this.tacno11 = tacno11;
    }

    public boolean isTacno12() {
        return tacno12;
    }

    public void setTacno12(boolean tacno12) {
        this.tacno12 = tacno12;
    }

    public boolean isTacno13() {
        return tacno13;
    }

    public void setTacno13(boolean tacno13) {
        this.tacno13 = tacno13;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getId3() {
        return id3;
    }

    public void setId3(String id3) {
        this.id3 = id3;
    }

    public String getId4() {
        return id4;
    }

    public void setId4(String id4) {
        this.id4 = id4;
    }

    public String getId5() {
        return id5;
    }

    public void setId5(String id5) {
        this.id5 = id5;
    }

    public String getId6() {
        return id6;
    }

    public void setId6(String id6) {
        this.id6 = id6;
    }

    public String getId7() {
        return id7;
    }

    public void setId7(String id7) {
        this.id7 = id7;
    }

    public String getId8() {
        return id8;
    }

    public void setId8(String id8) {
        this.id8 = id8;
    }

    public String getId9() {
        return id9;
    }

    public void setId9(String id9) {
        this.id9 = id9;
    }

    public String getId10() {
        return id10;
    }

    public void setId10(String id10) {
        this.id10 = id10;
    }

    public String getId11() {
        return id11;
    }

    public void setId11(String id11) {
        this.id11 = id11;
    }

    public String getId12() {
        return id12;
    }

    public void setId12(String id12) {
        this.id12 = id12;
    }

    public String getId13() {
        return id13;
    }

    public void setId13(String id13) {
        this.id13 = id13;
    }

    public int getTimerValue() {
        return timerValue;
    }

    public void setTimerValue(int timerValue) {
        this.timerValue = timerValue;
    }

    public Integer getBrPoenaPoslePehar() {
        return brPoenaPoslePehar;
    }

    public void setBrPoenaPoslePehar(Integer brPoenaPoslePehar) {
        peharController.brPoenaPoslePehar = brPoenaPoslePehar;
    }
    
    
    
    
    
}
