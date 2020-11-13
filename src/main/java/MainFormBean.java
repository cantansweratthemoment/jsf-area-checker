import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "mainFormBean")
@ApplicationScoped

public class MainFormBean implements Serializable {
    private Check newCheck;
    private CheckList checkList;//TODO это поле придумано фашистами

    public CheckList getCheckList() {
        return checkList;
    }

    public void setCheckList(CheckList checkList) {
        this.checkList = checkList;
    }

    public MainFormBean(Check newCheck, CheckList checkList) {
        this.newCheck = newCheck;
        this.checkList = checkList;
    }

    public MainFormBean() {
        this.newCheck = new Check();
        this.checkList = new CheckList();
    }

    public Check getNewCheck() {
        return newCheck;
    }

    public void setNewCheck(Check newCheck) {
        this.newCheck = newCheck;
    }

    public void submit() {
        newCheck.checkHit();
        Check checkForTheList = new Check(newCheck.getX(), newCheck.getY(), newCheck.getR(), newCheck.isResult());
        this.checkList.add(checkForTheList);
        System.out.println(this.checkList.getChecks().toString());
    }
}