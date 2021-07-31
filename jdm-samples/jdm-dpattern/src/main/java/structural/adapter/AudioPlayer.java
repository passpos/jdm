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
public class AudioPlayer implements AudioInterface {

    // 内含适配器，从而支持适配器中提供的视频播放功能；
    private MediaAdapter adapter;

    @Override
    public void play(String audioType, String fileName) {
        //播放 mp3 音乐文件的内置支持
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("播放 mp3 文件. 文件名: " + fileName);

        } // adapter 提供了播放其他文件格式的支持
        else if (audioType.equalsIgnoreCase("vlc")
                || audioType.equalsIgnoreCase("mp4")) {
            adapter = new MediaAdapter(audioType);
            adapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. 不支持 " + audioType + " 格式！");
        }
    }
}
