/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpattern;

import behavioral.chain.AbstractLogger;
import behavioral.chain.ConsoleLogger;
import behavioral.chain.ErrorLogger;
import behavioral.chain.FileLogger;
import behavioral.command.Broker;
import behavioral.command.BuyStock;
import behavioral.command.SellStock;
import behavioral.command.Stock;
import behavioral.interpreter.AndExpression;
import behavioral.interpreter.Expression;
import behavioral.interpreter.OrExpression;
import behavioral.interpreter.TerminalExpression;
import behavioral.iterator.Iterator;
import behavioral.iterator.NameRepository;
import behavioral.mediator.User;
import behavioral.memento.CareTaker;
import behavioral.memento.Originator;
import behavioral.nullobj.AbstractCustomer;
import behavioral.nullobj.CustomerFactory;
import behavioral.observer.BinaryObserver;
import behavioral.observer.HexaObserver;
import behavioral.observer.OctalObserver;
import behavioral.observer.Subject;
import behavioral.state.Context;
import behavioral.state.StartState;
import behavioral.state.StopState;
import behavioral.strategy.OperationAdd;
import behavioral.strategy.OperationMultiply;
import behavioral.strategy.OperationSubtract;
import behavioral.template.Cricket;
import behavioral.template.Football;
import behavioral.template.Game;
import behavioral.visitor.Computer;
import behavioral.visitor.ComputerPart;
import behavioral.visitor.ComputerPartDisplayVisitor;
import org.junit.jupiter.api.Test;

/**
 * 行为型模式
 *
 * 这些设计模式特别关注对象之间的通信。
 *
 * 模板模式
 * 观察者模式
 * 状态模式
 * 责任链模式
 *
 * @author passpos <paiap@outlook.com>
 */
public class BehavioralPatternTest {

    /* -------------------------------------------------------------------------
     * 行为型
     * ---------------------------------------------------------------------- */
    // 责任链模式
    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    // 责任链模式
    @Test
    public void testChain() {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }

    // 命令模式
    @Test
    public void testCommand() {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }

    // 解释器模式
    //规则：Robert 和 John 是男性
    public Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    // 解释器模式
    //规则：Julie 是一个已婚的女性
    public Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    // 解释器模式
    @Test
    public void testInterpreter() {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? "
                + isMarriedWoman.interpret("Married Julie"));
    }

    // 迭代器模式
    @Test
    public void testIterator() {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }

    // 中介者模式
    @Test
    public void testMediator() {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }

    // 备忘录模式
    @Test
    public void testMemento() {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }

    // 观察者模式
    @Test
    public void testObserver() {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }

    // 状态模式
    @Test
    public void testState() {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }

    // 空对象模式
    @Test
    public void testNullObj() {
        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

        System.out.println("Customers");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }

    // 策略模式
    @Test
    public void testStrategy() {
        behavioral.strategy.Context context = new behavioral.strategy.Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new behavioral.strategy.Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new behavioral.strategy.Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }

    // 模板模式
    @Test
    public void testTemplate() {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }

    // 访问者模式
    @Test
    public void testVisitor() {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
