package pattsberrydb.pattsberrydb.service;

import org.springframework.data.jpa.repository.JpaRepository;

import pattsberrydb.pattsberrydb.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	

}
