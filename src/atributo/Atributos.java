package atributo;

import java.util.HashMap;
import java.util.Map;

public interface Atributos {
    HashMap<String,Integer> atributos  = new HashMap<String, Integer>();

    void setAtributo(String nombre, int valor);

    default void setAtributos(Map<String, Integer> atributosMap) {
        for (Map.Entry<String, Integer> entry : atributosMap.entrySet()) {
            setAtributo(entry.getKey(), entry.getValue());
        }
    }
    default int sumarAtributos(){
        int suma=0;
        for(int valor : atributos.values()){
            suma+=valor;
        }
        return suma;
    }
}