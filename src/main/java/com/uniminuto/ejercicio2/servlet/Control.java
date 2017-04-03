/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.ejercicio2.servlet;

import com.uniminuto.ejercicio2.dao.EmployeeDaoImpl;
import com.uniminuto.ejercicio2.entityEjb.Employee;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jonathan
 */
public class Control extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee();
//        employee.setApellido("FF");
//        employee.setNombre("FFFF");
//        employee.setId(0);
//        employee.setSalario(2000000);
//        Long de = employeeDao.insert(employee);
        request.setAttribute("datosPunto1", " Numero de empleados " + employeeDao.cantidadEmpleados());
        request.setAttribute("datosPunto2", " Maximo Salario " + employeeDao.maximoSalario("el"));
        request.setAttribute("datosPunto3", "Numeros de empleados con salario menor a 100000 = " + employeeDao.buscarSalarioMenor(100000));
        request.setAttribute("datosPunto4", "Suma de salarios de empleados " + employeeDao.sumaSalarios());
        List<Employee> results = employeeDao.buscarSalarioRango(1000, 10000);
        String salarios = "Salarios entre 1000 y 10000 <br>";
        for (int i = 0; i < results.size(); i++) {
            salarios += results.get(i).getNombre() + " " + results.get(i).getApellido() + "   Salario = " + results.get(i).getSalario() + "<hr>";
        }
        request.setAttribute("datosPunto5", salarios);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
