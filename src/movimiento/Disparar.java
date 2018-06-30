/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimiento;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author MaPache
 */
public class Disparar extends Thread{
    
    JLabel enemigo, bala, personaje;
    boolean right, left, up, down, flag = true;
    int atk, pv, dist = 200, difx, dify;
    
    public Disparar(){}
    
    public void Setter1(int atk, int pv){
        this.atk = atk;
        this.pv = pv;
    }
    
    public void Setter2(JLabel e, JLabel b, JLabel p, boolean r, boolean l, boolean u, boolean d, int difx, int dify){
        this.enemigo = e;
        this.bala = b;
        this.personaje = p;
        this.right = r;
        this.left = l;
        this.up = u;
        this.down = d;
        this.difx = difx;
        this.dify = dify;
    }

    public void Setter3(JLabel personaje, int difx, int dify) {
        this.personaje = personaje;
        this.difx = difx;
        this.dify = dify;
    }
    
    @Override
    public void run(){
        while(true){
            if(right){
                if((personaje.getX()-enemigo.getX() < dist) && dify < 30){
                    flag = false;
                    for(int i = enemigo.getX()+30; i < i+300; i += 5){
                        bala.setIcon(new ImageIcon(getClass().getResource("bala.png")));
                        bala.setLocation(i, enemigo.getY());
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } 
                        if(i == personaje.getX() && dify < 30){
                            pv = pv-atk;
                            bala.setIcon(new ImageIcon(getClass().getResource("Off.png")));
                            break;
                        }
                        if(i > 800){
                            bala.setIcon(new ImageIcon(getClass().getResource("Off.png")));
                            break;
                        }
                    }
                    flag = true;
                }
            }
            if(left){
                if((enemigo.getX()-personaje.getX() < dist) && dify < 30){
                    flag = false;
                    for(int i = enemigo.getX(); i > i-300; i -= 5){
                        bala.setIcon(new ImageIcon(getClass().getResource("bala.png")));
                        bala.setLocation(i, enemigo.getY());
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } 
                        if(i == personaje.getX() && dify < 30){
                            pv = pv-atk;
                            bala.setIcon(new ImageIcon(getClass().getResource("Off.png")));
                            break;
                        }
                        if(i < 0){
                            bala.setIcon(new ImageIcon(getClass().getResource("Off.png")));
                            break;
                        }
                    }
                    flag = true;
                }
            }
            if(up){
                if((enemigo.getY()-personaje.getY() < dist) && difx < 30){
                    flag = false;
                    for(int i = enemigo.getY(); i > i-300; i -= 5){
                        bala.setIcon(new ImageIcon(getClass().getResource("bala.png")));
                        bala.setLocation(enemigo.getX(), i);
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } 
                        if(i == personaje.getY() && difx < 30){
                            pv = pv-atk;
                            bala.setIcon(new ImageIcon(getClass().getResource("Off.png")));
                            break;
                        }
                        if(i < 0){
                            bala.setIcon(new ImageIcon(getClass().getResource("Off.png")));
                            break;
                        }
                    }
                    flag = true;
                }
            }
            if(down){
                if((personaje.getY()-enemigo.getY() < dist) && difx < 30){
                    flag = false;
                    for(int i = enemigo.getY()+30; i < i+300; i += 5){
                        bala.setIcon(new ImageIcon(getClass().getResource("bala.png")));
                        bala.setLocation(enemigo.getX(), i);
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } 
                        if(i == personaje.getY() && difx < 30){
                            pv = pv-atk;
                            bala.setIcon(new ImageIcon(getClass().getResource("Off.png")));
                            break;
                        }
                        if(i > 500){
                            bala.setIcon(new ImageIcon(getClass().getResource("Off.png")));
                            break;
                        }
                    }
                    flag = true;
                }
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(pv == 0){
                System.exit(0);
            }
        }
    }
}
