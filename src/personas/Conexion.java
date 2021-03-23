
package personas;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;

public class Conexion {
    private ObjectContainer oc;
    
    private void open(){
        // Creamos la conexion y el archivo que almacenara los datos
        this.oc = Db4o.openFile("database.yap");
    }
    public boolean Insertar(Personas objeto){
        try {
            this.open();
            oc.set(objeto);
            this.oc.close();
            return true;
           
        
        
        }catch(DatabaseClosedException | DatabaseReadOnlyException e){
            System.out.println("bdoo.Controlador.insertarPersona():"+e);
            return false;
        }
    
    
    }
    public Personas buscarPersonas(Personas objeto){
        this.open();
        Personas encontrado = null;
        ObjectSet resultados = this.oc.get(objeto);
        
        if (resultados.hasNext()) {
            encontrado = (Personas) resultados.next();
            
            
        }
        this.oc.close();
        return encontrado;
    
    
    }
    public Personas[] TraerPersonas(Personas objeto) {
        try {
            //CONSULTAMOS LOS OBJETOS ALMACENADOS EN LA BASE DE DATOS Y LOS RETORNAMOS EN UN ARREGLO DE TIPO Persona
            Personas[] personas = null;
            this.open();
            ObjectSet resultados = this.oc.get(objeto);
            int i = 0;
            if (resultados.hasNext()) {
                personas = new Personas[resultados.size()];
                while (resultados.hasNext()) {
                    personas[i] = (Personas) resultados.next();
                    i++;
                }
            }
            this.oc.close();
            return personas;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarPersona() : " + e);
            return null;
        }
    }
     public boolean EliminarPersonas(Personas objeto) {
        try {
            //CONSULTAMOS LOS OBJETOS ALMACENADOS EN LA BASE DE DATOS Y SI EXISTE UNA COINCIDENCIA LA ELIMINAMOS            
            this.open();
            ObjectSet resultados = this.oc.get(objeto);
            if (resultados.size() > 0) {
                Personas persona = (Personas) resultados.next();
                this.oc.delete(persona);
                this.oc.close();
                return true;
            } else {
                this.oc.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarPersona() : " + e);
            return false;
        }
    }
      public boolean actualizarPersonas(Personas objeto) {
        try {
            //BUSCAMOS SI EXISTE EL OBJETO, SI ES ASÍ LO ACTUALIZAMOS EN LA BASE DE DATOS
            this.open();
            ObjectSet resultados = this.oc.get(new Personas(null, null, objeto.getId()));
            if (resultados.size() > 0) {                
                Personas resultado = (Personas) resultados.next();
                resultado.setNombres(objeto.getNombres());
                resultado.setApellidos(objeto.getApellidos());
                resultado.setId(objeto.getId());
                this.oc.set(resultado);
                this.oc.close();
                return true;
            } else {
                this.oc.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarPersona() : " + e);
            return false;
        }
    }
     
    
    
}
