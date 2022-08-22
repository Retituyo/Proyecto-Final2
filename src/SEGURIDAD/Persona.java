package SEGURIDAD;

/**
 *
 * @author Restituyo
 */
public  class Persona {

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;

    public Persona(String nombre, String apellido, String correo, String telefono) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Emcapslm
    public String getNombre() {

        return this.nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;

    }

    public String getApellido() {

        return this.apellido;
    }

    public void setApellido(String apellido) {

        this.nombre = apellido;

    }

    public String getCorreo() {

        return this.correo;
    }

    public void setCorreo(String correo) {

        this.nombre = correo;

    }

    public String getTelefono() {

        return this.telefono;
    }

    public void setTelefono(String telefono) {

        this.nombre = telefono;

    }

}
