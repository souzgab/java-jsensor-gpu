/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.gpu;

/**
 *
 * @author gabri
 */
public class Main {

    public static void main(String[] args) {
        GPU gp = new GPU();
        CPU cc = new CPU();
        
        cc.getNomeCpu();
        gp.getNomeGpu();
        System.out.println(gp.getLoadInfo());
        System.out.println(gp.getFanRPM());

//        System.out.println(gp.getMediaTemperatura());
    }
}
