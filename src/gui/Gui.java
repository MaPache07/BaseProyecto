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
    Enemigo enemigo;
    private int WIDTH = 30, HEIGHT = 30;
    
    public Gui(){
        addKeyListener(new TAdapter());
        setResizable(true);
        setTitle("Prueba");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(300, 300);
        Container container = getContentPane();
        container.add(n);
        container.add(m);
        
        n.setIcon(new ImageIcon(getClass().getResource("dot.png")));
        n.setBounds(10, 150, WIDTH, HEIGHT);
        enemigo = new Enemigo(250, n, n.getX(), n.getY());
        enemigo.start();

        m.setIcon(new ImageIcon(getClass().getResource("Down.png")));
        m.setBounds(135, 50, WIDTH, HEIGHT);
    }
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            
            if (key == KeyEvent.VK_LEFT) {
                if (m.getX() >= 10 && m.getX() < 300) {
                    m.setIcon(new ImageIcon(getClass().getResource("Left.png")));
                    m.setBounds(m.getX() - 10, m.getY(), WIDTH, HEIGHT);
                }

            }
            if (key == KeyEvent.VK_RIGHT) {
                if (m.getX() >= 0 && m.getX() <= 250) {
                    m.setIcon(new ImageIcon(getClass().getResource("Right.png")));
                    m.setBounds(m.getX() + 10, m.getY(), WIDTH, HEIGHT);
                }
            }
            if (key == KeyEvent.VK_UP) {
                if (m.getY() >= 10 && m.getY() < 300) {
                    m.setIcon(new ImageIcon(getClass().getResource("Up.png")));
                    m.setBounds(m.getX(), m.getY() - 10, WIDTH, HEIGHT);
                }
            }
            if (key == KeyEvent.VK_DOWN) {
                if (m.getY() >= 0 && m.getY() <= 220) {
                    m.setIcon(new ImageIcon(getClass().getResource("Down.png")));
                    m.setBounds(m.getX(), m.getY() + 10, WIDTH, HEIGHT);
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