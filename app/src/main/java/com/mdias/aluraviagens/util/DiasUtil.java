package com.mdias.aluraviagens.util;

public class DiasUtil {

    public static final String FORMATO_SINGULAR = "%d dia";
    public static final String FORMATO_PLURAL = "%d dias";

    public static String formataEmTexto(int dias) {
        if(dias > 1){
            return String.format(FORMATO_SINGULAR, dias);
        }
        return String.format(FORMATO_PLURAL, dias);
    }
}
