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
    private List<Double> temperaturaCpu = new ArrayList<>();
    private List<Double> load = new ArrayList<>();

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
                System.out.println(t.name + ": " + t.value);
                temperaturaCpu.add(t.value);
            }
            for (Integer i = 0; i < temperaturaCpu.size(); i++) {
                soma += temperaturaCpu.get(i);
            }
        }
        return media = soma / temperaturaCpu.size();
    }

    public Double getFanRPM() {
        for (final Cpu c : cpus) {
            List<Fan> fans = c.sensors.fans;
            for (final Fan fan : fans) {
                System.out.println(fan.name + ": " + fan.value + " RPM");
            }
        }
        return fanRPM;
    }

    public List getLoadInfo() {
        Integer i = 0;
        for (final Cpu c : cpus) {
            List<Load> loads = c.sensors.loads;
//      
            for (final Load x : loads) {
                System.out.println(x.name + ": " + x.value);
                i++;
                if (x.name.startsWith("Load CPU Core #" + i)) {
                    load.add(x.value);
                }
            }
        }
        return load;
    }
}
