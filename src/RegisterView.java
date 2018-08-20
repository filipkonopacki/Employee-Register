class RegisterView {
    public enum ErrorCode
    {
        INVALID_OPTION, INVALID_PESEL, INVALID_NAME, INVALID_SURNAME, INVALID_PAYMENT, INVALID_PHONE_NUMBER,
        INVALID_SERVICE_ALLOWANCE, INVALID_COST_LIMIT, INVALID_COMMISSION, INVALID_COMMISSION_LIMIT

    }

    public enum NotificationCode
    {
        ADD_EMPLOYEE_SUCCESS, ADD_EMPLOYEE_FAIL, DELETE_EMPLOYEE_SUCCESS, DELETE_EMPLOYEE_FAIL, EMPLOYEE_NOT_FOUND,
        EMPLOYEE_EXISTS, EMPTY_REGISTER
    }

    public enum PromptCode
    {
        ENTER_EMPLOYEE_TYPE, ENTER_PESEL, ENTER_NAME, ENTER_SURNAME, ENTER_PAYMENT, ENTER_PHONE_NUMBER,
        ENTER_SERVICE_ALLOWANCE, ENTER_CARD_ID, ENTER_COST_LIMIT, ENTER_COMMISSION, ENTER_COMMISSION_LIMIT,
        SAVE, DELETE, NEXT
    }

    public enum PageContentCode
    {
        MENU, REGISTER_LABEL, ENTER_EMPLOYEE_LABEL, DELETE_EMPLOYEE_LABEL
    }



    public void pageNumber(int currentPage, int numberOfPages)
    {
        System.out.printf("%-30s %-1s %-1s", "", "\t\t", "[Page:" + (currentPage) + "/" + numberOfPages + "]\n");
    }


    void pageContent(PageContentCode pageContentCode)
    {
        switch (pageContentCode)
        {
            case MENU:
                System.out.println("Menu\n\t1. Employee register\n\t2. Enter employee\n\t3. Delete employee\n\t4. Backup\n\t5. Quit\n\nOption> ");
                break;
            case REGISTER_LABEL:
                System.out.println("1. Employee register");
                break;
            case ENTER_EMPLOYEE_LABEL:
                System.out.println("2. Enter employee");
                break;
            case DELETE_EMPLOYEE_LABEL:
                System.out.println("3. Delete employee\t");
                break;
        }
    }

    void errorMessage(ErrorCode errorCode)
    {
        switch (errorCode)
        {
            case INVALID_OPTION:
                System.out.println("Invalid option!");
                break;
            case INVALID_PESEL:
                System.out.println("Entered pesel is invalid. Please enter pesel again.");
                break;
            case INVALID_NAME:
                System.out.println("Entered name is invalid. Please enter name again.");
                break;
            case INVALID_SURNAME:
                System.out.println("Entered surname is invalid. Please enter surname again.");
                break;
            case INVALID_PAYMENT:
                System.out.println("Entered payment format is invalid. Please enter payment again.");
                break;
            case INVALID_PHONE_NUMBER:
                System.out.println("Entered service phone number is invalid. Please enter service phone number again.");
                break;
            case INVALID_SERVICE_ALLOWANCE:
                System.out.println("Entered service allowance format is invalid. Please enter service allowance again.");
                break;
            case INVALID_COST_LIMIT:
                System.out.println("Entered cost limit per month is invalid. Please enter cost limit per month again.");
                break;
            case INVALID_COMMISSION:
                System.out.println("Entered commission is invalid. Please enter commission again.");
                break;
            case INVALID_COMMISSION_LIMIT:
                System.out.println("Entered commission limit is invalid. Please enter commission limit again.");
                break;
        }
    }

    void notificationMessage(NotificationCode notificationCode)
    {
        switch (notificationCode)
        {
            case ADD_EMPLOYEE_FAIL:
                System.out.println("Adding employee failed. Try again.");
                break;
            case ADD_EMPLOYEE_SUCCESS:
                System.out.println("Employee added successfully.");
                break;
            case DELETE_EMPLOYEE_FAIL:
                System.out.println("Deleting employee failed.");
                break;
            case DELETE_EMPLOYEE_SUCCESS:
                System.out.println("Employee deleted successfully.");
                break;
            case EMPLOYEE_NOT_FOUND:
                System.out.println("Employee not found.");
                break;
            case EMPLOYEE_EXISTS:
                System.out.println("Employee already exists.");
                break;
            case EMPTY_REGISTER:
                System.out.println("Employee register is empty. Add new employee.");
                break;
        }
    }

    void promptMessage(PromptCode promptCode)
    {
        switch (promptCode)
        {
            case ENTER_EMPLOYEE_TYPE:
                System.out.println("\n\n[D]irector/[T]rader:\t");
                break;
            case ENTER_PESEL:
                System.out.printf("%-30s %-1s", "\tPESEL identifier", ":\t");
                break;
            case ENTER_NAME:
                System.out.printf("%-30s %1s", "\tName", ":\t");
                break;
            case ENTER_SURNAME:
                System.out.printf("%-30s %1s", "\tSurname", ":\t");
                break;
            case ENTER_PAYMENT:
                System.out.printf("%-30s %1s", "\tPayment (PLN)", ":\t");
                break;
            case ENTER_PHONE_NUMBER:
                System.out.printf("%-30s %1s", "\tService phone number", ":\t");
                break;
            case ENTER_SERVICE_ALLOWANCE:
                System.out.printf("%-30s %1s", "\tService allowance (PLN)", ":\t");
                break;
            case ENTER_CARD_ID:
                System.out.printf("%-30s %1s", "\tService card ID", ":\t");
                break;
            case ENTER_COST_LIMIT:
                System.out.printf("%-30s %1s", "\tCost limit per month (PLN)", ":\t");
                break;
            case ENTER_COMMISSION:
                System.out.printf("%-30s %1s", "\tCommission (%)", ":\t");
                break;
            case ENTER_COMMISSION_LIMIT:
                System.out.printf("%-30s %1s", "\tCommission limit per month (PLN)", ":\t");
                break;
            case SAVE:
                System.out.print("\n\n[s] - save\n[c] - cancel\nOption>");
                break;
            case DELETE:
                System.out.print("\n\n[d] - delete\n[c] - cancel\nOption>");
                break;
            case NEXT:
                System.out.print("\n\n[n] - next\n[c] - cancel\nOption>");
                break;
        }
    }



    void displayEmployee(Employee employee){
        if (employee instanceof Director)
        {
            Director director = (Director) employee;
            displayDirectorData(director);
        }
        else if (employee instanceof Trader)
        {
            Trader trader = (Trader) employee;
            displayTraderData(trader);
        }
    }

    private void displayDirectorData(Director director)
    {
        displayBasicEmployeeData(director);
        System.out.printf("%-30s %-1s %-1s", "Service allowance (PLN)", ":\t", director.getServiceAllowance() + "\n");
        System.out.printf("%-30s %-1s %-1s", "Service card ID", ":\t", director.getServiceCardID() + "\n");
        System.out.printf("%-30s %-1s %-1s", "Cost limit per month (PLN)", ":\t", director.getCostLimitPerMonth() + "\n");
    }

    private void displayTraderData(Trader trader)
    {
        displayBasicEmployeeData(trader);
        System.out.printf("%-30s %-1s %-1s", "Commission (%)", ":\t", trader.getCommission() + "\n");
        System.out.printf("%-30s %-1s %-1s", "Commission limit per month (PLN)", ":\t", trader.getCommissionLimit() + "\n");
    }

    private void displayBasicEmployeeData(Employee employee){
        System.out.printf("%-30s %-1s %-1s","PESEL identifier",":\t",employee.getPesel() + "\n");
        System.out.printf("%-30s %-1s %-1s","Name",":\t",employee.getName()+ "\n");
        System.out.printf("%-30s %-1s %-1s","Surname",":\t",employee.getSurname()+ "\n");
        System.out.printf("%-30s %-1s %-1s","Position",":\t",employee.getPosition()+ "\n");
        System.out.printf("%-30s %-1s %-1s","Payment (PLN)",":\t",employee.getPayment()+ "\n");
        System.out.printf("%-30s %-1s %-1s","Service phone number",":\t",employee.getPhoneNumber()+ "\n");
    }
}
