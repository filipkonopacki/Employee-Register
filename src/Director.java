import java.math.BigDecimal;

public class Director extends Employee {

    private BigDecimal serviceAllowance;
    private String serviceCardID;
    private BigDecimal costLimitPerMonth;



    public void setServiceAllowance(BigDecimal serviceAllowance) {
        this.serviceAllowance = serviceAllowance;
    }

    public void setServiceCardID(String serviceCardID) {
        this.serviceCardID = serviceCardID;
    }

    public void setCostLimitPerMonth(BigDecimal costLimitPerMonth) {
        this.costLimitPerMonth = costLimitPerMonth;
    }


    public BigDecimal getServiceAllowance() {
        return serviceAllowance;
    }

    public String getServiceCardID() {
        return serviceCardID;
    }

    public BigDecimal getCostLimitPerMonth() {
        return costLimitPerMonth;
    }
}
