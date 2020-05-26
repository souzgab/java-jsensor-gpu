package com.mycompany.my.gpu;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.util.ArrayList;
import java.util.List;

public class GPU {

    Components components = JSensors.get.components();
    List<Gpu> gpus = components.gpus;

    private Double fanRPM, memoryGpu, memoryControllerGpu, videoEngineGpu;
    private String nomeGpu;
    private Double media = 0.0;
    
    private List<Double> temperaturaGpu, load = new ArrayList<>();

    public Double getMediaTemperatura() {
        Double soma = 0.0;
        for (final Gpu g : gpus) {
                    
            List<Temperature> temps = g.sensors.temperatures;
            for (final Temperature t : temps) {
                temperaturaGpu.add(t.value);
                
            }
            for (Integer i = 0; i < temperaturaGpu.size(); i++) {
                soma += temperaturaGpu.get(i);
            }
        }
        System.out.println(soma);
        System.out.println(">"+this.media);
        return media = soma/temperaturaGpu.size();
    }

    public Double getFanRPM() {
        for (final Gpu g : gpus) {
            List<Fan> fans = g.sensors.fans;
            System.out.println(fans);
            for (final Fan fan : fans) {
                System.out.println(fan.name + ": " + fan.value + " RPM");
            }
        }
        return fanRPM;
    }

    public Double getMemoryGpu() {
        return memoryGpu;
    }

    public Double getMemoryControllerGpu() {
        return memoryControllerGpu;
    }

    public Double getVideoEngineGpu() {
        return videoEngineGpu;
    }
    
    public List getLoadInfo(){
        for(final Gpu c : gpus){
            List<Load> loads = c.sensors.loads;
            System.out.println(loads);
            for(final Load l : loads){
                System.out.println(l.name + ": " + l.value);
            }
        }
        return load;
    }

    public String getNomeGpu() {
        for (final Gpu g : gpus) {
            System.out.println("Found this GPU: " + g.name);
            nomeGpu = g.name;
        }
        return nomeGpu;
    }
}
