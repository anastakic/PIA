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
@Named(value = "promenaLozinkeController")
@SessionScoped
public class promenaLozinkeController implements Serializable{
    
    private String username;
    private String password;
    private String newPassword;
    private String newPasswordPotvrda;

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
    
    

    
    public String promeniLozinku(){
        if(password.equals(newPassword)){
            FacesUtil.reportError("Nova i stara lozinka su iste. Unesite drugačiju novu lozinku.");
            return null;
        
        }
        
        if (!PasswordValidator.valid(newPassword)) {
            FacesUtil.reportError("Lozinka treba da ima između 8 i 12 karaktera, od čega minimum: 3 mala slova, 1 veliko slovo, 1 cifru, 1 specijalan karakter, mora početi slovom, i jedno za drugim mogu biti najviše dva ista karaktera.");
            return null;
        }
        
        String passwordHash = HashFunction.getHashString(password);
        String newPasswordHash = HashFunction.getHashString(newPassword);
        
        SessionFactory sessionFactory = util.HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(User.class);
        
        User u =(User)cr.add(Restrictions.eq("username",  username)).add(Restrictions.eq("passwordHash", passwordHash)).uniqueResult();
        
        username = "";
        password = "";
        newPassword = "";
        
        if(u == null){
            newPasswordHash = "";
            session.getTransaction().commit();
            session.close();
            FacesUtil.reportError("Ne postoji korisnik sa tim username-om ili password-om.");
            return null;
        }
        
        u.setPasswordHash(newPasswordHash);
        newPasswordHash = "";
        session.update(u);
        session.getTransaction().commit();
        session.close();
        
        return Navigation.INDEX + Navigation.FACES_REDIRECT;
    }        
    
}
