/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.gpu;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author gabri
 */
public class Main {

    public static void main(String[] args) {
        GPU gp = new GPU();
        CPU cc = new CPU();

        System.out.println(gp.getDadosGpu());
        System.out.println(cc.getDadosCpu());
        
        long TEMPO = (2000 * 1);

        Timer timer = null;

        if (timer == null) {
            timer = new Timer();

            TimerTask tarefa = new TimerTask() {
                public void run() {
                    System.out.println("--------------------GPU-----------------------");
                    gp.getNomeGpu();
                    System.out.println("GPU Temperatura Média: " + gp.getMediaTemperatura());
                }
            };
            timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
        }
    }
}
