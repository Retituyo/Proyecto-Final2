package SEGURIDAD;

/**
 *
 * @author Restituyo
 */
/*¡REQUERIMIENTO IMPORTANTE! APLICAMOS --HERENCIA--"*/
public class Usuario extends Persona {

    private String usuario;
    private String contra;
    
    public  Usuario(String usuario, String contra, String nombre, String apellido, String correo, String telefono) {

        super(nombre, apellido, correo, telefono);
        this.usuario = usuario;
        this.contra = contra;
    }

    // Encapslm, listo.
    public String getUsuario() {

        return this.usuario;
    }

    public void setUsuario(String usuario) {

        this.usuario = usuario;

    }

    public String getContra() {

        return this.contra;
    }

    public void setContra(String contra) {

        this.contra = contra;

    }
    
}
