/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import java.util.List;
import co.edu.sena.examplejpa.model.Record;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;

/**
 * Fecha: 25/03/2025
 * @author JuanJo
 * Objetivo: Implementar la interface para controlar el metodo Record
 */
public class RecordController implements IRecordController{

    @Override
    public void insert (Record record) throws Exception {
        if (record == null)
        {
            throw new Exception("El registro es obligatorio");
        }
        
        if (record.getId() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
        if (record.getDateRecord() == null)
        {
            throw new Exception("La fecha de registro es obligatoria");
        }
        
        if (record.getStartTime() == null)
        {
            throw new Exception("La hora de inicio del registro es obligatoria");
        }
        
        //FK
        if (record.getEmployeeId() == null)
        {
            throw new Exception("El registro del empleado es obligatorio");
        }
        
        //FK
        if (record.getKeyId() == null)
        {
            throw new Exception("El registro de la llave es obligatorio");
        }
        
        //Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().insert(record);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update (Record record) throws Exception {
        if (record == null)
        {
            throw new Exception("El registro es obligatorio");
        }
        
        if (record.getId() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
        if (record.getDateRecord() == null)
        {
            throw new Exception("La fecha de registro es obligatoria");
        }
        
        if (record.getStartTime() == null)
        {
            throw new Exception("La hora de inicio del registro es obligatoria");
        }
        
        //FK
        if (record.getEmployeeId() == null)
        {
            throw new Exception("El registro del empleado es obligatorio");
        }
        
        //FK
        if (record.getKeyId() == null)
        {
            throw new Exception("El registro de la llave es obligatoria");
        }
        
        //Consultar si el registro existe en la bd
        Record recordExists = DAOFactory.getRecordDAO().findById(record.getId());
        if(recordExists == null)
        {
            throw new Exception("El registro no existe");
        }
        
        //Merge
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().update(recordExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete (Integer id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
         //Consultar si el registro existe en la bd
        Record recordExists = DAOFactory.getRecordDAO().findById(id);
        if (recordExists == null)
        {
            throw new Exception("El registro no existe");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().delete(recordExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List <Record> findAll() throws Exception {
        return DAOFactory.getRecordDAO().findAll();
    }

    @Override
    public Record findById (Integer id) throws Exception {
        if (id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        return DAOFactory.getRecordDAO().findById(id);
    }
}
