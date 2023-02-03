package pattsberrydb.pattsberrydb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table  (name = "datosEntrega")
public class DatosEntrega {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="noOrden", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String calle;
	@Column(nullable=false)
	private String colonia;
	@Column(nullable=false)
	private String municipio;
	@Column(nullable=false)
	private String estado;
	@Column(nullable=false)
	private int codigopostal;
	public DatosEntrega(String calle, String colonia, String municipio, String estado, int codigopostal) {
		super();
		this.calle = calle;
		this.colonia = colonia;
		this.municipio = municipio;
		this.estado = estado;
		this.codigopostal = codigopostal;
	}//constructor
	public DatosEntrega() {}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCodigopostal() {
		return codigopostal;
	}
	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "datosEntrega [calle=" + calle + ", colonia=" + colonia + ", municipio=" + municipio
				+ ", estado=" + estado + ", codigopostal=" + codigopostal + "]";
	}//toString
	
	
	
}//class

