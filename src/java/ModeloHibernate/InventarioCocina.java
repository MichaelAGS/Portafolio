package ModeloHibernate;
// Generated 19-10-2015 19:45:52 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * InventarioCocina generated by hbm2java
 */
public class InventarioCocina  implements java.io.Serializable {


     private BigDecimal idInventCoc;
     private Insumos insumos;
     private MateniaPrima mateniaPrima;
     private String nombreIngrediente;
     private BigDecimal cantidad;
     private Set proveedoreses = new HashSet(0);
     private Set ingredientes = new HashSet(0);

    public InventarioCocina() {
    }

	
    public InventarioCocina(Insumos insumos, String nombreIngrediente, BigDecimal cantidad) {
        this.insumos = insumos;
        this.nombreIngrediente = nombreIngrediente;
        this.cantidad = cantidad;
    }
    public InventarioCocina(Insumos insumos, MateniaPrima mateniaPrima, String nombreIngrediente, BigDecimal cantidad, Set proveedoreses, Set ingredientes) {
       this.insumos = insumos;
       this.mateniaPrima = mateniaPrima;
       this.nombreIngrediente = nombreIngrediente;
       this.cantidad = cantidad;
       this.proveedoreses = proveedoreses;
       this.ingredientes = ingredientes;
    }
   
    public BigDecimal getIdInventCoc() {
        return this.idInventCoc;
    }
    
    public void setIdInventCoc(BigDecimal idInventCoc) {
        this.idInventCoc = idInventCoc;
    }
    public Insumos getInsumos() {
        return this.insumos;
    }
    
    public void setInsumos(Insumos insumos) {
        this.insumos = insumos;
    }
    public MateniaPrima getMateniaPrima() {
        return this.mateniaPrima;
    }
    
    public void setMateniaPrima(MateniaPrima mateniaPrima) {
        this.mateniaPrima = mateniaPrima;
    }
    public String getNombreIngrediente() {
        return this.nombreIngrediente;
    }
    
    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }
    public BigDecimal getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
    public Set getProveedoreses() {
        return this.proveedoreses;
    }
    
    public void setProveedoreses(Set proveedoreses) {
        this.proveedoreses = proveedoreses;
    }
    public Set getIngredientes() {
        return this.ingredientes;
    }
    
    public void setIngredientes(Set ingredientes) {
        this.ingredientes = ingredientes;
    }




}


