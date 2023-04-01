
package triangulo;

import modelo.Triangulo;

/**
 *
 * @author Admin
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Triangulo unTriangulo = new Triangulo(5,4);
        
        unTriangulo.calcularArea();
        
        System.out.println("Base del triangulo : " + unTriangulo.getBase());
        System.out.println("Altura del triangulo : " + unTriangulo.getAltura());
        System.out.println("Area del triangulo : " + unTriangulo.getArea());
    }
    
}
