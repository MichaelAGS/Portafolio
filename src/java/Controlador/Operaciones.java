/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloHibernate.Hoteles;
import ModeloHibernate.Perfil;
import ModeloHibernate.ServiciosExtras;
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
    //************************************************************************************************************
    //******************************************************CRUD PERFIL******************************************************
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
    //************************************************************************************************************
    //*************************************CRUD SERVICIOS EXTRAS******************************************************
    
    
    public boolean insertarSerExt(ServiciosExtras serEx){
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        boolean variable;
        
            /*if(validarServExt(serEx)== false)//admin con super user
            {*/
        try {
            Transaction tx = session.beginTransaction();
                session.save(serEx);
                tx.commit();
                variable = true;
        } catch (Exception e) {
            variable = false;
            session.beginTransaction().rollback();
        }
                
            /*}
            else
            {
                variable = false;
            }*/
        session.close();
        return variable;
        
    }
    public List<Hoteles> listaHoteles(){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Criteria crit = session.createCriteria(Hoteles.class);
        Transaction tx = null;// es importante hacer esta WEA NO SE POR QUE PERO LO HICE Y FUNCIONO, ERROR NO SOPORTA NO SE QUE CHUCHA
        List<Hoteles> listado = null;
        try {
            tx = session.beginTransaction();
            listado = crit.list();// SUPUESTAMENTE LE ASIGNO TODO LO QUE VIENE DE LA TABLA HOTLES EN UNA VARIABLE DE TIPO LISTA<HOTELES>
            tx.commit();
        } catch (Exception e) {
            session.beginTransaction().rollback();
        }
        
        return listado;
        
    }
    
    
    public List<ServiciosExtras> listaServicios(){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Criteria crit = session.createCriteria(ServiciosExtras.class);
        Transaction tx = null;// es importante hacer esta WEA NO SE POR QUE PERO LO HICE Y FUNCIONO, ERROR NO SOPORTA NO SE QUE CHUCHA
        List<ServiciosExtras> listado = null;
        try {
            tx = session.beginTransaction();
            listado = crit.list();// SUPUESTAMENTE LE ASIGNO TODO LO QUE VIENE DE LA TABLA HOTLES EN UNA VARIABLE DE TIPO LISTA<HOTELES>
            tx.commit();
        } catch (Exception e) {
            session.beginTransaction().rollback();
        }
        
        return listado;
        
    }
    
    public boolean modificarSerExt(ServiciosExtras serEx){
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        boolean variable;
        
            /*if(validarServExt(serEx)== false)//admin con super user
            {*/
        try {
                Transaction tx = session.beginTransaction();
                ServiciosExtras serExdb = (ServiciosExtras) session.load(ServiciosExtras.class, serEx.getIdServExt());
                serExdb.setHoteles(serEx.getHoteles());
                serExdb.setNombreServExt(serEx.getNombreServExt());
                serExdb.setValorDiario(serEx.getValorDiario());
                session.update(serExdb);
                tx.commit();
                variable = true;
        } catch (Exception e) {
            variable = false;
            session.beginTransaction().rollback();
        }
                
            /*}
            else
            {
                variable = false;
            }*/
        session.close();
        return variable;
        
    }
    public boolean eliminarSerExt(Integer id){
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        boolean variable;
        
            /*if(validarServExt(serEx)== false)//admin con super user
            {*/
        try {
                Transaction tx = session.beginTransaction();
                ServiciosExtras serEx = (ServiciosExtras) session.load(ServiciosExtras.class, id);
                session.delete(serEx);
                tx.commit();
                variable = true;
        } catch (Exception e) {
            variable = false;
            session.beginTransaction().rollback();
        }
                
            /*}
            else
            {
                variable = false;
            }*/
        session.close();
        return variable;
        
    }
    
    /*public boolean validarServExt(ServiciosExtras serEx){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Criteria crit = session.createCriteria(ServiciosExtras.class);
        
        List<ServiciosExtras> resulset = crit.list();
        
        boolean variable = false;
        
        for(ServiciosExtras serExt : resulset){
            
            if(serExt.getNombreServExt().equals(serEx.getNombreServExt()))
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
    }*/
    
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
