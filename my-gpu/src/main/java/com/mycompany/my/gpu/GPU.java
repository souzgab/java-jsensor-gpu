package com.mycompany.my.gpu;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class GPU {

    Components components = JSensors.get.components();
    List<Gpu> gpus = components.gpus;

    private Double fanRPM, memoryGpu, memoryControllerGpu, videoEngineGpu, coreGpu;
    private String nomeGpu;
    private Double media = 0.0;

    private List<Double> temperaturaGpu = new ArrayList<>();
    private List<Double> loadGpu = new ArrayList<>();

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
        return media = soma / temperaturaGpu.size();
    }

    public Double getFanRpm() {
        for (final Gpu g : gpus) {
            List<Fan> fans = g.sensors.fans;
            System.out.println("fans encontradas = " + fans);
            for (final Fan fan : fans) {
                System.out.println(fan.name + ": " + fan.value + " RPM");
            }
        }
        return fanRPM;
    }

    public Double getMemoryGpu() {
        return memoryGpu = loadGpu.get(3);
    }

    public Double getMemoryControllerGpu() {
        return memoryControllerGpu = loadGpu.get(1);
    }

    public Double getVideoEngineGpu() {
        return videoEngineGpu = loadGpu.get(2);
    }

    public Double getCoreGpu() {
        return coreGpu = loadGpu.get(0);
    }

    public List getLoadInfo() {
        Integer i = 0;
        for (final Gpu c : gpus) {
            List<Load> loads = c.sensors.loads;
            for (final Load x : loads) {
                i++;
                System.out.println(x.name + ": " + x.value);
                if (x.name.startsWith("Load GPU Core")) {
                    loadGpu.add(x.value);
                } else if (x.name.startsWith("Load GPU Memory Controller")) {
                    loadGpu.add(x.value);
                } else if (x.name.startsWith("Load GPU Video Engine")) {
                    loadGpu.add(x.value);
                } else if (x.name.startsWith("Load GPU Memory")) {
                    loadGpu.add(x.value);
                }
            }
        }
        return loadGpu;
    }

    public String getNomeGpu() {
        for (final Gpu g : gpus) {
            System.out.println("Found this GPU: " + g.name);
            nomeGpu = g.name;
        }
        return nomeGpu;
    }

    public String getDadosGpu() {
        getLoadInfo();
        
        JSONObject dadosGpuToJson = new JSONObject();

        try {
            dadosGpuToJson.put("nomeGpu", getNomeGpu());
            dadosGpuToJson.put("coreGpu", getCoreGpu());
            dadosGpuToJson.put("fanGpu", getFanRpm());
            dadosGpuToJson.put("temperaturaMedia", getMediaTemperatura());
            dadosGpuToJson.put("memoriaCtrlGpu", getMemoryControllerGpu());
            dadosGpuToJson.put("memoriaVRamGpu", getMemoryGpu());
            dadosGpuToJson.put("videoEngineGpu", getVideoEngineGpu());
            
            System.out.println(dadosGpuToJson.toString());
        } catch (JSONException ex) {
            Logger.getLogger(GPU.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dadosGpuToJson.toString();
    }
}
