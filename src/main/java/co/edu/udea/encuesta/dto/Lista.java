/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dto;

import java.io.Serializable;

/**
 *
 * @author Jonathan
 */
public class Lista implements Serializable{
    private int numero;
    private int lista;
    private int item_lista;
    private String item_lista_texto;

    public Lista() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }

    public int getItem_lista() {
        return item_lista;
    }

    public void setItem_lista(int item_lista) {
        this.item_lista = item_lista;
    }

    public String getItem_lista_texto() {
        return item_lista_texto;
    }

    public void setItem_lista_texto(String item_lista_texto) {
        this.item_lista_texto = item_lista_texto;
    }
    
    
}
