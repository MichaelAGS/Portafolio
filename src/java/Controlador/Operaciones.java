/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloHibernate.Perfil;
import ModeloHibernate.Usuario;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Michael
 */
public class Operaciones {
    
    public boolean validarUsuario(String usuario, String contra){
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Criteria crit = session.createCriteria(Usuario.class);
        
        List<Usuario> resulset = crit.list();
        
        boolean variable = false;
        
        for(Usuario usu : resulset){
            
            if(usuario.equals(usu.getEmail()) && contra.equals(usu.getContraUsuario()))
            {
                variable = true;
                break;
            }
            else
            {
                variable = false;
            }
            
        }
        
        session.close();
        
        return variable;
        
    }
    public boolean validarTipoPer(Perfil per){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Criteria crit = session.createCriteria(Perfil.class);
        
        List<Perfil> resulset = crit.list();
        
        boolean variable = false;
        
        for(Perfil perfil : resulset){
            
            if(per.getTipoPerfil().equals(perfil.getTipoPerfil()))
            {
                variable = true;
                break;
            }
            else
            {
                variable = false;
            }
            
        }
            session.close();
        
            return variable;
    }
    
    public boolean insertarPerfil(Perfil perfil){
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        
        
        
        
        boolean variable = false;
        
        
            
            if(validarTipoPer(perfil)== false)//admin con super user
            {
                Transaction tx = session.beginTransaction();
                session.save(perfil);
                tx.commit();
                variable = true;
                
                
            }
            else
            {
                variable = false;
            }
            
        
        session.close();
        return variable;
        
    }
    
    /*public boolean insertProc(int id, String tipo_per){
        
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction t = session.beginTransaction();
        
        Query q = session.createSQLQuery("CALL ACTUALIZA_SALDO(:N_ID_PERFIL,:N_TIPO_PERFIL)").setParameter("N_ID_PERFIL", id).setParameter("N_TIPO_PERFIL", tipo_per);
        q.executeUpdate();
        t.commit();
        return true;
    }*/
    
    
    /*public boolean insertarPerfil(){
        
        
        Session session;
        Query query = session.createSQLQuery(
	"CALL ACTUALIZA_SALDO(:id_perfil,tipo_perfil)")
	.addEntity(Perfil.class)
	.setParameter("1", "megauser");
			
        List result = query.list();
        for(int i=0; i<result.size(); i++){
	Perfil perfil = (Perfil)result.get(i);
	System.out.println(perfil.);
    }*/
}
