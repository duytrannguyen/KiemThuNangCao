/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.entity;

/**
 *
 * @author Dongduy
 */
public class MyComBoBox {
    Object value;//Chứa mã
    Object text;//Chứa tên mã loại

    public MyComBoBox(Object value, Object text) {
        this.value = value;
        this.text = text;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getText() {
        return text;
    }

    public void setText(Object text) {
        this.text = text;
    }
    @Override
    public String toString(){
        return text.toString();
    }
    //hàm lấy mã value kiểu int
    public int MaInt(){
        return Integer.parseInt(value.toString());
    }
    //hàm lấy value kiểu string
    public String MaString(){
        return value.toString();
    }
}
