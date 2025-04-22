/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.KeyRoom;
import java.util.List;

/**
 * Fecha:25/03/2025
 * @author JuanJo
 * Objetivo: Interface para el metodo KeyRoom
 */
public interface IKeyRoomController {
    public void insert (KeyRoom keyRoom) throws Exception;
    public void update (KeyRoom keyRoom) throws Exception;
    public void delete (Integer id) throws Exception;
    public List <KeyRoom> findAll() throws Exception;
    public KeyRoom findById (Integer id) throws Exception;
}
