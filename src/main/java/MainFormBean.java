import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "mainFormBean")
@ApplicationScoped

public class MainFormBean implements Serializable {
    private Check newCheck;
    //private CheckList checkList;//TODO это поле придумано фашистами
    private DataBaseWorker dataBaseWorker;

    public DataBaseWorker getDataBaseWorker() {
        return dataBaseWorker;
    }

    public void setDataBaseWorker(DataBaseWorker dataBaseWorker) {
        this.dataBaseWorker = dataBaseWorker;
    }

    public MainFormBean(Check newCheck, DataBaseWorker dataBaseWorker) {
        this.newCheck = newCheck;
        this.dataBaseWorker = dataBaseWorker;
    }

    public MainFormBean() {
        this.newCheck = new Check();
        this.dataBaseWorker = new DataBaseWorker();
        dataBaseWorker.getPoints();
    }

    public Check getNewCheck() {
        return newCheck;
    }

    public void setNewCheck(Check newCheck) {
        this.newCheck = newCheck;
    }

    public void submit() {
        newCheck.checkHit();
        if (validate(newCheck)) {
            Check checkForTheList = new Check(newCheck.getX(), newCheck.getY(), newCheck.getR(), newCheck.isResult());//ЫЫЫЫЫ
            this.dataBaseWorker.add(checkForTheList);
        }
    }

    public boolean validate(Check check) {
        return (((check.getX() >= -5) && (check.getX() <= 3)) && (check.getY() > -5 && (check.getY() < 3)) && ((check.getR() > 1) && (check.getR() < 4)));
    }
}