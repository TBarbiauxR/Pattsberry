package pattsberrydb.pattsberrydb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pattsberrydb.pattsberrydb.model.Usuario;

@Service
public class UsuarioService {
private final UsuarioRepository usuarioRepository;
@Autowired 
public UsuarioService (UsuarioRepository usuarioRepository) {
	this.usuarioRepository = usuarioRepository;
	
}//constructor
public List<Usuario>getAllUsuarios(){
	return usuarioRepository.findAll();
}//getall
public Usuario getUsuario(Long id) {
	return usuarioRepository.findById(id).orElseThrow(
			()->new IllegalArgumentException("El usuario con el id " +id + "no existe."));
}//getusuario
public Usuario deleteUsuario(Long id) {
	Usuario tmp = null;
	if(usuarioRepository.existsById(id)) {
		tmp=usuarioRepository.findById(id).get();
		usuarioRepository.deleteById(id);
		}//if
	return tmp;
}//deleteusuario
public Usuario addUsuario(Usuario usuario) {
	return usuarioRepository.save(usuario);
}//addUsuario
public Usuario updateUsuario(Long id,String nombre,String contrasena,
		String correo,String telefono, Boolean administrador) {
	Usuario tmp = null;
	if(usuarioRepository.existsById(id)) {
		tmp =usuarioRepository.findById(id).get();
		if (nombre !=null) tmp.setNombre(nombre);
		if (contrasena !=null) tmp.setContraseña(contrasena);
		if (correo !=null) tmp.setCorreo(correo);
		if (telefono !=null) tmp.setTelefono(telefono);
		if (administrador !=null) tmp.setAdministrador(administrador);
		usuarioRepository.save(tmp);
	}//if
	else {
		System.out.println("UPDATE - El usuario con el id " +id + "no existe.");
	}//else
	return tmp;
}//updateUsuario


}//classUsuarioService
