/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import movimiento.Enemigo;

/**
 *
 * @author MaPache
 */
public class Gui extends JFrame{
    
    JLabel n = new JLabel();
    JLabel m = new JLabel();
    JLabel bala = new JLabel();
    public Enemigo enemigo;
    private int WIDTH = 30, HEIGHT = 30;
    
    public Gui(){
        addKeyListener(new TAdapter());
        setResizable(true);
        setTitle("Prueba");
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 500);
        Container container = getContentPane();
        container.add(n);
        container.add(m);
        container.add(bala);
        
        m.setIcon(new ImageIcon(getClass().getResource("Down.png")));
        m.setBounds(130, 10, WIDTH, HEIGHT);
        
        n.setIcon(new ImageIcon(getClass().getResource("ERight.png")));
        n.setBounds(10, 250, WIDTH, HEIGHT);
        
        bala.setIcon(new ImageIcon(getClass().getResource("bala.png")));
        bala.setBounds(-30, 0, WIDTH, HEIGHT);
        
        enemigo = new Enemigo(750, n, m, bala, n.getX(), n.getY(), 100, 10, 1);
        enemigo.start();
    }
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            int difx = (int) Math.sqrt(Math.pow(m.getX()-n.getX(), 2));
            int dify = (int) Math.sqrt(Math.pow(m.getY()-n.getY(), 2));
            if (key == KeyEvent.VK_LEFT) {
                if (m.getX() >= 10 && m.getX() < 800) {
                    if((m.getX()-30 > n.getX() || m.getX() < n.getX()) || dify >= 30){
                        m.setIcon(new ImageIcon(getClass().getResource("Left.png")));
                        m.setBounds(m.getX() - 10, m.getY(), WIDTH, HEIGHT);
                    }
                }
            }
            if (key == KeyEvent.VK_RIGHT) {
                if (m.getX() >= 0 && m.getX() <= 740) {
                    if((m.getX()+30 < n.getX() || m.getX() > n.getX()) || dify >= 30){
                        m.setIcon(new ImageIcon(getClass().getResource("Right.png")));
                        m.setBounds(m.getX() + 10, m.getY(), WIDTH, HEIGHT);
                    }
                }
            }
            if (key == KeyEvent.VK_UP) {
                if (m.getY() >= 10 && m.getY() < 500) {
                    if((m.getY()-30 > n.getY() || m.getY() < n.getY()) || difx >= 30){
                        m.setIcon(new ImageIcon(getClass().getResource("Up.png")));
                        m.setBounds(m.getX(), m.getY() - 10, WIDTH, HEIGHT);
                    }
                }
            }
            if (key == KeyEvent.VK_DOWN) {
                if (m.getY() >= 0 && m.getY() <= 425) {
                    if((m.getY()+30 < n.getY() || m.getY() > n.getY()) || difx >= 30){
                        m.setIcon(new ImageIcon(getClass().getResource("Down.png")));
                        m.setBounds(m.getX(), m.getY() + 10, WIDTH, HEIGHT);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame ex = new Gui();
            ex.setVisible(true);
        });
    }
}
