
package personas;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IdeaPad - S340
 */
public class controlador extends Conexion{
    
    
    public boolean insertarPersona(int id, String nombre, String apellidos) {
        Personas persona = new Personas(nombre, apellidos, id);
        return this.Insertar(persona);
    }
    public boolean actualizarPersona(int id, String nombre, String apellidos) {
        Personas actualizado = new Personas(nombre, apellidos, id);        
        return this.actualizarPersonas(actualizado);
    }
    
    public DefaultTableModel personas() {
        String titulos[] = {"Id", "Nombre", "Apellidos"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        Personas persona = null;
        Personas[] p = this.TraerPersonas(persona);
        if (p != null) {
            for (Personas per : p) {
                Object[] cli = new Object[3];
                cli[0] = per.getId();
                cli[1] = per.getNombres();
                cli[2] = per.getApellidos();
                dtm.addRow(cli);
            }
        }
        return dtm;
    }

    public boolean eliminarPersona(int id) {
        if (id > 0) {
            Personas persona = new Personas(null, null, id);
            return this.EliminarPersonas(persona);
        } else {
            return false;
        }
    }
   
}
