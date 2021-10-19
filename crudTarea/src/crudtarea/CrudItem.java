/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudtarea;

package crudTarea.Apliacion;

import java.util.Date;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Edgardo Rojas
 */
public class CrudItem {
    
     /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    /**
     * @return the _autores
     */
    public String getApellidos() {
        return _apellidos;
    }

    /**
     * @param _autores the _autores to set
     */
    public void setApellidos(String _Apellidos) {
        this._Apellidos = _Apellidos;
    }

    /**
     * @return the _fechaLanzamiento
     */
    public Date getFecha() {
        return _fecha;
    }

    /**
     * @param _fechaLanzamiento the _fechaLanzamiento to set
     */
    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    /**
     * @return the _album
     */
    public String getRegistro() {
        return _registro;
    }

    /**
     * @param _album the _album to set
     */
    public void setRegistro(String _Registro) {
        this._Registro = _Registro;
    }
    private int _id;
    private String _nombre;
    private String _apellido;
    private Date _fecha;
    
    
    public CrudItem(){
        this._id = 0;
        this._nombre = "";
        this._apellidos = "";
        this._registro = "";
        this._fecha =  new Date();
    }
    
    public MusicItem(int id, String nombre, String apellido, String registro, Date fecha) {
        this._id = 0;
        this._nombre = "";
        this._apellidos = "";
        this._registro = "";
        this._fecha =  new Date();
    }
    
    public ArrayList<String> obtenerCampos(){
        ArrayList<String> campos = new ArrayList<String>();
        campos.add(String.valueOf(this._id));
        campos.add(this._nombre);
        campos.add(this._apellido);
        campos.add(this._registro);
        campos.add("________");
        
        return campos;
        
    }
   
    
    
    
}
