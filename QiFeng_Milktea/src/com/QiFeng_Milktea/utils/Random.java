/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.utils;

/**
 *
 * @author Dongduy
 */
public class Random {
    public static String ramdom(){
        java.util.Random random = new java.util.Random();
        int randomNumber = random.nextInt(10000);
        return String.format("%4d", randomNumber);
    }
     public static int ramDom;
    public static String soHoaDon(){
        java.util.Random random = new java.util.Random();
        ramDom = random.nextInt(100000000);
        return String.format("%8d", ramDom);
        
    }
}
