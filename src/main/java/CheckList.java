import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckList implements Serializable {//TODO этот чел на время отсутсвия БД
    private List<Check> checks;

    public CheckList() {
        checks = new ArrayList<Check>();
    }

    public List<Check> getChecks() {
        return checks;
    }

    public void add(Check check) {
        checks.add(check);
    }
}
