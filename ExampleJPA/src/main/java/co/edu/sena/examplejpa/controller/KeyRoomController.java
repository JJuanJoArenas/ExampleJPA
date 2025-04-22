/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import java.util.List;
import co.edu.sena.examplejpa.model.KeyRoom;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;

/**
 * Fchea:25/03/2025
 * @author JuanJo
 * Objetivo: Implementar la interface para controlar el metodo Key
 */
public class KeyRoomController implements IKeyRoomController{

    @Override
    public void insert (KeyRoom keyRoom) throws Exception {
        if (keyRoom == null)
        {
            throw new Exception("La llave es nula");
        }
        
        if (keyRoom.getId() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
        if ("".equals(keyRoom.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if ("".equals(keyRoom.getRoom()))
        {
            throw new Exception("La habitacion es obligaoria");
        }
        
        if (keyRoom.getCount() < 1)
        {
            throw new Exception("La cantidad de llaves es incorrecta");
        }
        
        //Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().insert(keyRoom);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update (KeyRoom keyRoom) throws Exception {
        if (keyRoom == null)
        {
            throw new Exception("La llave es nula");
        }
        
        if (keyRoom.getId() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
        if ("".equals(keyRoom.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if ("".equals(keyRoom.getRoom()))
        {
            throw new Exception("La habitacion es obligaoria");
        }
        
        if (keyRoom.getCount() < 1)
        {
            throw new Exception("La cantidad de llaves es incorrecta");
        }
        
        //Consultar si la llave esta en la bd
        KeyRoom keyRoomExists = DAOFactory.getKeyRoomDAO().findById(keyRoom.getId());
        if (keyRoomExists == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //Merge
        keyRoomExists.setName(keyRoom.getName());
        keyRoomExists.setRoom(keyRoom.getRoom());
        keyRoomExists.setCount(keyRoom.getCount());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().update(keyRoomExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete (Integer id) throws Exception {
        if (id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
         //Consultar si la llave esta en la bd
        KeyRoom keyRoomExists = DAOFactory.getKeyRoomDAO().findById(id);
        if (keyRoomExists == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().delete(keyRoomExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List <KeyRoom> findAll() throws Exception {
        return DAOFactory.getKeyRoomDAO().findAll();
    }

    @Override
    public KeyRoom findById (Integer id) throws Exception {
        if (id == 0)
        {
            throw new Exception("La ID es obligatoria");
        }
        return DAOFactory.getKeyRoomDAO().findById(id);
    }
}
