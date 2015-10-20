package ModeloHibernate;
// Generated 20-10-2015 3:44:20 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Ciudad generated by hbm2java
 */
public class Ciudad  implements java.io.Serializable {


     private BigDecimal idCiudad;
     private Hoteles hoteles;
     private String nombreCiudad;
     private Set empresas = new HashSet(0);
     private Set proveedoreses = new HashSet(0);

    public Ciudad() {
    }

	
    public Ciudad(BigDecimal idCiudad, Hoteles hoteles, String nombreCiudad) {
        this.idCiudad = idCiudad;
        this.hoteles = hoteles;
        this.nombreCiudad = nombreCiudad;
    }
    public Ciudad(BigDecimal idCiudad, Hoteles hoteles, String nombreCiudad, Set empresas, Set proveedoreses) {
       this.idCiudad = idCiudad;
       this.hoteles = hoteles;
       this.nombreCiudad = nombreCiudad;
       this.empresas = empresas;
       this.proveedoreses = proveedoreses;
    }
   
    public BigDecimal getIdCiudad() {
        return this.idCiudad;
    }
    
    public void setIdCiudad(BigDecimal idCiudad) {
        this.idCiudad = idCiudad;
    }
    public Hoteles getHoteles() {
        return this.hoteles;
    }
    
    public void setHoteles(Hoteles hoteles) {
        this.hoteles = hoteles;
    }
    public String getNombreCiudad() {
        return this.nombreCiudad;
    }
    
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    public Set getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Set empresas) {
        this.empresas = empresas;
    }
    public Set getProveedoreses() {
        return this.proveedoreses;
    }
    
    public void setProveedoreses(Set proveedoreses) {
        this.proveedoreses = proveedoreses;
    }




}


