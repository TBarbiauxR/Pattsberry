package pattsberrydb.pattsberrydb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="idpedido", unique=true, nullable=false)
private Long id;
@Column(nullable=false)
private double total;
@Column(nullable=false)
private String fecha;
public Pedido(double total, String fecha) {
	super();
	this.total = total;
	this.fecha = fecha;
}//contructor
public Pedido() {}//constructorvacio
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public Long getId() {
	return id;
}
@Override
public String toString() {
	return "Pedidos [total=" + total + ", fecha=" + fecha + "]";
}


}
