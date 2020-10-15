/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.hibernate.query;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import jdm.hibernate.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class NativeQueryDemo {

    private static Configuration configure;
    private static SessionFactory factory;
    private Session session = null;
    private Transaction tsa = null;

    private static final Logger LOG = Logger.getLogger(NativeQueryDemo.class.getName());

    public static void main(String[] args) {
        configure = new Configuration();
        configure.configure();

        try {
            factory = configure.buildSessionFactory();
        } catch (HibernateException ex) {
            LOG.warning("创建 SessionFactory 对象失败！");
            LOG.warning(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }

        NativeQueryDemo nqd = new NativeQueryDemo();
        nqd.queryDemo();

        factory.close();
    }

    public void queryDemo() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            String querySQL = "select * from employees";

            // 返回数组
            @SuppressWarnings("unchecked")
            NativeQuery<Object[]> nativeQuery1 = session.createSQLQuery(querySQL);

            List<Object[]> list = nativeQuery1.list();
            for (Object[] object : list) {
                LOG.info(Arrays.toString(object));
            }

            // 返回Employee对象
            @SuppressWarnings("unchecked")
            NativeQuery<Employee> nativeQuery2 = session.createSQLQuery(querySQL);

            nativeQuery2.addEntity(Employee.class);
            List<Employee> employees = nativeQuery2.list();
            for (Employee employee : employees) {
                LOG.info(employee.getFirstName());
            }
            tsa.commit();
        } catch (HibernateException e) {
            if (tsa != null) {
                tsa.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
