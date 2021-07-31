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
public class CriteriaFemale implements CriteriaInterface {

    // 返回一个列表中的所有 女性/Female
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
