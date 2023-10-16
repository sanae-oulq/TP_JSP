/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.Test;

/**
 *
 * @author acer
 */
import ma.projet.entity.Employer;
import ma.projet.service.ServiceEmployer;
import ma.projet.util.HibernateUtil;


public class Test {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
        
    }
    
}

