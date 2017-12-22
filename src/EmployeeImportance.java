import java.util.HashMap;
import java.util.List;

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map=new HashMap<>();
        
        for(Employee e:employees) {
        	map.put(e.id,e);
        }
        return helper(map.get(id), map);
    }
    
    public int helper (Employee e,  HashMap<Integer,Employee> map) {
    	int result=e.importance;
    	for(Integer id : e.subordinates) {
    		result+=helper(map.get(id), map);
    	}
    	return result;
    }
}
