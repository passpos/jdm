/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpattern;

import j2ee.business.BusinessDelegate;
import j2ee.business.Client;
import j2ee.dao.StudentDao;
import j2ee.dao.StudentDaoImpl;
import j2ee.frontctrler.FrontController;
import j2ee.interceptfilter.AuthenticationFilter;
import j2ee.interceptfilter.DebugFilter;
import j2ee.interceptfilter.FilterManager;
import j2ee.interceptfilter.Target;
import j2ee.mvc.Student;
import j2ee.mvc.StudentController;
import j2ee.mvc.StudentView;
import j2ee.srvlocator.Service;
import j2ee.srvlocator.ServiceLocator;
import j2ee.transferobj.StudentBO;
import j2ee.transferobj.StudentVO;
import org.junit.jupiter.api.Test;

/**
 * J2EE 模式
 *
 * 这些设计模式特别关注表示层。这些模式是由 Sun Java Center 鉴定的。
 *
 * MVC 模式（MVC Pattern）
 * 业务代表模式（Business Delegate Pattern）
 * 组合实体模式（Composite Entity Pattern）
 * 数据访问对象模式（Data Access Object Pattern）
 * 前端控制器模式（Front Controller Pattern）
 * 拦截过滤器模式（Intercepting Filter Pattern）
 * 服务定位器模式（Service Locator Pattern）
 * 传输对象模式（Transfer Object Pattern）
 *
 * @author passpos <paiap@outlook.com>
 */
public class J2EEPatternTest {

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }

    // MVC模式
    @Test
    public void testMVC() {
        //从数据库获取学生记录
        Student model = retrieveStudentFromDatabase();

        //创建一个视图：把学生详细信息输出到控制台
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        //更新模型数据
        controller.setStudentName("John");

        controller.updateView();
    }

    // 业务代表模式
    @Test
    public void testBussinessDelegate() {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setServiceType("EJB");

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType("JMS");
        client.doTask();
    }

    // 组合实体模式
    @Test
    public void testCompositeEntity() {
        j2ee.composite.Client client = new j2ee.composite.Client();
        client.setData("Test", "Data");
        client.printData();
        client.setData("Second Test", "Data1");
        client.printData();
    }

    // DAO模式
    @Test
    public void testDAO() {
        StudentDao studentDao = new StudentDaoImpl();

        //输出所有的学生
        for (j2ee.dao.Student student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : "
                    + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }

        //更新学生
        j2ee.dao.Student student = studentDao.getAllStudents().get(0);
        student.setName("Michael");
        studentDao.updateStudent(student);

        //获取学生
        studentDao.getStudent(0);
        System.out.println("Student: [RollNo : "
                + student.getRollNo() + ", Name : " + student.getName() + " ]");
    }

    // 前端控制器模式
    @Test
    public void testFrontController() {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
    }

    // 拦截过滤器模式
    @Test
    public void testInterceptingFilter() {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());

        j2ee.interceptfilter.Client client = new j2ee.interceptfilter.Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }

    // 服务定位器模式
    @Test
    public void testServiceLocator() {
        Service service = ServiceLocator.getService("Service1");
        service.execute();
        service = ServiceLocator.getService("Service2");
        service.execute();
        service = ServiceLocator.getService("Service1");
        service.execute();
        service = ServiceLocator.getService("Service2");
        service.execute();
    }

    // 传输对象模式
    @Test
    public void testTransferObject() {
        StudentBO studentBusinessObject = new StudentBO();

        //输出所有的学生
        for (StudentVO student : studentBusinessObject.getAllStudents()) {
            System.out.println("Student: [RollNo : "
                    + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }

        //更新学生
        StudentVO student = studentBusinessObject.getAllStudents().get(0);
        student.setName("Michael");
        studentBusinessObject.updateStudent(student);

        //获取学生
        studentBusinessObject.getStudent(0);
        System.out.println("Student: [RollNo : "
                + student.getRollNo() + ", Name : " + student.getName() + " ]");
    }
}
