package ws_rest.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class miConexion {
	Connection cn=null;
	public miConexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			cn = DriverManager.
			getConnection("jdbc:mysql://localhost:3306/dbestudi","root","mysql");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String Ejecutar(String SQL,Object[] arreglo){
		String result="";
		try {
			PreparedStatement cmd=cn.prepareStatement(SQL);
			for(int i=0;i<arreglo.length;i++){
				cmd.setObject(i+1, arreglo[i]);
			}
			int f=cmd.executeUpdate();
			result="Se afectaron "+f+" filas";
		} catch (Exception e) {
			result ="Error "+e.getMessage();
		}	
		return result;
	}
	
	public ResultSet Listado(String SQL,Object[] arreglo){
		ResultSet rs=null;
		try {
			PreparedStatement cmd=cn.prepareStatement(SQL);
			for(int i=0;i<arreglo.length;i++){
				cmd.setObject(i+1, arreglo[i]);
			}
			rs=cmd.executeQuery();			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}	
}
