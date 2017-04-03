/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.ejercicio2.dao;

import com.uniminuto.ejercicio2.entityEjb.Employee;

/**
 *
 * @author Jonathan
 */
public interface EmployeeDao {

    Long insert(Employee employee);

    boolean delete(int id);

    long cantidadEmpleados();
}
