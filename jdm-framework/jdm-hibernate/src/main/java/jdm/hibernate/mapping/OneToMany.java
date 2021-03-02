/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.hibernate.mapping;

import java.util.logging.Logger;
import jdm.hibernate.entity.Pet;
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
public class OneToMany {

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

        OneToMany otm = new OneToMany();
        otm.cascadeSaveDemo();
        // otm.cascadeDeleteDemo();
        otm.relationUpdateDemo();

        factory.close();
    }

    /**
     * 级联保存
     */
    public void cascadeSaveDemo() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            // 方式1
            User user1 = new User();
            user1.setUserName("任我行");

            Pet pet1 = new Pet();
            pet1.setPetName("旺财");

            pet1.setMaster(user1);
            user1.getMyPets().add(pet1);

            session.save(user1);
            session.save(pet1);

            // 方式2
            User user2 = new User();
            user2.setUserName("岳不群");

            Pet pet2 = new Pet();
            pet2.setPetName("小强");

            user2.getMyPets().add(pet2);
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

            User user = session.get(User.class, 5);
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
     * 修改操作（添加关联）
     */
    public void relationUpdateDemo() {
        session = factory.openSession();

        try {
            tsa = session.beginTransaction();

            User user = session.get(User.class, 4);
            Pet pet = session.get(Pet.class, 2);

            user.getMyPets().add(pet);
            pet.setMaster(user);

            session.save(pet);
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
