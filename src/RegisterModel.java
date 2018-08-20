import java.util.ArrayList;
import java.util.List;


public class RegisterModel {
    private List<Employee> employees = new ArrayList<>();


    boolean isRegisterEmpty()
    {
        return employees.isEmpty();
    }

    List<Employee> getEmployees()
    {
        return employees;
    }

    void insertEmployeeToRegister(Employee employee)
    {
        employees.add(employee);
    }


    Employee findEmployeeByPesel(String pesel){
        for(Employee employee : employees)
        {
            if(employee.getPesel().equals(pesel))
                return employee;
        }
        return null;
    }

    boolean deleteEmployee(Employee employee)
    {
        return employees.remove(employee);

    }


    protected boolean deleteEmployeeByPesel(String pesel){
        Employee employee = findEmployeeByPesel(pesel);

        return employee != null && employees.remove(employee);
    }

}


