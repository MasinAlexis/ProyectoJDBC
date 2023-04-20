package org.conexionjdbc;

import java.sql.*;

public class IntroduccionJDBC {
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        try{
            //Objeto de conexion
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT id_persona, nombre, apellido, email,telefono, saldo FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.println("Id Persona: " + resultado.getInt(1) + "\n");
                System.out.println("Nombre: " + resultado.getString(2) + "\n");
                System.out.println("Apellido: " + resultado.getString(3) + "\n");
                System.out.println("Email: " + resultado.getString(4) + "\n");
                System.out.println("Telefono: " + resultado.getString(5) + "\n");
                System.out.println("Saldo: " + resultado.getDouble(6) + "\n");
                System.out.println("----------------------------------------\n");
            }
            //Cerramos objetos
            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException e){
            e.printStackTrace(System.out);
        }

    }
}
