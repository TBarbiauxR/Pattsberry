package pattsberrydb.pattsberrydb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pattsberrydb.pattsberrydb.model.Producto;

@Service
public class ProductoService {
	private final ProductoRepository productoRepository;
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
		}//constructor
	
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	}//getAllProductos
	public Producto getProducto(Long id) {
		return productoRepository.findById(id).orElseThrow(
				()->new IllegalAccessError("El producto con el id" + id +"no existe.")
				);		
	}//getproducto
	public Producto deleteProducto(Long id) {
		Producto tmp = null;
		if(productoRepository.existsById(id)) {
			tmp=productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}
		return tmp;
	}//deleteproducto
	public Producto addProducto(Producto producto) {
		return productoRepository.save(producto);
	}//addproducto
	
	public Producto updateProducto(Long id, String nombre, String descripcion,String imagen, Double precio) {
		Producto tmp =null;
		if(productoRepository.existsById(id)) {
			tmp=productoRepository.findById(id).get();
			if(nombre != null)tmp.setNombre(nombre);
			if(descripcion != null)tmp.setDescripcion(descripcion);
			if(imagen != null)tmp.setImagen(imagen);
			if(precio!=null) tmp.setPrecio(precio.doubleValue());
			productoRepository.save(tmp);
	}else {
		System.out.println("Update - El producto con el id" + id +"no se ha actualizado");
	}//else
		return tmp;
	}//updateProducto
}//classProductoService


