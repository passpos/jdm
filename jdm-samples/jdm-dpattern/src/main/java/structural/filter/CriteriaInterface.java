/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.filter;

import java.util.List;

/**
 * 过滤器模式
 *
 * 过滤器模式（Filter Pattern）或标准模式（Criteria Pattern）是一种设计模式，这种模式允许开
 * 发人员使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来。这种类型的设计模式属
 * 于结构型模式，它结合多个标准来获得单一标准。
 *
 * @author passpos <paiap@outlook.com>
 */
public interface CriteriaInterface {

    public List<Person> meetCriteria(List<Person> persons);
}
