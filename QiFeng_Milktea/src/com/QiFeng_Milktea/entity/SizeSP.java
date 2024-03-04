/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.entity;

/**
 *
 * @author Dongduy
 */
public class SizeSP {
    private int maSize;
    private String tenSize;

    public SizeSP() {
    }

    public SizeSP(int maSize, String tenSize) {
        this.maSize = maSize;
        this.tenSize = tenSize;
    }

    public int getMaSize() {
        return maSize;
    }

    public void setMaSize(int maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }
    @Override
    public String toString() {
        return this.tenSize;
    }
}
