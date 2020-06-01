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

//        System.out.println("--------------------CPU-----------------------");
//
//        cc.getNomeCpu();
//        System.out.println("Load info CPU: " + cc.getLoadInfo());
//        System.out.println("Fan Rpm Cpu: " + cc.getFanRPM());
//        System.out.println("CPU Temperatura Média: " + cc.getMediaTemperatura());
//
        long TEMPO = (2000 * 1);

        Timer timer = null;

        if (timer == null) {
            timer = new Timer();

            TimerTask tarefa = new TimerTask() {
                public void run() {
                    System.out.println("--------------------GPU-----------------------");
                    gp.getNomeGpu();
                    System.out.println("GPU Temperatura Média: " + gp.getMediaTemperatura());
                    System.out.println("Load Info GPU: " + gp.getLoadInfo());
                    System.out.println("Fan RPM: " + gp.getFanRPM());
                }
            };
            timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
        }
    }
}
