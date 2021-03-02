/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.hibernate;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
import java.util.List;
import jdm.hibernate.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ManageEmployee {

    private static Configuration configure;
    private static SessionFactory factory;

    public static void main(String[] args) {
        configure = new Configuration();
        configure.configure();

        try {
            // factory = configure.buildSessionFactory();

            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println("创建 SessionFactory 对象失败！" + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManageEmployee ME = new ManageEmployee();
        /* 添加 employee 记录到数据库中 */
        Integer empID1 = ME.addEmployee(18, "Zara", "Ali", 1000);
        Integer empID2 = ME.addEmployee(28, "Daisy", "Das", 5000);
        Integer empID3 = ME.addEmployee(34, "John", "Paul", 10000);

        /* List down all the employees */
        ME.listEmployees();

        /* Update employee's records */
        ME.updateEmployee(empID1, 5000);

        /* Delete an employee from the database */
        ME.deleteEmployee(empID2);

        /* List down new list of the employees */
        ME.listEmployees();

        factory.close();
    }

    /* CREATE */
    public Integer addEmployee(int age, String fname, String lname, int salary) {
        Session session = factory.openSession();
        Transaction tsa = null;

        Integer employeeID = null;
        try {
            tsa = session.beginTransaction();

            Employee employee = new Employee(age, fname, lname, salary);

            // save()（可以新建记录，而不是在已删除记录的id上创建）
            employeeID = (Integer) session.save(employee);

            tsa.commit();
        } catch (HibernateException e) {
            if (tsa != null) {
                tsa.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    /* READ */
    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tsa = null;

        try {
            tsa = session.beginTransaction();

            // 获取单条记录——get()
            session.get(Employee.class, 101);

            // 创建Query实例——createQuery()
            @SuppressWarnings("unchecked")
            Query<Employee> createQuery = session.createQuery("FROM Employee", Employee.class);

            // 获取所有记录——list()
            List<Employee> employees = createQuery.list();
            for (Employee employee : employees) {
                System.out.print("Age: " + employee.getAge());
                System.out.print("  First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
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

    /* UPDATE */
    public void updateEmployee(Integer EmployeeID, int salary) {
        Session session = factory.openSession();
        Transaction tsa = null;

        try {
            tsa = session.beginTransaction();

            Employee employee = session.get(Employee.class, EmployeeID);
            employee.setSalary(salary);

            // update()（如果曾经删除过某条记录，通过update()更新某条记录的id为已删除的id，这会产生问题，所以要留意）
            session.update(employee);

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

    /* DELETE */
    public void deleteEmployee(Integer EmployeeID) {
        Session session = factory.openSession();
        Transaction tsa = null;

        try {
            tsa = session.beginTransaction();

            Employee employee = session.get(Employee.class, EmployeeID);

            // delete()
            session.delete(employee);

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

    public static <T> void ol(T arg) {
        System.out.println(arg);
    }
}
