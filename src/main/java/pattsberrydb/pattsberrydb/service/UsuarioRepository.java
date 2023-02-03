package pattsberrydb.pattsberrydb.service;

import org.springframework.data.jpa.repository.JpaRepository;

import pattsberrydb.pattsberrydb.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}//interface
