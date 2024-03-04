/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.dao;

import java.util.List;

/**
 *
 * @author Dongduy
 */
public abstract class QiFeng_MikteaDAO<E, K> {

    public abstract void insert(E entity);

    public abstract void update(E entity);

    public abstract void delete(K id);

    public abstract List<E> selectAll();

    public abstract E SelectbyID(K id);

    public abstract List<E> selectbySql(String sql, Object... args);
}
