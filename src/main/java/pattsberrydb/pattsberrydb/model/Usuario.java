package pattsberrydb.pattsberrydb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="idusuarios", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String contrasena;
	@Column(nullable=false)
	private String correo;
	@Column(nullable=false)
	private String telefono;
	@Column(nullable=false)
	private boolean administrador;
	public Usuario(String nombre, String correo, String contrasena, String telefono, Boolean administrador) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.administrador = administrador;
	}//constructorconcampos
	public Usuario() {
		
	}//constructorvacio
	public String getNombre() {
		return nombre;
	}//getNombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre
	public String getCorreo() {
		return correo;
	}//getCorreo
	public void setCorreo(String correo) {
		this.correo = correo;
	}//setCorreo
	public String getContraseña() {
		return contrasena;
	}//getContraseña
	public void setContraseña(String contrasena) {
		this.contrasena = contrasena;
	}//setContraseña
	public String getTelefono() {
		return telefono;
	}//getTelefono
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//setTelefono
	public Boolean getAdministrador() {
		return administrador;
	}//getAdministrador
	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}//setAdministrador
	public Long getIdusuarios() {
		return id;
	}//getIdusuarios
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasena=" + contrasena + ", correo=" + correo + ", telefono="
				+ telefono + ", administrador=" + administrador + "]";
	}//toString
	
	
	


}//class
