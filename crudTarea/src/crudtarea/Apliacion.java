/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudtarea;

import crudtarea.utilities.Layout;

import java.util.Scanner;
import java.util.ArrayList;


/**
 *
 * @author Usuario
 */
public class Apliacion {
    
    private Scanner _EntradaTeclado;
    private ArrayList _MiCrud;
    private int _MiCrudIdCounter;
    private CrudDB _CrudModel;
    public Aplicacion(Scanner EntradaTeclado) {
        this._EntradaTeclado = EntradaTeclado;
        this._MiCrud = new ArrayList<CrudItem>();  
        this._MiCrudIdCounter = 0;
        this._CrudModel = new   CrudDB();
        this._CrudModel.tableInitialize();
        this._MiCrud = this._CrudModel.getMusicItems(true);
    }
    
    public void activarEvento(String opcionMenu){
        switch(opcionMenu.toUpperCase()){
            case "M":
                this.mostrarRegistros();
                break;
            case "I":
                this.ingresarNuevoRegistro();
                break;
            case "A":
                this.actualizarRegistro();
                break;
            case "E":   
                this.eliminarRegistro();
                break;
            case "S":
                break;
            default:
                System.out.println("Opción no reconocida!!!");
                break;
        }
    }
    
    private void ingresarNuevoRegistro(){
        Layout.printHeader("Nuevo Registro de Crud");
        CrudItem nuevoMusicItem =  new CrudItem();
        nuevoCrudItem.setNombre(Layout.obtenerValorParaCampo("Nombre de la tabla", "Tabla AAA", this._EntradaTeclado));
        nuevoCrudItem.setNombre2(Layout.obtenerValorParaCampo("Nombre ", "Nombre X", this._EntradaTeclado));
        nuevoCrudItem.setApellido(Layout.obtenerValorParaCampo("Apellido", "Apellido Y", this._EntradaTeclado));
        
        
        this._CrudModel.insertCrudItem(nuevoCrudItem);
        this._MiCrud = this._CrudModel.getCrudItems(true);
        
        Layout.printSeparator();
        System.out.println(this._MiCrud.size());
    }
    
    private void mostrarRegistros(){
        Layout.printSeparator();
        ArrayList<String> columnas = new ArrayList<String>();
        columnas.add("Codigo");
        columnas.add("Nombre");
        columnas.add("Apellido");
        columnas.add("telefono");
        columnas.add("fecha");
        
        ArrayList<Integer> anchos = new ArrayList<Integer>();
        anchos.add(15);
        anchos.add(48);
        anchos.add(48);
        anchos.add(50);
        anchos.add(50);
        
        
     
        try {
           
            Layout.imprimirEnColumna(columnas, anchos, "|");
            Layout.printSeparator();
            for(int i = 0; i< this._MiCrud.size(); i++){
                columnas = ((CrudItem) this._MiCrud.get(i)).obtenerCampos();
                Layout.imprimirEnColumna(columnas, anchos, "|");
            }
            
        } catch(Exception ex) {
            System.err.println("Error al imprimir " + ex.getMessage());
        }
    }
    
    private void actualizarRegistro(){
        Layout.printHeader("Actualizar Registro");
        int selectedId = Integer.valueOf(Layout.obtenerValorParaCampo("Ingrese Codigo Registro", "0", this._EntradaTeclado));
        CrudItem selectMusic = null;

        
        //--------------------------------------------------------------
        selectMusic = this._CrudModel.getMusicItemById(selectedId);
        if (selectMusic == null ) {
            System.out.println("Registro solicitado no existe!!!");
        } else {
            selectCrud.setNombre(Layout.obtenerValorParaCampo("Nombre ", selectMusic.getNombre(), this._EntradaTeclado));
            selectCrud.setApellido(Layout.obtenerValorParaCampo("Apellido", selectMusic.getAutores(), this._EntradaTeclado));
            selectCrud.settelefono(Layout.obtenerValorParaCampo("telefono", selectMusic.getAlbum(), this._EntradaTeclado));
            int anio = Integer.parseInt(Layout.obtenerValorParaCampo("Año de nacimiento yyyy", "2020", this._EntradaTeclado));
            int mes = Integer.parseInt(Layout.obtenerValorParaCampo("Mes de nacimiento 1-12", "1", this._EntradaTeclado));
            int dia = Integer.parseInt(Layout.obtenerValorParaCampo("Día de nacimiento 1-31", "1", this._EntradaTeclado));
            
            
            this._CrudModel.updateMusicItem(selectMusic);
            this._MiCrud = this._CrudModel.getMusicItems(true);
            Layout.printSeparator();
            System.out.println("Registro Actualizado Satisfactoriamente!!!");
        }
        
    }
    
    private void eliminarRegistro(){
        Layout.printHeader("Eliminar Registro");
        int selectedId = Integer.valueOf(Layout.obtenerValorParaCampo("Ingrese Codigo Registro", "0", this._EntradaTeclado));

        
        
        CrudItem selectedMusic = this._CrudModel.getMusicItemById(selectedId);
        if (selectedCrud != null){
            Layout.printSeparator();
            String confirmado = Layout.obtenerValorParaCampo("¿Desea Eliminar este Registro? S - N", "N", this._EntradaTeclado);
            if (confirmado.toUpperCase().equals("S")){
                //this._MiMusica.remove(encontradoEnIndice);
                this._CrudModel.deleteMusicItem(selectedCrud);
                 this._MiCrud = this._CrudModel.getCrudItems(true);
                Layout.printSeparator();
                System.out.println("Registro Eliminado Satisfactoriamente!!!");
            }
        } else {
            System.out.println("Registro solicitado no existe!!!");
        }
    
    }
    
}
