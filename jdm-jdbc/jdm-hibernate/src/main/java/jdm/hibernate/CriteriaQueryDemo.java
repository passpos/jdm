package jdm.hibernate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jdm.hibernate.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class CriteriaQueryDemo {

    private static Configuration configure;
    private static SessionFactory factory;
    private Session session = null;
    private Transaction tsa = null;

    public static void main(String[] args) {
        configure = new Configuration();
        configure.configure();

        try {
            factory = configure.buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println("创建 SessionFactory 对象失败！" + ex);
            throw new ExceptionInInitializerError(ex);
        }

        factory.close();
    }

    public void queryDemo() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cq = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> res = cq.from(Employee.class);

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
