package ModeloHibernate;
// Generated 20-10-2015 20:40:28 by Hibernate Tools 4.3.1



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ReservaServExt generated by hbm2java
 */
public class ReservaServExt  implements java.io.Serializable {


     private int idResServ;
     private ReservaHabitacion reservaHabitacion;
     private Date fechaResServ;
     private Set serviciosExtrases = new HashSet(0);

    public ReservaServExt() {
    }

	
    public ReservaServExt(int idResServ, ReservaHabitacion reservaHabitacion, Date fechaResServ) {
        this.idResServ = idResServ;
        this.reservaHabitacion = reservaHabitacion;
        this.fechaResServ = fechaResServ;
    }
    public ReservaServExt(int idResServ, ReservaHabitacion reservaHabitacion, Date fechaResServ, Set serviciosExtrases) {
       this.idResServ = idResServ;
       this.reservaHabitacion = reservaHabitacion;
       this.fechaResServ = fechaResServ;
       this.serviciosExtrases = serviciosExtrases;
    }
   
    public int getIdResServ() {
        return this.idResServ;
    }
    
    public void setIdResServ(int idResServ) {
        this.idResServ = idResServ;
    }
    public ReservaHabitacion getReservaHabitacion() {
        return this.reservaHabitacion;
    }
    
    public void setReservaHabitacion(ReservaHabitacion reservaHabitacion) {
        this.reservaHabitacion = reservaHabitacion;
    }
    public Date getFechaResServ() {
        return this.fechaResServ;
    }
    
    public void setFechaResServ(Date fechaResServ) {
        this.fechaResServ = fechaResServ;
    }
    public Set getServiciosExtrases() {
        return this.serviciosExtrases;
    }
    
    public void setServiciosExtrases(Set serviciosExtrases) {
        this.serviciosExtrases = serviciosExtrases;
    }




}


