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

import java.util.List;
import org.hibernate.Criteria;

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
        
            if(validarTipoPer(perfil)== false)
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
        try {
            Transaction tx = session.beginTransaction();
                session.save(serEx);
                tx.commit();
                variable = true;
        } catch (Exception e) {
            variable = false;
            session.beginTransaction().rollback();
        }
                
        session.close();
        return variable;
        
    }
    public List<Hoteles> listaHoteles(){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Criteria crit = session.createCriteria(Hoteles.class);
        Transaction tx = null;
        List<Hoteles> listado = null;
        try {
            tx = session.beginTransaction();
            listado = crit.list(); 
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
        Transaction tx = null;
        List<ServiciosExtras> listado = null;
        try {
            tx = session.beginTransaction();
            listado = crit.list();
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
        session.close();
        return variable;
        
    }
    public boolean eliminarSerExt(Integer id){
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        boolean variable;

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
                
        session.close();
        return variable;
        
    }
    
    //************************************************************************************************************
    //*************************************CRUD Usuarios******************************************************
 
    public boolean validarinsertarUsuario(Usuario usuario){
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Criteria crit = session.createCriteria(Usuario.class);
        
        List<Usuario> resulset = crit.list();
        
        boolean variable = false;
        
        for(Usuario usu : resulset){
            
            if(usuario.getEmail().equals(usu.getEmail()))
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
    
   public boolean insertarUsuario(Usuario usuario){
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        boolean variable;
        try {
                if(validarinsertarUsuario(usuario)== false)
                {

                    Transaction tx = session.beginTransaction();
                    session.save(usuario);
                    tx.commit();
                    variable = true;
                }
                else
                {
                    variable = false;
                }
            } catch (Exception e) {
            variable = false;
            session.beginTransaction().rollback();
        }
        session.close();
        return variable;
        
    }
    
    public List<Perfil> listaPerfiles(){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Criteria crit = session.createCriteria(Perfil.class);
        Transaction tx = null;
        List<Perfil> listado = null;
        try {
            tx = session.beginTransaction();
            listado = crit.list();
            tx.commit();
        } catch (Exception e) {
            session.beginTransaction().rollback();
        }
        
        return listado;
        
    }
    
     public List<Usuario> listaUsuarios(){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Criteria crit = session.createCriteria(Usuario.class);
        Transaction tx = null;
        List<Usuario> listado = null;
        try {
            tx = session.beginTransaction();
            listado = crit.list();
            tx.commit();
        } catch (Exception e) {
            session.beginTransaction().rollback();
        }
        
        return listado;
        
    }
     
     
     public boolean modificarUsuarios(Usuario usu){
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        boolean variable;
        
        try {
                Transaction tx = session.beginTransaction();
                Usuario usudb = (Usuario) session.load(Usuario.class, usu.getIdUsuario() );
                usudb.setRutUsuario(usu.getRutUsuario());
                usudb.setApellidoPaterno(usu.getApellidoPaterno());
                usudb.setApellidoMaterno(usu.getApellidoMaterno());
                usudb.setSexo(usu.getSexo());
                usudb.setNacionalidad(usu.getNacionalidad());
                usudb.setResidenciaActual(usu.getResidenciaActual());
                usudb.setFechaNacimiento(usu.getFechaNacimiento());
                usudb.setRegionNacimiento(usu.getRegionNacimiento());
                usudb.setTelefono(usu.getTelefono());
                usudb.setEmail(usu.getEmail());
                usudb.setContraUsuario(usu.getContraUsuario());
                usudb.setPerfil(usu.getPerfil());
                
                session.update(usudb);
                tx.commit();
                variable = true;
        } catch (Exception e) {
            variable = false;
            session.beginTransaction().rollback();
        }
        session.close();
        return variable;
        
    }
    
    
    public boolean eliminarUsuario(Integer id){
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        boolean variable;

        try {
                Transaction tx = session.beginTransaction();
                Usuario us = (Usuario) session.load(Usuario.class, id);
                session.delete(us);
                tx.commit();
                variable = true;
        } catch (Exception e) {
            variable = false;
            session.beginTransaction().rollback();
        }
                
        session.close();
        return variable;
        
    }
    
    
}
