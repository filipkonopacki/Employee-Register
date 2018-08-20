import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

class UserInput {
    private static RegisterView view = new RegisterView();
    private static Scanner scanner = new Scanner(System.in);


    static String getPesel()
    {
        view.promptMessage(RegisterView.PromptCode.ENTER_PESEL);
        String pesel = scanner.next();
        if(isPeselValid(pesel))
            return pesel;

        view.errorMessage(RegisterView.ErrorCode.INVALID_PESEL);
        return getPesel();
    }

    private static boolean isPeselValid(String pesel)
    {
        return Pattern.matches("[0-9]{11}", pesel);

    }


    static String getName()
    {
        view.promptMessage(RegisterView.PromptCode.ENTER_NAME);
        String name = scanner.next();

        if(isNameOrSurnameValid(name))
            return name;

        view.errorMessage(RegisterView.ErrorCode.INVALID_NAME);
        return getName();
    }

    static String getSurname()
    {
        view.promptMessage(RegisterView.PromptCode.ENTER_SURNAME);
        String surname = scanner.next();

        if(isNameOrSurnameValid(surname))
            return surname;

        view.errorMessage(RegisterView.ErrorCode.INVALID_SURNAME);
        return getSurname();
    }

    private static boolean isNameOrSurnameValid(String nameOrSurname)
    {
        return (Pattern.matches("[A-Z][a-z]*",nameOrSurname));
    }


    static BigDecimal getPayment()
    {
        view.promptMessage(RegisterView.PromptCode.ENTER_PAYMENT);

        try
        {
            BigDecimal payment = scanner.nextBigDecimal();
            return payment;
        }
        catch (InputMismatchException exception)
        {
            view.errorMessage(RegisterView.ErrorCode.INVALID_PAYMENT);
            scanner.next();
            return getPayment();
        }
    }


    static String getServicePhoneNumber()
    {
        view.promptMessage(RegisterView.PromptCode.ENTER_PHONE_NUMBER);
        String servicePhoneNumber = scanner.next();

        if(isServicePhoneNumberValid(servicePhoneNumber))
            return servicePhoneNumber;

        view.errorMessage(RegisterView.ErrorCode.INVALID_PHONE_NUMBER);
        return getServicePhoneNumber();

    }

    private static boolean isServicePhoneNumberValid(String servicePhoneNumber)
    {
        return servicePhoneNumber.length() == 9;

    }


    static BigDecimal getServiceAllowance()
    {
        view.promptMessage(RegisterView.PromptCode.ENTER_SERVICE_ALLOWANCE);

        try
        {
            BigDecimal serviceAllowance = scanner.nextBigDecimal();
            return serviceAllowance;
        }
        catch (InputMismatchException exception)
        {
            view.errorMessage(RegisterView.ErrorCode.INVALID_SERVICE_ALLOWANCE);
            scanner.next();
            return getServiceAllowance();
        }
    }



    static String getServiceCardID()
    {
        view.promptMessage(RegisterView.PromptCode.ENTER_CARD_ID);
        String serviceCardID = scanner.next();

        /*TODO service card ID validation if needed*/

        return serviceCardID;
    }


    static double getCommission()
    {
        view.promptMessage(RegisterView.PromptCode.ENTER_COMMISSION);
        double commission = scanner.nextDouble();

        if(isCommissionValid(commission))
            return commission;

        view.errorMessage(RegisterView.ErrorCode.INVALID_COMMISSION);
        return getCommission();
    }

    private static boolean isCommissionValid(double commission)
    {
        return !(commission < 0 || commission > 100);
    }


    static BigDecimal getCommissionLimit()
    {
        view.promptMessage(RegisterView.PromptCode.ENTER_COMMISSION_LIMIT);

        try {
            BigDecimal commissionLimit = scanner.nextBigDecimal();
            return commissionLimit;
        }
        catch (InputMismatchException exception)
        {
            view.errorMessage(RegisterView.ErrorCode.INVALID_COMMISSION_LIMIT);
            scanner.next();
            return getCommissionLimit();
        }
    }


    static BigDecimal getCostLimitPerMonth()
    {
        view.promptMessage(RegisterView.PromptCode.ENTER_COST_LIMIT);

        try
        {
            BigDecimal costLimitPerMonth = scanner.nextBigDecimal();
            return costLimitPerMonth;
        }
        catch (InputMismatchException exception)
        {
            view.errorMessage(RegisterView.ErrorCode.INVALID_COST_LIMIT);
            scanner.next();
            return getCostLimitPerMonth();
        }
    }
}
