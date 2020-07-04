package ws_rest.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EstudianteBean {
	private int aludni;
	private String nombre;
	private String apellido;
	private int edad;
	private String cursos;
	private int telefono;
	
	
	
	public int getAludni() {
		return aludni;
	}
	public void setAludni(int aludni) {
		this.aludni = aludni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCursos() {
		return cursos;
	}
	public void setCursos(String cursos) {
		this.cursos = cursos;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
}
