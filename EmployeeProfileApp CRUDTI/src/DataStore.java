import java.util.*;
import java.util.stream.Collectors;

public class DataStore {

    private static DataStore ds;
    private Map<String, Employee> records;
    private DataStore(){
        records = new HashMap<>();
    }
    public static DataStore getDataStoreInstance(){
        if(Objects.isNull(ds)){
            ds = new DataStore();
        }
        return ds;
    }

    public boolean addRecordIfNotExist(Employee employee) {
        if(Objects.nonNull(employee) && Objects.nonNull(employee.getId()) && !records.containsKey(employee.getId())){
            System.out.println(employee.getId() + "added the record");
            records.put(employee.getId(),employee);
            return true;
        }

        return false;
    }

    public List<Employee> getRecords(){
        return new ArrayList<>(records.values());
    }

    public Employee getRecord(String idOfSelected) {
        return records.get(idOfSelected);
    }

    public boolean updateRecord(Employee employee) {
        if(Objects.nonNull(employee) && Objects.nonNull(employee.getId()) && records.containsKey(employee.getId())){
            System.out.println(employee.getId() + "updated the record");
            records.put(employee.getId(),employee);
            return true;
        }
        return false;
    }

    public boolean deleteRecord(String id) {
        if(Objects.nonNull(id) && records.containsKey(id)){
            records.remove(id);
            return true;
        }
        return false;
    }
}
