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

import pattsberrydb.pattsberrydb.model.DatosEntrega;
import pattsberrydb.pattsberrydb.service.DatosEntregaService;

@RestController
@RequestMapping(path="/api/datosentrega/")
public class DatosEntregaController {
	private final DatosEntregaService datosEntregaService;
	public DatosEntregaController(DatosEntregaService datosEntregaService) {
		this.datosEntregaService=datosEntregaService;
	}//contructor

@GetMapping
public List<DatosEntrega> getAllDatosEntregas(){
	return datosEntregaService.getAllDatosEntregas();
}//getalldatos
@GetMapping(path="{delivId}")
public DatosEntrega getDaatosEntrega(@PathVariable("delivId")Long id) {
	return datosEntregaService.getDatosEntrega(id);
}//getDatos
@DeleteMapping(path="{delivId}")
public DatosEntrega deleteDatosEntrega(@PathVariable("delivId")Long id){
	return datosEntregaService.deleteDatosEntrega(id);
}//deleteDatos
@PostMapping
public DatosEntrega addDatosEntrega(@RequestBody DatosEntrega datosEntrega) {
	return datosEntregaService.addDatosEntrega(datosEntrega);
}//addDatos
@PutMapping
public DatosEntrega updateDatosEntrega(@PathVariable("delivId")Long id,
		@RequestParam(required=false)String calle,
		@RequestParam(required=false)String colonia,
		@RequestParam(required=false)String municipio,
		@RequestParam(required=false)String estado,
		@RequestParam(required=false)Integer codigopostal
		) {
	return datosEntregaService.updateDatosEntrega(id, calle, colonia, municipio, estado, codigopostal);
}//updateDatos
}//class
