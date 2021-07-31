/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class CriteriaSingle implements CriteriaInterface {

    // 返回一个列表中的所有 单身/Single
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }

}
