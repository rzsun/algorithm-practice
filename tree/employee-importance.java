/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            employeeMap.put(e.id, e);
        }
        return totalImportance(employeeMap, employeeMap.get(id));
    }
    
    public int totalImportance(Map<Integer, Employee> employeeMap, Employee root) {
        int sum = root.importance;
        for (Integer id : root.subordinates) {
            sum += totalImportance(employeeMap, employeeMap.get(id));
        }
        return sum;
    }
}
