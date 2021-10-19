/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class Cruddb {
    
    private ArrayList _musicItems;
    
    public CrudDB(){
        this._CrudItems = new ArrayList<CrudItem>();
    }
    
    public ArrayList<CrudItem> getCrudItems(){
        return this.getCrudItems(false);
    }
    
    public void tableInitialize(){
        String sqlCreate = "CREATE TABLE IF NOT EXISTS CRUD"
                        + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                        + " NOMBRE TEXT NOT NULL,"
                        + " APELLIDO TEXT NOT NULL,"
                        + " REGISTRO TEXT NOT NULL"
                        + ")";
       
        try {
            Statement comando = Conexion.getConexion().createStatement();
            int resultado = comando.executeUpdate(sqlCreate);
            comando.close();
        } catch( Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<CrudItem> getCrudItems(boolean forceLoad){
        try {
           if (forceLoad) {
                Statement comando =  Conexion.getConexion().createStatement();
                ResultSet misRegistro = comando.executeQuery("SELECT * from CRUD;");
                this._CrudItems.clear();
                while (misRegistro.next()) {
                    CrudItem registro = new CrudItem();
                    registro.setId(misRegistro.getInt("ID"));
                    registro.setNombre(misRegistro.getString("NOMBRE"));
                    registro.setapellido(misRegistro.getString("Apellido"));
                    registro.setRegistro(misRegistro.getString("registro"));
                    this._CrudItems.add(registro);
                }
                comando.close();
           }
           return this._CrudItems;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return this._CrudItems;
        }   
    }
    
    public CrudItem getCrudItemById(int id){
        try {
            String SQLGetByID = "SELECT * FROM MUSICA WHERE ID = ?;";
            PreparedStatement comando =  Conexion.getConexion().prepareStatement(SQLGetByID);
            comando.setInt(1, id);
            ResultSet misRegistro = comando.executeQuery();
            CrudItem registro = new CrudItem();
            while (misRegistro.next()){
                registro.setId(misRegistro.getInt("ID"));
                registro.setNombre(misRegistro.getString("NOMBRE"));
                registro.setAlbum(misRegistro.getString("Apellido"));
                registro.setAutores(misRegistro.getString("Registro"));
                break;
            }
            comando.close();

            return registro;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }   
    }
    
    public int updateCrudItem(CrudItem ItemToUpdate) {
        try {
            String SQLUpdate = "UPDATE Crud set NOMBRE=?, APELLIDO=?, REGISTRO=? where ID=?;";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLUpdate);
            
            comando.setString(1, ItemToUpdate.getNombre());
            comando.setString(2, ItemToUpdate.getRegistro());
            comando.setString(3, ItemToUpdate.getApellido());
            comando.setInt(4, ItemToUpdate.getId());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
     public int insertCrudItem(CrudItem ItemToInsert) {
        try {
            String SQLInsert = "INSERT INTO Crud (NOMBRE, REGISTRO, APELLIDO) values (?, ?, ?);";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLInsert);
            
            comando.setString(1, ItemToInsert.getNombre());
            comando.setString(2, ItemToInsert.getRegistro());
            comando.setString(3, ItemToInsert.getApellido());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
     
    public int deleteCrudItem(CrudItem ItemToDelete) {
        try {
            String SQLDelete = "DELETE FROM Crud WHERE ID = ?;";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLDelete);
            
            comando.setInt(1, ItemToDelete.getId());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
}
