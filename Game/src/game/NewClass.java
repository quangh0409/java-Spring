/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author vutro
 */
public class NewClass {

    /**
     * @see https://stackoverflow.com/a/11058263/230513
     */
    private Timer timer = new Timer();
    private JLabel timeLabel = new JLabel(" ", JLabel.CENTER);

    public NewClass() {
        JFrame f = new JFrame("Seconds");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(timeLabel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        timer.schedule(new UpdateUITask(), 0, 1000);
    }

    private class UpdateUITask extends TimerTask {

        int nSeconds = 0;

        @Override
        public void run() {
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    timeLabel.setText(String.valueOf(nSeconds++));
                }
            });
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                final NewClass clock = new NewClass();
            }
        });
    }

}
