/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.gpu;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class CPU {

    Components components = JSensors.get.components();
    List<Cpu> cpus = components.cpus;

    private String nomeCpu;
    private Double media = 0.0;
    private Double fanRPM;
    private List<Double> temperaturaCpu,load = new ArrayList<>();

    public String getNomeCpu() {
        for (final Cpu c : cpus) {
            System.out.println("Found this cpu: " + c.name);
            nomeCpu = c.name;
        }
        return nomeCpu;
    }

    public Double getMediaTemperatura() {
        Double soma = 0.0;
        for (final Cpu c : cpus) {
            List<Temperature> temps = c.sensors.temperatures;
            for (final Temperature t : temps) {
                temperaturaCpu.add(t.value);
            }
            for (Integer i = 0; i < temperaturaCpu.size(); i++) {
                System.out.println(temperaturaCpu.get(i));
                soma += temperaturaCpu.get(i);
            }
        }
        System.out.println(soma); // Soma as temperaturas de todos os nucleos da cpu
        System.out.println(">" + this.media);
        return media = soma / temperaturaCpu.size();
    }

    public Double getFanRPM() {
        for (final Cpu c : cpus) {
            List<Fan> fans = c.sensors.fans;
            System.out.println(fans);
            for (final Fan fan : fans) {
                System.out.println(fan.name + ": " + fan.value + " RPM");
            }
        }
        return fanRPM;
    }
    
    public List x(){
        for(final Cpu c : cpus){
            List<Load> loads = c.sensors.loads;
            System.out.println(loads);
            for(final Load l : loads){
                System.out.println(l.name + ": " + l.value + "...");
            }
        }
        return load;
    }
}
