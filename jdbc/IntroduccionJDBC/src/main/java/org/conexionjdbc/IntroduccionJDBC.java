package org.conexionjdbc;

import datos.PersonasJDBC;
import domain.Persona;

import java.sql.*;
import java.util.List;

public class IntroduccionJDBC {
    public static void main(String[] args){

        PersonasJDBC personasJDBC = new PersonasJDBC();
        try {
            List<Persona> personas = personasJDBC.select();
            for (Persona persona: personas) {
                System.out.println(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

    }
}
