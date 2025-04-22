/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.test;

import co.edu.sena.examplejpa.controller.EmployeeController;
import co.edu.sena.examplejpa.controller.EmployeeTypeController;
import co.edu.sena.examplejpa.controller.IEmployeeController;
import co.edu.sena.examplejpa.controller.IEmployeeTypeController;
import co.edu.sena.examplejpa.model.Employee;
import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.utils.MessageUtils;
import java.util.List;

/**
 * Fecha: .22/04/2025
 * @author JuanJo
 * Objetivo: Probar el controlador de empleado
 */
public class TestEmployee {
    
    public void insert () 
    {
        try {
            Employee employee = new Employee(1120L, "ZOILA KELAVA", "Trv 12", "223");
            IEmployeeTypeController typeController = new EmployeeTypeController();
            EmployeeType type = typeController.findById(1);
            employee.setTypeId(type); //FK
            IEmployeeController controller = new EmployeeController();
            controller.insert(employee);
            MessageUtils.showInfoMessage("Empleado creado exitosamente");
        }
        catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void udpate () 
    {
        try {
            Employee employee = new Employee(1120L, "ALBERTO CATESTA", "Trv 13", "316");
            IEmployeeTypeController typeController = new EmployeeTypeController();
            EmployeeType type = typeController.findById(1);
            employee.setTypeId(type); //FK
            IEmployeeController controller = new EmployeeController();
            controller.update(employee);
            MessageUtils.showInfoMessage("Empleado modificado exitosamente");
        }
        catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void delete ()
    {
        try {
            IEmployeeController controller = new EmployeeController();
            Employee employee = controller.findById(1120L);
            controller.delete(employee.getDocument());
            MessageUtils.showInfoMessage("Empleado eliminado exitosamente");
        }
        catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void findAll () 
    {
        try {
            IEmployeeController controller = new EmployeeController();
            List <Employee> employees = controller.findAll();
            String messages =  "";
            for (Employee e : employees) {
                messages += "Documento:" + e.getDocument() + " Nombre: " + e.getFullname() + 
                                      " Direccion: " + e.getDireccion() + " Telefono:" + e.getTelefono() + 
                                      " Tipo: " + e.getTypeId().getDescript() + "\n";
            }
            MessageUtils.showInfoMessage(messages);
        } 
        catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        TestEmployee test = new TestEmployee();
//        test.insert();
//        test.udpate();
//        test.delete();
        test.findAll();
    }
}
