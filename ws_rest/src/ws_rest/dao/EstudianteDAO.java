package ws_rest.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ws_rest.bean.EstudianteBean;
import ws_rest.conexion.miConexion;

public class EstudianteDAO {
	public static void main(String[] args) {
		EstudianteDAO dao = new EstudianteDAO();
		EstudianteBean bean = new EstudianteBean();
		
		bean.setAludni(74748547);
		bean.setNombre("Guerald");
		bean.setApellido("Sangama");
		bean.setEdad(15);
		bean.setCursos("Matematica");
		bean.setTelefono(988096469);
		
		System.out.println(dao.GrabarES(bean));
		System.out.println(dao.Listado());
		System.out.println(dao.Buscar(74749754));
		
	}
	
	public String GrabarES(EstudianteBean bean){
		String result = "error";
		miConexion con = new miConexion();
		Object[] param = { bean.getAludni(),bean.getNombre(),
				  bean.getApellido(),
				  bean.getEdad(),
				  bean.getCursos(),
				  bean.getTelefono()
				  };
		result = con.Ejecutar("insert into Estudiante values(?,?,?,?,?,?)", param);
		return result;
	}
	
	public ArrayList<EstudianteBean>Listado()
	{
		ArrayList<EstudianteBean>alumnos=new ArrayList<EstudianteBean>();
		miConexion cn=new miConexion();
		
		try {
			ResultSet rs=cn.Listado("select * from estudiantes", new Object[]{});
			EstudianteBean bean;
			while(rs.next())
			{
				bean=new EstudianteBean();
				bean.setAludni(rs.getInt("dni_est"));
				bean.setNombre(rs.getString("nom_est"));
				bean.setApellido(rs.getString("ape_est"));
				bean.setEdad(rs.getInt("edad_est"));
				bean.setCursos(rs.getString("cur_est"));
				bean.setTelefono(rs.getInt("tele_est"));
				alumnos.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	
	
	public ArrayList<EstudianteBean> Buscar(int dni)
	{
		ArrayList<EstudianteBean>alumnos=new ArrayList<EstudianteBean>();
		EstudianteBean bean=null;
		miConexion cn=new miConexion();
		
		try {
			ResultSet rs=cn.Listado("select * from estudiantes where aludni=?",
					new Object[]{dni});
			if(rs.next())
			{
				bean=new EstudianteBean();
				bean.setAludni(rs.getInt("dni_est"));
				bean.setNombre(rs.getString("nom_est"));
				bean.setApellido(rs.getString("ape_est"));
				bean.setEdad(rs.getInt("edad_est"));
				bean.setCursos(rs.getString("cur_est"));
				bean.setTelefono(rs.getInt("tele_est"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alumnos;
	}
}
