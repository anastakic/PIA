/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entiteti.Rezultati;
import entiteti.User;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
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
import util.SessionUtils;

/**
 *
 * @author Ana
 */

@ManagedBean 
@Named(value = "loginController")
@SessionScoped
public class loginController implements Serializable{

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){
        String passwordHash = HashFunction.getHashString(password);
        
        SessionFactory sessionFactory = util.HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(User.class);
        
        User u =(User)cr.add(Restrictions.eq("username",  username)).add(Restrictions.eq("passwordHash", passwordHash)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        
        username = "";
        password = "";
        
        if(u != null) {
            //uspeo je login
            HttpSession sesija=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            sesija.setAttribute("user", u);
            
            
            switch(u.getTip()){
                case "takmicar":{return Navigation.TAKMICAR + Navigation.FACES_REDIRECT;}
                case "admin": return Navigation.ADMIN + Navigation.FACES_REDIRECT;
                case "supervizor": return Navigation.SUPERVIZOR + Navigation.FACES_REDIRECT;
                default: return Navigation.ERROR + Navigation.FACES_REDIRECT;
            }
            
        }
        
        else{
            FacesUtil.reportError("Neodgovarajući username ili password.");
            return null;
        
        
        }
        
    }
    
    
    public String logout() {
        SessionUtils.invalidateSession();
        return Navigation.INDEX + Navigation.FACES_REDIRECT;
    }
    
}
