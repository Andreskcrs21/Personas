/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas;

/**
 *
 * @author IdeaPad - S340
 */
public class Personas {
    private String nombres, apellidos;
    private int id;
    
    public Personas(){}
     public Personas(String nombres, String apellidos, int id) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id = id;
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Personas{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", id=" + id + '}';
    }

   

   

   
    

    

    
     
   
   
    
}
