package pattsberrydb.pattsberrydb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pattsberrydb.pattsberrydb.model.DetallePedido;

@Service
public class DetallePedidoService {
	private final DetallePedidoRepository detallePedidoRepository;

	@Autowired
	public DetallePedidoService(DetallePedidoRepository detallePedidoRepository){
		this.detallePedidoRepository =detallePedidoRepository;
	}//constructor
	public List<DetallePedido>getAllDetallePedidos(){
		return detallePedidoRepository.findAll();
	}//getAll
	public DetallePedido getDetallePedido(Long id) {
		return detallePedidoRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El detalle de pedido con el id " +id + "no existe."));
	}//getdetalle
	public DetallePedido deleteDetallePedido(Long id) {
		DetallePedido tmp=null;
		if(detallePedidoRepository.existsById(id)) {
			tmp=detallePedidoRepository.findById(id).get();
			detallePedidoRepository.deleteById(id);
		}//if
		return tmp;
	}//deleteDetalle
	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		return detallePedidoRepository.save(detallePedido);
	}//add
	public DetallePedido updateDetallePedido(Long id,Integer cantidad,Double precio) {
		DetallePedido tmp=null;
		if(detallePedidoRepository.existsById(id)) {
		tmp=detallePedidoRepository.findById(id).get();
		if(cantidad!=null) tmp.setCantidad(cantidad.intValue());
		if(precio!=null) tmp.setPrecio(precio.doubleValue());
		detallePedidoRepository.save(tmp);
	}//if
	else {
		System.out.println("UPDATE - El detalle de pedido con el id " +id + "no existe.");
	}//else
	return tmp;	
	}//updatedetalle
}//class
