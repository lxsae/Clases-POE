
package modelo;

/**
 *
 * @author Admin
 */
public class Triangulo {
    
    private float base;
    private float altura;
    private float area;

    public Triangulo() {
        this.base = 0.0f;
        this.altura = 0.0f;
        this.area = 0.0f;
    }
    public Triangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
        this.area = 0.0f;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }
    
    public void calcularArea(){
        float base = getBase();
        float altura = getAltura();
        float area = (base * altura) / 2.0f; 
        
        setArea(area);
    }
    
}
