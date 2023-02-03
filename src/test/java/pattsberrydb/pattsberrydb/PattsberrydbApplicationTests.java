package pattsberrydb.pattsberrydb;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import pattsberrydb.pattsberrydb.model.Producto;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
class PattsberrydbApplicationTests {
@Autowired	
private MockMvc mockMvc;

@Test
@DisplayName("Prueba el método POST para crear un producto")
public void pruebaPOST() throws Exception {
	Producto p = new Producto();
	p.setNombre("libreta girasoles");
	p.setDescripcion("Libreta de arillo, tamaño media carta, 100 hojas rayadas");
	p.setImagen("/Images/libretasImg/girasoles.jpg");
	p.setPrecio(200.00);
	this.mockMvc.perform( post("/api/productos/")
			.contentType(MediaType.APPLICATION_JSON) 
			.content(asJsonString(p))
			).andDo( print() )
    .andDo( print() )
    .andExpect( status().isOk() )
    .andExpect(content().string(containsString("") ) );
}//PruebaPOST
//convertir un objeto y pasarlo a string
private static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }//catch
 } // asJsonString
@Test
@DisplayName("Prueba el método UPDATE de productos con el id=5 y su contenido")
public void pruebaUPDATE() throws Exception {
    this.mockMvc.perform( put("/api/productos/5").queryParam("nombre", "Monkey")  )
    .andDo( print() )
    .andExpect( status().isOk() )
    .andExpect(content().string(containsString("Monkey") ) );
}//pruebaupdate

@Test
@DisplayName("Prueba el método DELETE de productos con el id=4 y su contenido")
@Disabled("Se deshabilita temporalmente para no borrar registros en cada prueba")
public void pruebaDELETE() throws Exception {
	this.mockMvc.perform( delete("/api/productos/4") )
    .andDo( print() )
    .andExpect( status().isOk() )
    .andExpect(content().string(containsString("gatoalicia.jpg") ) );
}//pruebaDELETE
	@Test
	@DisplayName ("Prueba el método GET de productos  con el id= 1 y su contenido")
	public void pruebaGET() throws Exception{
		this.mockMvc.perform(get("/api/productos/1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("/Images/amiguImg/aguacates.jpg")));

	}//pruebaGET

}//classPattsberrydb
