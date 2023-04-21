package domain;

public class Persona {

    private int id_persona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Double saldo;

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Persona{" + "\n" +
                "    id_persona= " + id_persona + "\n" +
                "    nombre= " + nombre + "\n" +
                "    apellido= " + apellido + "\n" +
                "    email= " + email + "\n" +
                "    telefono= " + telefono + "\n" +
                "    saldo= " + saldo + "\n" +
                '}' + "\n" +
                "-----------------------------------";
    }
}
