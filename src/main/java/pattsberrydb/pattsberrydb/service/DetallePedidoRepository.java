package pattsberrydb.pattsberrydb.service;

import org.springframework.data.jpa.repository.JpaRepository;

import pattsberrydb.pattsberrydb.model.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

}
