import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "mainFormBean")
@ApplicationScoped

public class MainFormBean implements Serializable {
    private Double x_chooser;
    private Double y_chooser;
    private Double r_chooser;

    public Double getX_chooser() {
        return x_chooser;
    }

    public void setX_chooser(Double x_chooser) {
        this.x_chooser = x_chooser;
    }

    public Double getY_chooser() {
        return y_chooser;
    }

    public void setY_chooser(Double y_chooser) {
        this.y_chooser = y_chooser;
    }

    public Double getR_chooser() {
        return r_chooser;
    }

    public void setR_chooser(Double r_chooser) {
        this.r_chooser = r_chooser;
    }

    public MainFormBean(Double x_chooser, Double y_chooser, Double r_chooser) {
        this.x_chooser = x_chooser;
        this.y_chooser = y_chooser;
        this.r_chooser = r_chooser;
    }

    public MainFormBean() {
    }

    public void addNewCheck(){
        Check check = new Check(x_chooser, y_chooser, r_chooser);
       
    }
}