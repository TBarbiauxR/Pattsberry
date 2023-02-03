package pattsberrydb.pattsberrydb.service;

import org.springframework.data.jpa.repository.JpaRepository;

import pattsberrydb.pattsberrydb.model.DatosEntrega;

import org.springframework.stereotype.Repository;

@Repository
public interface DatosEntregaRepository extends JpaRepository<DatosEntrega, Long> {

}
