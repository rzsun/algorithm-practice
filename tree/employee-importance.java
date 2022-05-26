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
        for (Employee e : employees) {
            employeeMap.put(e.id, e);
        }
        return dfs(employeeMap, employeeMap.get(id));
    }
    
    public int dfs(Map<Integer, Employee> employeeMap, Employee root) {
        int sum = root.importance;
        for (Integer id : root.subordinates) {
            sum += dfs(employeeMap, employeeMap.get(id));
        }
        return sum;
    }
}
