import javax.faces.validator.FacesValidator;
import java.io.Serializable;

public class Check implements Serializable {
    private double x;
    private double y;
    private double r=2;
    private boolean result;

    public Check() {
    }

    public Check(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Check(double x, double y, double r, boolean result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
    }

    public void checkHit() {
        this.setResult(((x >= -r / 2) && (x <= 0) && (y >= 0) && (y <= r / 2) && (x * x + y * y <= r / 2 * r / 2)) ||
                ((x >= -r) && (x <= 0) && (y >= -r) && (y <= 0)) ||
                ((x >= 0) && (x <= r / 2) && (y >= -r / 2) && (y <= 0) && (y >= x - r / 2)));
    }
}
