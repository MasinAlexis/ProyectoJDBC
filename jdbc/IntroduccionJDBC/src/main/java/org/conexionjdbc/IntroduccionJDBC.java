package org.conexionjdbc;

import datos.PersonasJDBC;
import datos.UsuarioJDBC;
import domain.Persona;
import domain.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IntroduccionJDBC {
    public static void main(String[] args){

        PersonasJDBC personasJDBC = new PersonasJDBC();
        //Ejecutamos SELECT
        try {
            List<Persona> personas = personasJDBC.select();
            for (Persona persona: personas) {
                System.out.println(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        //Ejecutamos INSERT
        /*
        Persona persona = new Persona();
            persona.setNombre("Hugo");
            persona.setApellido("Garcia");
            persona.setEmail("hugog@gmail.com");
            persona.setTelefono("3624857463");
            persona.setSaldo(2400.50);
        personasJDBC.insert(persona);
        */

        //Ejecutamos UPDATE
        /*
        Persona personaUp = new Persona();
            personaUp.setId_persona(7);
            personaUp.setNombre("Hugo");
            personaUp.setApellido("Ramirez");
            personaUp.setEmail("hugor@gmail.com");
            personaUp.setTelefono("3624857463");
            personaUp.setSaldo(2700.50);
        personasJDBC.update(personaUp);
         */

        //Ejecutamos DELETE
        /*
        Persona personaDel = new Persona();
            personaDel.setId_persona(7);
        personasJDBC.delete(personaDel);
         */

        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
        List<Usuario> usuarios = usuarioJDBC.select();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}
