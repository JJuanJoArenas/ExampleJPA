/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Aprendiz
 */
public class MessageUtils {
    public static void showInfoMessage (String message){
        JOptionPane.showMessageDialog(null, message, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    
     public static void showWarningMessage (String message){
        JOptionPane.showMessageDialog(null, message, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
    }
     
      public static void showErrorMessage (String message){
        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }
}
