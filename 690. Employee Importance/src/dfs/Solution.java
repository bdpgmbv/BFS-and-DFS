package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
	public Employee(int id, int importance, List<Integer> subordinates) {
		super();
		this.id = id;
		this.importance = importance;
		this.subordinates = subordinates;
	}
}

public class Solution {
	Map<Integer, Employee> emap;
	public int dfs(int queryId) {
		Employee employee = emap.get(queryId);
		int ans = employee.importance;
		for(int subordinateId : employee.subordinates)
			ans += dfs(subordinateId);
		return ans;
	}
	public int getImportance(List<Employee> employees, int queryId) {
		emap = new HashMap<>();
		for(Employee emp: employees)
			emap.put(emp.id, emp);
		return dfs(queryId);
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1,5,new ArrayList<>(Arrays.asList(2,3))));
		employees.add(new Employee(2,3,new ArrayList<>()));
		employees.add(new Employee(3,3,new ArrayList<>()));
		for(Employee em:employees) 
			System.out.println(em.id+" "+em.importance+" "+em.subordinates);
		System.out.println(sol.getImportance(employees,1));
	}
}
