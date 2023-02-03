package pattsberrydb.pattsberrydb.service;

import org.springframework.data.jpa.repository.JpaRepository;

import pattsberrydb.pattsberrydb.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
