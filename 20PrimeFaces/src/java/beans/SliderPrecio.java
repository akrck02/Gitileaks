package beans;

import dao.DaoBuses;

public class SliderPrecio {
    private final static int N1=DaoBuses.precioMin();
    private final static int N2=DaoBuses.precioMax();

    public static int getN1() {
        return N1;
    }

    public static int getN2() {
        return N2;
    }
    
    
}
