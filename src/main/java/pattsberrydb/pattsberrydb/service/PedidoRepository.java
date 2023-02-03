package pattsberrydb.pattsberrydb.service;

import org.springframework.data.jpa.repository.JpaRepository;

import pattsberrydb.pattsberrydb.model.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
