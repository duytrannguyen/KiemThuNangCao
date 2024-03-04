/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.utils;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Dongduy
 */
public class MsgBox {
     public static void alert(Component parent,String messsage){
        JOptionPane.showMessageDialog(parent, messsage,
                "Hệ thống quản lý ",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void warring(Component parent, String message) {
        ImageIcon icon = new ImageIcon("src\\com\\raven\\icon\\remove.png");
        JOptionPane.showMessageDialog(parent, message, "QiFeng_Milktea", JOptionPane.ERROR_MESSAGE);
    }
    public static boolean cobfirm(Component parent,String message){
        int result = JOptionPane.showConfirmDialog(parent, message,"Hệ thống quản lý ",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    public static String promt(Component parent, String message){
        return JOptionPane.showInputDialog(parent,message,"Hệ thống quản lý",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static void labelAlert(JLabel lbl, JTextField txtField, String message) {
        lbl.setText(message);
    }
     public static void labelAlertTextArea(JLabel lbl, JTextArea txtString, String mess) {
        lbl.setText(mess);
    }
    
}
