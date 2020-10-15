/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.hibernate.mapping;

import java.util.logging.Logger;
import jdm.hibernate.entity.Role;
import jdm.hibernate.entity.User;
import jdm.hibernate.query.NativeQueryDemo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ManyToMany {

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

        ManyToMany mtm = new ManyToMany();
//        mtm.cascadeSaveDemo();
        mtm.cascadeDeleteDemo();
//        mtm.relationUpdateDemo();

        factory.close();
    }

    /**
     * 级联保存
     */
    public void cascadeSaveDemo() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            User user1 = new User();
            user1.setUserName("任我行");
            User user2 = new User();
            user2.setUserName("向问天");

            Role role1 = new Role();
            role1.setRoleName("教主");
            Role role2 = new Role();
            role2.setRoleName("护法");
            Role role3 = new Role();
            role3.setRoleName("教徒");

            user1.getMyRoles().add(role1);
            user2.getMyRoles().add(role2);
            user2.getMyRoles().add(role3);

            session.save(user1);
            session.save(user2);

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
     * 级联删除
     */
    public void cascadeDeleteDemo() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            User user = session.get(User.class, 8);
            session.delete(user);

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
     * 添加关系/解除关系
     */
    public void relationUpdateDemo() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            User user = session.get(User.class, 4);
            Role role = session.get(Role.class, 2);

            user.getMyRoles().add(role);
            role.getUserGroup().add(user);

            session.save(role);
            session.save(user);

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
