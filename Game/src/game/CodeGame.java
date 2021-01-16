/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.BorderUIResource;

/**
 *
 * @author vutro
 */
public class CodeGame extends javax.swing.JFrame implements KeyListener {

    /**
     * Creates new form CodeGame
     */
    private CardLayout cl = new CardLayout();
    private int Screensize = 500;
    private int chessSize = 25;
    private int P_x, P_y, end_x, end_y;
    static ArrayList<Integer> E_x = new ArrayList<>();
    static ArrayList<Integer> E_y = new ArrayList<>();
    static ArrayList<Integer> a = new ArrayList<>();
    static ArrayList<Integer> b = new ArrayList<>();
    static ArrayList<JPanel> enemyJPanel = new ArrayList<>();
    JPanel player = new JPanel();
    private int acount;
    private Timer timer = new Timer();

    public int getAcount() {
        return acount;
    }

    public void setAcount(int acount) {
        this.acount = acount;
    }

    public CodeGame() {
        initComponents();
//        cl = (CardLayout) (jPanel3.getLayout());
//        jPanel3.setLayout(cl);
//        jPanel3.add("view1", jPanel1);
//        jPanel3.add("view2", jPanel2);
//        cl.show(jPanel3, "view2");
//        jButton1.addActionListener((ae) -> {
//            if (jTextField1.getText() == "") {
//                jTextField1.setBorder(BorderUIResource.getBlackLineBorderUIResource());
//            }
//            if (jTextField2.getText() == "") {
//                jTextField2.setBorder(BorderUIResource.getBlackLineBorderUIResource());
//            } else {
        setAcount(10);
//                cl.removeLayoutComponent(jPanel2);
//                cl.show(jPanel3, "view1");
//        this.add(Clock);
        this.Clock1();
        this.CreatePlayer();
        this.CreateTaget();
        this.CreateEnemy();
        map();
        this.addKeyListener(this);
        switch (checkStatus()) {
            case 0:
                removeKeyListener(this);
                JOptionPane.showMessageDialog(rootPane, "LOSE");
                break;
            case 1:
                removeKeyListener(this);
                JOptionPane.showMessageDialog(rootPane, "WIN");
                break;
            case 2:
                break;

        }

    }

//        });
//    }
    public void map() {
        ImageIcon icon;
        icon = new ImageIcon("image/map1.png");
        JLabel background = new JLabel(icon);
        background.setBounds(0, 0, 500, 500);
        jPanel1.add(background);
    }

    public Boolean check(int a, ArrayList<Integer> al) {
        Boolean h = false;
        if (al.size() == 0) {
            h = false;
        } else {
            for (int i = 0; i < al.size(); i++) {
                if (a == al.get(i)) {
                    h = true;

                } else {
                    h = false;

                }
                if (a == al.get(i) + 1) {
                    h = true;

                }
                if (a == al.get(i) - 1) {
                    h = true;

                }
            }
        }
        return h;
    }

    public void CreateEnemy() {
        Random rd = new Random();

        for (int i = 0; i < getAcount(); i++) {
            JPanel jp = new JPanel();
            do {
                a.add(rd.nextInt(20));
                b.add(rd.nextInt(20));
                System.out.println(a.get(i) + "   " + b.get(i));
                System.out.println(check(a.get(i), a) + "  " + check(b.get(i), b));
            } while (check(a.get(i), a) && check(b.get(i), b));
            E_x.add((a.get(i)) * chessSize);
            E_y.add((b.get(i)) * chessSize);
            ImageIcon icon;
            icon = new ImageIcon("image/police.png");
            JLabel background = new JLabel(icon);
            background.setBounds(0, 0, 25, 25);
            jp.add(background);
            jp.setSize(chessSize, chessSize);
            jp.setLocation(E_x.get(i), E_y.get(i));
            jp.setBackground(Color.yellow);
            enemyJPanel.add(jp);
            jPanel1.add(enemyJPanel.get(i));
        }

    }

    public void CreatePlayer() {
        Random rd = new Random();

        int x, y;
        do {
            x = rd.nextInt(19);
            y = rd.nextInt(19);
            System.out.println(x + "  " + y);
            System.out.println(check(x, a) + "  " + check(y, b));
        } while (check(x, a) && check(y, b));
        P_x = x * chessSize;
        P_y = y * chessSize;
        ImageIcon icon;
        icon = new ImageIcon("image/thief.png");
        JLabel background = new JLabel(icon);
        background.setBounds(0, 0, 25, 25);
        player.add(background);
        System.out.println(P_x + " " + P_y);
        player.setSize(chessSize, chessSize);

        player.setBackground(Color.RED);
        player.setLocation(P_x, P_y);
        jPanel1.add(player);
    }

    public void CreateTaget() {
        Random rd = new Random();
        JPanel jp = new JPanel();
        int x, y;
        do {
            x = rd.nextInt(19);
            y = rd.nextInt(19);
            System.out.println(x + " " + y);
        } while (check(end_x, a) && check(end_y, b) && (x * chessSize) == P_x && (y * chessSize) == P_y);
        end_x = (x) * chessSize;
        end_y = (y) * chessSize;
        ImageIcon icon;
        icon = new ImageIcon("image/treasure.png");
        JLabel background = new JLabel(icon);
        background.setBounds(0, 0, 25, 25);
        jp.add(background);
        jp.setSize(chessSize, chessSize);
        jp.setBackground(Color.BLUE);
        jp.setLocation(end_x, end_y);
        jPanel1.add(jp);
    }

    public void Clock1() {
Clock.setHorizontalAlignment(JLabel.CENTER);
        timer.schedule(new CodeGame.UpdateUITask(), 0, 1000);
    }

    private class UpdateUITask extends TimerTask {

        int nSeconds = 0;

        @Override
        public void run() {
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    Clock.setText(String.valueOf(nSeconds++));
                }
            });
        }
    }

    public Boolean check(int a, int b, ArrayList<Integer> al, ArrayList<Integer> bl) {
        Boolean h = false;
        for (int i = 0; i < al.size(); i++) {
            if ((a == end_x && b == end_y)) {
                return h = true;
            }
            if ((a == al.get(i) && b == bl.get(i))) {
                h = true;
            } else {
                h = false;
            }
            if ((a == al.get(i) + chessSize) && b == bl.get(i)) {
                h = true;
            } else {
                h = false;
            }
            if ((a == al.get(i) - chessSize) && b == bl.get(i)) {
                h = true;
            } else {
                h = false;
            }
            if (a == al.get(i) && (b == bl.get(i) + chessSize)) {
                h = true;
            } else {
                h = false;
            }
            if (a == al.get(i) && (b == bl.get(i) - chessSize)) {
                h = true;
            } else {
                h = false;
            }

        }
        return h;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Clock = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        Clock.setText("jLabel3");
        getContentPane().add(Clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 60));

        jButton2.setText("jButton2");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 0, 80, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CodeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CodeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CodeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CodeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CodeGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clock;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                P_y = (player.getY() - chessSize + Screensize) % Screensize;
                player.setLocation(P_x, P_y);
                Move();
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                P_y = (player.getY() + chessSize + Screensize) % Screensize;
                player.setLocation(P_x, P_y);
                Move();
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                P_x = (player.getX() - chessSize + Screensize) % Screensize;
                player.setLocation(P_x, P_y);
                Move();
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                P_x = (player.getX() + chessSize + Screensize) % Screensize;
                player.setLocation(P_x, P_y);
                Move();
                break;
            default:

        }

    }

    public void Move() {
        int k = 0;
        double direction = Math.random() * 4;
        int n = 0;
        while (k < getAcount()) {
//            if (direction < 1) {
            if (enemyJPanel.get(k).getX() < P_x) {

                n = (enemyJPanel.get(k).getX() + chessSize) % Screensize;

                if (check(n, E_y.get(k), E_x, E_y) == false) {
                    System.out.println("dgfjsfjs");
                    E_x.set(k, n);
                }
                enemyJPanel.get(k).setLocation(E_x.get(k), E_y.get(k));

            } else if (enemyJPanel.get(k).getX() > P_x) {
                n = (enemyJPanel.get(k).getX() - chessSize + Screensize) % Screensize;
                if (check(n, E_y.get(k), E_x, E_y) == false) {
                    E_x.set(k, n);
                }
                enemyJPanel.get(k).setLocation(E_x.get(k), E_y.get(k));

            } else if (enemyJPanel.get(k).getY() > P_y) {
                n = (enemyJPanel.get(k).getY() - chessSize + Screensize) % Screensize;
                if (check(E_y.get(k), n, E_x, E_y) == false) {
                    E_y.set(k, n);
                }
                enemyJPanel.get(k).setLocation(E_x.get(k), E_y.get(k));

            } else if (enemyJPanel.get(k).getY() < P_y) {
                n = (enemyJPanel.get(k).getY() + chessSize) % Screensize;
                if (check(E_y.get(k), n, E_x, E_y) == false) {
                    E_y.set(k, n);
                }
                enemyJPanel.get(k).setLocation(E_x.get(k), E_y.get(k));
            }

            k++;
        }
        switch (checkStatus()) {
            case 0:
                removeKeyListener(this);
                JOptionPane.showMessageDialog(rootPane, "LOSE");
                break;
            case 1:
                removeKeyListener(this);
                JOptionPane.showMessageDialog(rootPane, "WIN");
                break;
            case 2:
                break;
        }
    }

    public int checkStatus() {
        for (int i = 0; i < getAcount(); i++) {
            if (P_x == E_x.get(i) && P_y == E_y.get(i) + chessSize) {
                return 0;
            }
            if (P_x == E_x.get(i) && P_y == E_y.get(i) - chessSize) {
                return 0;
            }
            if (P_y == E_y.get(i) && P_x == E_x.get(i) + chessSize) {
                return 0;
            }
            if (P_y == E_y.get(i) && P_x == E_x.get(i) - chessSize) {
                return 0;
            }
        }
        if (P_x == end_x && P_y == end_y) {
            return 1;
        }
        if (P_x == end_x && P_y == end_y + chessSize) {
            return 1;
        }
        if (P_x == end_x && P_y == end_y - chessSize) {
            return 1;
        }
        if (P_y == end_y && P_x == end_x + chessSize) {
            return 1;
        }
        if (P_y == end_y && P_x == end_x - chessSize) {
            return 1;
        }
        return 2;

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
