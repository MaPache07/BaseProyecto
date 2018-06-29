/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimiento;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author MaPache
 */
public class Enemigo extends Thread{
    private int limite;
    private JLabel ball;
    private JLabel flecha;
    private int x;
    private int y;
    public Enemigo() {}

    public Enemigo(int limite, JLabel ball, JLabel flecha, int x, int y) {
        this.limite = limite;
        this.ball = ball;
        this.flecha = flecha;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        boolean flag = true;
        while(true){
            for (int i = x; i <= this.limite; i += 10) {
                ball.setIcon(new ImageIcon(getClass().getResource("ERight.png")));
                this.ball.setLocation(i, y);
                float v = (float) Math.sqrt(Math.pow(flecha.getX()-ball.getX(), 2)+Math.pow(flecha.getY()-ball.getY(), 2));
                if(v <= 100){
                    flag = false;
                    break;
                }
                try {
                    sleep(75);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
            }
            if(!flag){
                Seguir();
                break;
            }
            for (int i = this.limite; i >= x; i -= 10) {
                this.ball.setLocation(i, y);
                ball.setIcon(new ImageIcon(getClass().getResource("ELeft.png")));
                float v = (float) Math.sqrt(Math.pow(flecha.getX()-ball.getX(), 2)+Math.pow(flecha.getY()-ball.getY(), 2));
                if(v <= 100){
                    flag = false;
                    break;
                }
                try {
                    sleep(75);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
            }
            if(!flag){
                Seguir();
                break;
            }
            yield();
        }
    }
    
    public void Seguir(){
        
        while(true){
            if(ball.getX() < flecha.getX()){
                for(int i = ball.getX(); i < flecha.getX(); i += 10){
                    if(ball.getX() < flecha.getX()-30){
                        break;
                    }
                    System.out.println("Derecha");
                    ball.setIcon(new ImageIcon(getClass().getResource("ERight.png")));
                    this.ball.setLocation(i, y);
                    x = i;
                    try {
                        sleep(75);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int dif = flecha.getX()-ball.getX();
                    if(dif < 10 && dif > 0){
                        ball.setIcon(new ImageIcon(getClass().getResource("ERight.png")));
                        this.ball.setLocation(i+dif, y);
                        try {
                            sleep(75);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        x = i+dif;
                    }
                }
            }
            if(ball.getX() > flecha.getX()){
                for(int i = ball.getX(); i > flecha.getX(); i -= 10){
                    if(ball.getX() > flecha.getX()+30){
                        break;
                    }
                    System.out.println("Izquierda");
                    ball.setIcon(new ImageIcon(getClass().getResource("ELeft.png")));
                    this.ball.setLocation(i, y);
                    x = i;
                    try {
                        sleep(75);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int dif = ball.getX()-flecha.getX();
                    if(dif < 10 && dif > 0){
                        ball.setIcon(new ImageIcon(getClass().getResource("ELeft.png")));
                        this.ball.setLocation(i-dif, y);
                        try {
                            sleep(75);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        x = i-dif;
                    }
                }
            }
            if(ball.getY() < flecha.getY()){
                for(int j = ball.getY(); j < flecha.getY(); j += 10){
                    if(ball.getY() < flecha.getY()-30){
                        break;
                    }
                    System.out.println("Abajo");
                    ball.setIcon(new ImageIcon(getClass().getResource("EDown.png")));
                    this.ball.setLocation(x, j);
                    y = j;
                    try {
                        sleep(75);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int dif = flecha.getY()-ball.getY();
                    if(dif < 10 && dif > 0){
                        ball.setIcon(new ImageIcon(getClass().getResource("EDown.png")));
                        this.ball.setLocation(x, j+dif);
                        try {
                            sleep(75);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        y = j+dif;
                    }
                }
            }
            if(ball.getY() > flecha.getY()){
                for(int j = ball.getY(); j > flecha.getY(); j -= 10){
                    if(ball.getY() > flecha.getY()+30){
                        break;
                    }
                    System.out.println("Arriba");
                    ball.setIcon(new ImageIcon(getClass().getResource("EUp.png")));
                    this.ball.setLocation(x, j);
                    y = j;
                    try {
                        sleep(75);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int dif = ball.getY()-flecha.getY();
                    if(dif < 10 && dif > 0){
                        ball.setIcon(new ImageIcon(getClass().getResource("EUp.png")));
                        this.ball.setLocation(x, j-dif);
                        try {
                            sleep(75);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        y = j-dif;
                    }
                }
            }
        }
    }   
}
