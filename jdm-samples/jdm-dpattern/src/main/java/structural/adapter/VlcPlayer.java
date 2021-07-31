/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.adapter;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class VlcPlayer implements VideoInterface {

    @Override
    public void playVlc(String fileName) {
        System.out.println("播放VLC文件. 文件名: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // do noting.
    }

}
