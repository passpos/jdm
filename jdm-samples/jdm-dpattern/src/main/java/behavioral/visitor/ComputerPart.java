/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behavioral.visitor;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public interface ComputerPart {

    public void accept(ComputerPartVisitor computerPartVisitor);
}
