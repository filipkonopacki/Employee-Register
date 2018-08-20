import java.math.BigDecimal;

public class Trader extends Employee {

    private double commission;
    private BigDecimal commissionLimit;



    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void setCommissionLimit(BigDecimal commissionLimit) {
        this.commissionLimit = commissionLimit;
    }


    public double getCommission() {
        return commission;
    }

    public BigDecimal getCommissionLimit() {
        return commissionLimit;
    }
}
