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
    public JLabel ball;
    public JLabel flecha;
    public JLabel bala;
    private int x;
    private int y;
    private int dist, pv, atk;
    public int dify, difx;
    public boolean right = false, left = false, up = false, down = false;
    
    public Enemigo() {}

    public Enemigo(int limite, JLabel ball, JLabel flecha, JLabel bala, int x, int y, int d, int pv, int atk) {
        this.limite = limite;
        this.ball = ball;
        this.flecha = flecha;
        this.x = x;
        this.y = y;
        this.dist = d;
        this.pv = pv;
        this.atk = atk;
        this.bala = bala;
    }

    @Override
    public void run() {
        boolean flag = true;
        while(true){
            for (int i = x; i <= this.limite; i += 10) {
                ball.setIcon(new ImageIcon(getClass().getResource("ERight.png")));
                this.ball.setLocation(i, y);
                float v = (float) Math.sqrt(Math.pow(flecha.getX()-ball.getX(), 2)+Math.pow(flecha.getY()-ball.getY(), 2));
                if(v <= 50){
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
                if(v <= 50){
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
        Disparar disparo = new Disparar();
        disparo.start();
        disparo.Setter1(atk, pv);
        while(true){
            System.out.println("");
            if(ball.getX() < flecha.getX()){
                for(int i = ball.getX(); i <= flecha.getX(); i += 10){
                    dify = (int) Math.sqrt(Math.pow(ball.getY()-flecha.getY(), 2));
                    if((ball.getX()+30 < flecha.getX()) || dify >= 30){
                        right = true;
                        ball.setIcon(new ImageIcon(getClass().getResource("ERight.png")));
                        this.ball.setLocation(i, y);
                        x = i;
                        try {
                            sleep(75);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(disparo.flag){
                            disparo.Setter2(ball, bala, flecha, right, left, up, down, difx, dify);
                        }
                        disparo.Setter3(flecha, difx, dify);
                    }
                    right = false;
                }
            }
            if(ball.getX() > flecha.getX()){
                for(int i = ball.getX(); i >= flecha.getX(); i -= 10){
                    dify = (int) Math.sqrt(Math.pow(ball.getY()-flecha.getY(), 2));
                    if((ball.getX()-30 > flecha.getX()) || dify >= 30){
                        left = true;
                        ball.setIcon(new ImageIcon(getClass().getResource("ELeft.png")));
                        this.ball.setLocation(i, y);
                        x = i;
                        try {
                            sleep(75);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(disparo.flag){
                            disparo.Setter2(ball, bala, flecha, right, left, up, down, difx, dify);
                        }
                        disparo.Setter3(flecha, difx, dify);
                    }
                    left = false;
                }
            }
            if(ball.getY() < flecha.getY()){
                for(int j = ball.getY(); j <= flecha.getY(); j += 10){
                    difx = (int) Math.sqrt(Math.pow(ball.getX()-flecha.getX(), 2));
                    if((ball.getY()+30 < flecha.getY()) || difx >= 30){
                        down = true;
                        ball.setIcon(new ImageIcon(getClass().getResource("EDown.png")));
                        this.ball.setLocation(x, j);
                        y = j;
                        try {
                            sleep(75);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(disparo.flag){
                            disparo.Setter2(ball, bala, flecha, right, left, up, down, difx, dify);
                        }
                        disparo.Setter3(flecha, difx, dify);
                    }
                    down = false;
                }
            }
            if(ball.getY() > flecha.getY()){
                for(int j = ball.getY(); j >= flecha.getY(); j -= 10){
                    difx = (int) Math.sqrt(Math.pow(ball.getX()-flecha.getX(), 2));
                    if((ball.getY()-30 > flecha.getY()) || difx >= 30){
                        up = true;
                        ball.setIcon(new ImageIcon(getClass().getResource("EUp.png")));
                        this.ball.setLocation(x, j);
                        y = j;
                        try {
                            sleep(75);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(disparo.flag){
                            disparo.Setter2(ball, bala, flecha, right, left, up, down, difx, dify);
                        }
                        disparo.Setter3(flecha, difx, dify);
                    }
                    up = false;
                }
            }
        }
    }
}
