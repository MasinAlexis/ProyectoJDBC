package org.conexionjdbc;

import datos.Conexion;
import datos.PersonasJDBC;
import domain.Persona;

import java.sql.Connection;
import java.sql.SQLException;

public class ManejoDeTransaccionesJDBC {
    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit() == true){
                conexion.setAutoCommit(false);
            }
            PersonasJDBC personasJDBC = new PersonasJDBC(conexion); //Se lo pasa de esta manera para que el commit no se haga de manera automatica
            //Realizamos la transaccion para realizar test de commit
            Persona personaUp = new Persona();
                personaUp.setId_persona(1);
                personaUp.setNombre("Alexis Alberto");
                personaUp.setApellido("Masin");
                personaUp.setEmail("AlexisMasin86@gmail.com");
                personaUp.setTelefono("3624016285");
                personaUp.setSaldo(2700.50);
            personasJDBC.update(personaUp);

            //Forzamos un error para ejecutar el rollback luego de la actualizacion
            Persona personaIns = new Persona();
                personaIns.setNombre("Hugo#############################################"); //Insertamos un valor que excede la longitud del atributo en la definicion de la tabla
                //personaIns.setNombre("Hugo"); Para este caso no se ejecutaria el rollback y se realizarian los cambios en la BD
                personaIns.setApellido("Garcia");
                personaIns.setEmail("hugog@gmail.com");
                personaIns.setTelefono("3624857463");
                personaIns.setSaldo(2400.50);
            personasJDBC.insert(personaIns);
            conexion.commit();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Se produjo un error en la transaccion. Deshacemos cambios");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
