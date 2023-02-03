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

import pattsberrydb.pattsberrydb.model.Pedido;
import pattsberrydb.pattsberrydb.service.PedidoService;
@RestController
@RequestMapping(path="/api/pedido/")
public class PedidoController {
		private final PedidoService pedidoService;
		public PedidoController(PedidoService pedidoService) {
			this.pedidoService=pedidoService;
		}//contructor

	@GetMapping
	public List<Pedido> getAllDatosEntregas(){
		return pedidoService.getAllPedidos();
	}//getallpedido
	@GetMapping(path="{pedId}")
	public Pedido getPedido(@PathVariable("pedId")Long id) {
		return pedidoService.getPedido(id);
	}//getpedido
	@DeleteMapping(path="{pedId}")
	public Pedido deletePedido(@PathVariable("pedId")Long id){
		return pedidoService.deletePedido(id);
	}//deletepedido
	@PostMapping
	public Pedido addPedido(@RequestBody Pedido pedido) {
		return pedidoService.addPedido(pedido);
	}//addDatos
	@PutMapping
	public Pedido updatePedido(@PathVariable("pedId")Long id,
			@RequestParam(required=false)Double total,
			@RequestParam(required=false)String fecha
			) {
		return pedidoService.updatePedido(id, total,fecha);
	}//updateDatos
}
