/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entity;

/**
 *
 * @author acer
 */
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Client  extends User{
    @GeneratedValue
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date datenaissance;

    public Client() {
    }
    
      public Client(String nom, String prenom, Date dateNaissance , String email, String password,int etat,String code) {
        super(email, password,etat,code);
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = dateNaissance;
        this.etat =etat;
        this.code=code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

}

