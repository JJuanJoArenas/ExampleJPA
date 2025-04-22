/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.test;

import co.edu.sena.examplejpa.controller.EmployeeTypeController;
import co.edu.sena.examplejpa.controller.IEmployeeTypeController;
import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.utils.MessageUtils;
import java.util.List;

/**
 * Fecha: 22/04/2025
 * @author JuanJo
 * Objetivo: Probar el controlador de tipo de empelado
 */
public class TestEmployeeType {
    public void insert ()
    {
        try {
            EmployeeType employeeType = new EmployeeType();
            employeeType.setDescript("NUEVO TIPO");
            
            IEmployeeTypeController controller = new EmployeeTypeController();
            controller.insert(employeeType);
            MessageUtils.showInfoMessage("Tipo de empleado creado exitosamente");
        } 
        catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void update () 
    {
        try {
            EmployeeType employeeType = DAOFactory.getEmployeeTypeDAO().findById(10);
            employeeType.setDescript("NUEVO TIPO ACTUALIZADO");
            
            IEmployeeTypeController controller = new EmployeeTypeController();
            controller.update(employeeType);
            MessageUtils.showInfoMessage("Tipo de empleado modificado exitosamente");
        } 
        catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void delete () 
    {
        try {
            EmployeeType employeeType = DAOFactory.getEmployeeTypeDAO().findById(10);
            
            IEmployeeTypeController controller = new EmployeeTypeController();
            controller.delete(employeeType.getId());
            MessageUtils.showInfoMessage("Tipo de empleado eliminado exitosamente");
        } 
        catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void findAll () 
    {
        try {
            IEmployeeTypeController controller = new EmployeeTypeController();
            List <EmployeeType> types = controller.findAll();
            String messages =  "";
            for (EmployeeType type : types) {
                messages += "Id:" + type.getId() + "Descripcion:" + type.getDescript() + "\n";
            }
            MessageUtils.showInfoMessage(messages);
        } 
        catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        TestEmployeeType test = new TestEmployeeType();
//        test.insert();
//        test.update();
//        test.delete();
        test.findAll();
        
    }
}
