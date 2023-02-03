package pattsberrydb.pattsberrydb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pattsberrydb.pattsberrydb.model.DetallePedido;
import pattsberrydb.pattsberrydb.service.DetallePedidoService;


@RestController
@RequestMapping(path="/api/detallepedido/")
public class DetallePedidoController {
	private final DetallePedidoService detallePedidoService;
	public DetallePedidoController(DetallePedidoService detallePedidoService) {
		this.detallePedidoService=detallePedidoService;
	}//contructor

@GetMapping
public List<DetallePedido> getAllDetallePedidos(){
	return detallePedidoService.getAllDetallePedidos();
}//getalldetalle
@GetMapping(path="{detId}")
public DetallePedido getDetallePedido(@PathVariable("detId")Long id) {
	return detallePedidoService.getDetallePedido(id);
}//getdetalle
@DeleteMapping(path="{detId}")
public DetallePedido deleteDetallePedido(@PathVariable("detId")Long id){
	return detallePedidoService.deleteDetallePedido(id);
}//deletedetalle
@PostMapping
public DetallePedido addDetallePedido(@RequestBody DetallePedido detallePedido) {
	return detallePedidoService.addDetallePedido(detallePedido);
}//adddetalle
@PutMapping
public DetallePedido updateDetallePedido(@PathVariable("detId")Long id,
		@RequestParam(required=false)Integer cantidad,
		@RequestParam(required=false)Double precio
		) {
	return detallePedidoService.updateDetallePedido(id, cantidad,precio);
}//updatedetalle
}
