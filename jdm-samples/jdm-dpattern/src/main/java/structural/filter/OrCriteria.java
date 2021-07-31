/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structural.filter;

import java.util.List;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class OrCriteria implements CriteriaInterface {

    private CriteriaInterface cr1;
    private CriteriaInterface cr2;

    public OrCriteria(CriteriaInterface c1, CriteriaInterface c2) {
        this.cr1 = c1;
        this.cr2 = c2;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> ps1 = cr1.meetCriteria(persons);
        List<Person> ps2 = cr2.meetCriteria(persons);

        // 取并集
        for (Person p : ps2) {
            if (!ps1.contains(p)) {
                ps1.add(p);
            }
        }
        return ps1;
    }

}
