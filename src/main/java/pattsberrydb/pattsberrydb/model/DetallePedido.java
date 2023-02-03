package pattsberrydb.pattsberrydb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detallepedido")
public class DetallePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private int cantidad;
	@Column(nullable=false)
	private double precio;
	public DetallePedido(int cantidad, double precio) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
	}//constructor
public DetallePedido() {}//constructorvacio
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public Long getId() {
	return id;
}
@Override
public String toString() {
	return "DetallePedido [cantidad=" + cantidad + ", precio=" + precio + "]";
}//toString
		
}//class
