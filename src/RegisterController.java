import java.util.List;
import java.util.Scanner;


public class RegisterController {

    private static RegisterView view = new RegisterView();
    private static RegisterModel model = new RegisterModel();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while(true){
            view.pageContent(RegisterView.PageContentCode.MENU);
            String option = scanner.next();

            switch (option){
                case "1":
                    employeesRegister();
                        break;
                case "2":
                    enterEmployee();
                    break;
                case "3":
                    deletingEmployeeWindow();
                    break;
                case "4":

                    break;
                case "5":
                    System.exit(0);

                default:
                    view.errorMessage(RegisterView.ErrorCode.INVALID_OPTION);
                    break;
            }
        }
    }

    private static void employeesRegister()
    {
        if(!model.isRegisterEmpty())
        {
            List<Employee> register = model.getEmployees();
            int maxIndex = register.size();
            for(int i = 0; i < maxIndex;)
            {
                view.employeeRegisterLabel();
                Employee employee = register.get(i);
                view.displayEmployee(employee);
                view.pageLabel(i + 1,maxIndex);
                view.nextOrCancelLabel();
                String option = scanner.next();

                if(option.equals("n"))
                {
                    i++;
                    if(i == maxIndex)
                        i = 0;
                }
                else if(option.equals("c"))
                {
                    break;
                }
                else
                {
                    view.errorMessage(RegisterView.ErrorCode.INVALID_OPTION);
                }
            }
        }
        else
        {
            view.notificationMessage(RegisterView.NotificationCode.EMPTY_REGISTER);
        }
    }


    private static void enterEmployee()
    {
        view.enterEmployeeLabel();
        String employeeType = scanner.next();

        if(employeeType.equals("D"))
        {
            if(enterDirector())
                view.notificationMessage(RegisterView.NotificationCode.ADD_EMPLOYEE_SUCCESS);
            else
                view.addingEmployeeFailedNotification();
        }
        else if(employeeType.equals("T"))
        {
            if(enterTrader())
                view.addingEmployeeSuccededNotification();
            else
                view.addingEmployeeFailedNotification();
        }
        else
        {
            view.invalidOptionNotification();
            enterEmployee();
        }
    }

    private static boolean enterDirector()
    {
        Director director = new Director();
        setBasicEmployeeData(director);
        setDirectorData(director);

        return saveEmployee(director);
    }

    private static boolean enterTrader()
    {
        Trader trader = new Trader();
        setBasicEmployeeData(trader);
        setTraderData(trader);

        return saveEmployee(trader);
    }



    private static void setBasicEmployeeData(Employee employee)
    {
        String pesel = UserInput.getPeselFromInput();
        if(model.findEmployeeByPesel(pesel) == null)
        {
            employee.setPesel(pesel);
        }
        else
        {
            view.employeeAlreadyExists();
            setBasicEmployeeData(employee);
        }

        employee.setName(UserInput.getNameFromInput());
        employee.setSurname(UserInput.getSurnameFromInput());
        employee.setPayment(UserInput.getPaymentFromInput());
        employee.setPhoneNumber(UserInput.getServicePhoneNumberFromInput());
    }

    private static void setDirectorData(Director director)
    {
        director.setPosition("Director");
        director.setServiceAllowance(UserInput.getServiceAllowanceFromInput());
        director.setServiceCardID(UserInput.getServiceCardIDFromInput());
        director.setCostLimitPerMonth(UserInput.getCostLimitPerMonthFromInput());
    }

    private static void setTraderData(Trader trader)
    {
        trader.setPosition("Trader");
        trader.setCommission(UserInput.getCommissionFromInput());
        trader.setCommissionLimit(UserInput.getCommissionLimitFromInput());
    }


    private static boolean saveEmployee(Employee employee)
    {
        view.saveOrCancelLabel();
        String option = scanner.next();

        if(option.equals("s"))
        {
            model.insertEmployeeToRegister(employee);
            return true;
        }
        else if(option.equals("c"))
        {
            return false;
        }

        view.invalidOptionNotification();
        return saveEmployee(employee);
    }



    private static void deletingEmployeeWindow()
    {
        view.deleteEmployeeLabel();
        Employee employee = findAndDisplayEmployee();

        if(employee != null)
        {
            if(deleteEmployee(employee))
            {
                view.deletingEmployeeSuccededNotification();
            }
            else
            {
                view.deletingEmployeeFailedNotification();
            }
        }
    }

    private static Employee findAndDisplayEmployee()
    {
        if(!model.isRegisterEmpty())
        {
            String pesel = UserInput.getPeselFromInput();
            Employee employee = model.findEmployeeByPesel(pesel);

            if (employee != null)
            {
                view.displayEmployee(employee);
            } else {
                view.employeeNotFoundNotification();
            }

            return employee;
        }

        view.emptyRegisterNotification();
        return null;
    }

    private static boolean deleteEmployee(Employee employee)
    {
        view.deleteOrCancelLabel();
        String option = scanner.next();

        if(option.equals("d") && model.deleteEmployee(employee))
        {
            return true;
        }
        else if(option.equals("c") || !model.deleteEmployee(employee))
        {
            return false;
        }

        view.invalidOptionNotification();
        return  deleteEmployee(employee);
    }
}
