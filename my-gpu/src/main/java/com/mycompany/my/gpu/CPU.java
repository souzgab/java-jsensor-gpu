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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

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
    private Double tempc4;
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
    
    public Double getTemp4(){
        return tempc4 = load.get(3);
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
    
    public String getDadosCpu() {
        getLoadInfo();
        
        JSONObject dadosCpuToJson = new JSONObject();

        try {
            dadosCpuToJson.put("nomeCpu", getNomeCpu());
            dadosCpuToJson.put("temperaturaMedia", getMediaTemperatura());
            
            System.out.println(dadosCpuToJson.toString());
        } catch (JSONException ex) {
            Logger.getLogger(GPU.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dadosCpuToJson.toString();
    }
}
