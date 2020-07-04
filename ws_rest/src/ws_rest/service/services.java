package ws_rest.service;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ws_rest.bean.EstudianteBean;
import ws_rest.dao.EstudianteDAO;

@Path("/servicio")
public class services {
	
	@Path("/prueba")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String prueba(){
		return "Esto es una prueba";
	}
	
	
	@Path("/AgregarEstudiante")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String grabar(EstudianteBean bean){
		System.out.print("agregar"+bean.getNombre());
		return new EstudianteDAO().GrabarES(bean);
	}
	
	@Path("/lista")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<EstudianteBean>listado(){
		return new EstudianteDAO().Listado();
	} 
	
	@GET
	@Path("/buscar/{dni}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<EstudianteBean> buscar(@PathParam("dni") int dni){
		return new EstudianteDAO().Buscar(dni);
	}
	
	
	
}
