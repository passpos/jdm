/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.hibernate.query;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import jdm.hibernate.entity.Employee;
import jdm.hibernate.entity.Pet;
import jdm.hibernate.entity.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class QueryDemo {

    private static Configuration configure;
    private static SessionFactory factory;
    private Session session = null;
    private Transaction tsa = null;
    private static final Logger logger = Logger.getLogger(QueryDemo.class.getName());

    public static void main(String[] args) {
        configure = new Configuration();
        configure.configure();

        try {
            factory = configure.buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println("创建 SessionFactory 对象失败！" + ex);
            throw new ExceptionInInitializerError(ex);
        }

        QueryDemo qd = new QueryDemo();
//        qd.queryDemo();
//        qd.method1();
//        qd.method2();
//        qd.method3();
//        qd.method4();
        qd.method5();

        factory.close();
    }

    public void queryDemo() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            @SuppressWarnings("unchecked")
            Query<Employee> createQuery = session.createQuery("FROM Employee", Employee.class);

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

    /**
     * OID查询
     */
    public void method1() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            User user = session.get(User.class, 4);

            logger.info(user.getUserName());

            tsa.commit();
        } catch (HibernateException e) {
            if (tsa != null) {
                tsa.rollback();
            }
            logger.info(e.getMessage());
        } finally {
            session.close();
        }
    }

    /**
     * 对象导航查询
     */
    public void method2() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            User user = session.get(User.class, 4);
            Set<Pet> myPets = user.getMyPets();

            logger.info(String.valueOf(myPets.size()));

            tsa.commit();
        } catch (HibernateException e) {
            if (tsa != null) {
                tsa.rollback();
            }
            logger.info(e.getMessage());
        } finally {
            session.close();
        }
    }

    /**
     * HQL查询
     * "FROM User"——“User”指的是实体类的名字（区分大小写），但“FROM”不区分大小写。
     */
    public void method3() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            Query<User> query1 = session.createQuery("FROM User", User.class);
            // 获取结果集并遍历
            List<User> list = query1.list();
            for (User user : list) {
                logger.info(user.getUserName());
            }

            /* 条件查询
             * setParameter(0, 1)——第n个（从0开始）参数，及其值；
             * id=? —— 此方式已遭废弃，使用 id=?n （JPA规范）代替
             */
            // Query<User> query2 = session.createQuery("FROM User AS u WHERE u.id=9", User.class);
            // Query<User> query2 = session.createQuery("FROM User WHERE id=? AND userName=?", User.class);
            Query<User> query2 = session.createQuery("FROM User WHERE id=?0 AND userName=?1", User.class);
            System.out.println("条件查询：");
            query2.setParameter(0, 1);
            query2.setParameter(1, "任我行");
            for (User user : query2.list()) {
                logger.info(user.getUserName());
            }

            // 模糊查询
            Query<User> query3 = session.createQuery("FROM User WHERE userName LIKE ?0", User.class);
            System.out.println("模糊查询：");
            query3.setParameter(0, "%天%");
            for (User user : query3.list()) {
                logger.info(user.getUserName());
            }

            /* 排序查询
             * ASC 正序
             * DESC 逆序
             */
            Query<User> query4 = session.createQuery("FROM User ORDER BY userName ASC", User.class);
            System.out.println("排序查询：");
            for (User user : query4.list()) {
                logger.info(user.getUserName());
            }

            /* 分页查询
             * 开始位置/每页记录数
             */
            Query<User> query5 = session.createQuery("FROM User", User.class);
            query5.setFirstResult(0);
            query5.setMaxResults(3);
            System.out.println("分页查询：");
            for (User user : query5.list()) {
                logger.info(user.getUserName());
            }

            /* 投影查询——查询表中部分字段的值
             */
            @SuppressWarnings("unchecked")
            Query<Object> query6 = session.createQuery("SELECT userName FROM User");

            System.out.println("投影查询：");
            for (Object o : query6.list()) {
                logger.info(o.toString());
            }


            /* 聚合函数
             * count、sum、avg、max、min
             */
            Query<Long> query7 = session.createQuery("SELECT count(*) FROM User");

            System.out.println("聚合函数：");
            long num = query7.uniqueResult();
            logger.info(String.valueOf(num));

            tsa.commit();
        } catch (HibernateException e) {
            if (tsa != null) {
                tsa.rollback();
            }
            logger.info(e.getMessage());
        } finally {
            session.close();
        }
    }

    /**
     * QBC查询（已废弃）
     */
    public void method4() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            Criteria query1 = session.createCriteria(User.class);

            tsa.commit();
        } catch (HibernateException e) {
            if (tsa != null) {
                tsa.rollback();
            }
            logger.info(e.getMessage());
        } finally {
            session.close();
        }
    }

    /**
     * HQL多表查询
     *
     * SELECT * FROM users u,pets p WHERE u.id=p.master_id;
     * SELECT * FROM users u INNER JOIN pets p ON u.id=p.master_id;
     * SELECT * FROM users u LEFT OUTER JOIN pets p ON u.id=p.master_id;
     * SELECT * FROM users u RIGHT OUTER JOIN pets p ON u.id=p.master_id;
     */
    public void method5() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            /* 内连接查询
             *
             * 返回包含两种对象的数组，结构为：
             * [Class1.obj1, Class2.obj1],
             * [Class1.obj2, Class2.obj2]
             * 其中Class1与Class2相互关联
             */
            @SuppressWarnings("unchecked")
            Query<Object[]> query1 = session.createQuery("FROM User u INNER JOIN u.myPets");
            List<Object[]> list1 = query1.list();
            System.out.println("内连接查询");
            for (Object[] os : list1) {
                System.out.println(Arrays.toString(os));
                System.out.println(os[0].toString());
                System.out.println(os[1].toString());
            }

            // 迫切内连接查询（返回对象）
            @SuppressWarnings("unchecked")
            Query<User> query2 = session.createQuery("FROM User u INNER JOIN FETCH u.myPets");
            List<User> list2 = query2.list();
            System.out.println("迫切内连接查询");
            for (User u : list2) {
                System.out.println(u.getUserName());
            }

            // 左外连接查询（返回包含两种对象的数组）
            @SuppressWarnings("unchecked")
            Query<Object[]> query3 = session.createQuery("FROM User u LEFT OUTER JOIN u.myPets");
            List<Object[]> list3 = query3.list();
            System.out.println("左外连接查询");
            for (Object[] os : list3) {
                System.out.println(Arrays.toString(os));
                System.out.println(os[0].toString());
                System.out.println(os[1].toString());
            }

            // 迫切左外连接查询（返回对象）
            @SuppressWarnings("unchecked")
            Query<User> query4 = session.createQuery("FROM User u LEFT OUTER JOIN FETCH u.myPets");
            List<User> list4 = query4.list();
            System.out.println("迫切左外连接查询");
            for (User u : list4) {
                System.out.println(u.getUserName());
            }

            // 右外连接查询
            @SuppressWarnings("unchecked")
            Query<Object[]> query5 = session.createQuery("FROM User u LEFT OUTER JOIN FETCH u.myPets");
            List<Object[]> list5 = query5.list();
            System.out.println("右外连接查询");
            for (Object[] os : list3) {
                System.out.println(Arrays.toString(os));
                System.out.println(os[0].toString());
                System.out.println(os[1].toString());
            }

            tsa.commit();
        } catch (HibernateException e) {
            if (tsa != null) {
                tsa.rollback();
            }
            logger.info(e.getMessage());
        } finally {
            session.close();
        }
    }

}
