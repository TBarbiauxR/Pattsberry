package pattsberrydb.pattsberrydb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pattsberrydb.pattsberrydb.model.DatosEntrega;

@Service
public class DatosEntregaService {
		private final DatosEntregaRepository datosEntregaRepository;

@Autowired
public DatosEntregaService(DatosEntregaRepository datosEntregaRepository){
	this.datosEntregaRepository =datosEntregaRepository;
}//constructor
public List<DatosEntrega>getAllDatosEntregas(){
	return datosEntregaRepository.findAll();
}//getAll
public DatosEntrega getDatosEntrega(Long id) {
	return datosEntregaRepository.findById(id).orElseThrow(
			()->new IllegalArgumentException("La entrega con el id " +id + "no existe."));
}//getdatos
public DatosEntrega deleteDatosEntrega(Long id) {
	DatosEntrega tmp=null;
	if(datosEntregaRepository.existsById(id)) {
		tmp=datosEntregaRepository.findById(id).get();
		datosEntregaRepository.deleteById(id);
	}//if
	return tmp;
}//deleteDatos
public DatosEntrega addDatosEntrega(DatosEntrega datosEntrega) {
	return datosEntregaRepository.save(datosEntrega);
}//add
public DatosEntrega updateDatosEntrega(Long id,String calle, String colonia, String municipio, 
		String estado, Integer codigopostal) {
	DatosEntrega tmp=null;
	if(datosEntregaRepository.existsById(id)) {
	tmp=datosEntregaRepository.findById(id).get();
	if(calle!=null) tmp.setCalle(calle);
	if(colonia!=null) tmp.setColonia(colonia);
	if(municipio!=null) tmp.setMunicipio(municipio);
	if(estado!=null) tmp.setEstado(estado);
	if(codigopostal!=null) tmp.setCodigopostal(codigopostal.intValue());
	datosEntregaRepository.save(tmp);
}//if
else {
	System.out.println("UPDATE - La entrega con el id " +id + "no existe.");
}//else
return tmp;	
}//upodateDatos
}//class
