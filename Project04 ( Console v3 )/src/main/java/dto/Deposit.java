package dto;

import java.math.BigDecimal;

public class Deposit {


    private String depositNumber;
    private BigDecimal amount;

    public String getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return depositNumber + "\t" + amount;
    }
}
