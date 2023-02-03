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

import pattsberrydb.pattsberrydb.model.Producto;
import pattsberrydb.pattsberrydb.service.ProductoService;

@RestController
@RequestMapping (path="/api/productos/")
public class ProductoController {
	private final ProductoService productoService;
	public ProductoController(ProductoService productoService) {
		this.productoService =productoService;
	}//constructor
	
	@GetMapping
	public List<Producto> getAllProductos(){
		return productoService.getAllProductos();
	}//getallproductos
	
	 @GetMapping(path="{prodId}")
	 public Producto getProducto(@PathVariable("prodId")Long id) {
		 return productoService.getProducto(id);
	 }//getproducto
	 @DeleteMapping( path="{prodId}")
	 public Producto deleteProducto(@PathVariable("prodId")Long id) {
		 return productoService.deleteProducto(id);
	 }//deleteProducto
	@PostMapping
	public Producto addProducto (@RequestBody Producto producto) {
		return productoService.addProducto(producto);
	}//addproduct
	@PutMapping(path="{prodId}")
	public Producto updateProducto (@PathVariable("prodId")Long id,
			@RequestParam (required = false)String nombre,
			@RequestParam (required = false)String descripcion,
			@RequestParam (required = false)String imagen,
			@RequestParam (required = false)Double precio){
		return productoService.updateProducto(id, nombre, descripcion, imagen, precio);
	}//updateProduct
}//classProductocontroller
