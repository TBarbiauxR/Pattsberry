package pattsberrydb.pattsberrydb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pattsberrydb.pattsberrydb.model.Pedido;

@Service
public class PedidoService {
private final PedidoRepository pedidoRepository;
@Autowired
public PedidoService(PedidoRepository pedidoRepository) {
	this.pedidoRepository=pedidoRepository;
}//constructor
public List<Pedido> getAllPedidos(){
	return pedidoRepository.findAll();
}//getAllpedido
public Pedido getPedido(Long id) {
	return pedidoRepository.findById(id).orElseThrow(
			()-> new IllegalAccessError("El pedido con el id" + id +"no existe.")
			);
}//getpedido
public Pedido deletePedido(Long id) {
	Pedido tmp = null;
	if(pedidoRepository.existsById(id)) {
		tmp=pedidoRepository.findById(id).get();
		pedidoRepository.deleteById(id);
	}
	return tmp;
}//deletepedido
public Pedido addPedido(Pedido pedido) {
	return pedidoRepository.save(pedido);
}//addpedido
public Pedido updatePedido(Long id,Double total, String fecha) {
	Pedido tmp=null;
	if(pedidoRepository.existsById(id)) {
		tmp=pedidoRepository.findById(id).get();
		if(total!=null)tmp.setTotal(total.doubleValue());
		if(fecha!=null)tmp.setFecha(fecha);
		pedidoRepository.save(tmp);
	}//if
	else {
		System.out.println("UPDATE - El pedido con el id" + id +"no existe.");
	}//else
	return tmp;
}//updatePedido
}//class
