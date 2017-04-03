/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.ejercicio2.dao;

import com.uniminuto.ejercicio2.entityEjb.Employee;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jonathan
 */
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Long insert(Employee employee) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        Long servicioID = 4156465l;
        try {
            tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return servicioID;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long cantidadEmpleados() {
        long count;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria cr = session.createCriteria(Employee.class);
        count = (Long) cr.setProjection(Projections.rowCount()).uniqueResult();
        return count;
    }

    public long buscarSalarioMenor(int salario) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria cr = session.createCriteria(Employee.class);
        cr.add(Restrictions.lt("salario", salario));
        List results = cr.list();
        return results.size();
    }

    public int sumaSalarios() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria cr = session.createCriteria(Employee.class);
        cr.setProjection(Projections.sum("salario"));
        List totalSalary = cr.list();
        int suma = totalSalary.get(0).hashCode();
        return suma;
    }

    public List<Employee> buscarSalarioRango(int menor, int mayor) {
        List<Employee> results = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria cr = session.createCriteria(Employee.class);
        //Trae entre 1 a 8 como maximo de registros
        cr.setFirstResult(1);
        cr.setMaxResults(8);
        cr.add(Restrictions.between("salario", menor, mayor));
        return results = cr.list();
    }

    public int maximoSalario(String palabra) {
        long count;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria cr = session.createCriteria(Employee.class);
        cr.add(Restrictions.like("nombre", "%" + palabra + "%"));
        cr.setProjection(Projections.max("salario"));
        return cr.list().get(0).hashCode();
    }

}
