import java.math.BigDecimal;

public class Deposit implements Comparable<Deposit> {
    private int customerNumber;
    private BigDecimal depositBalance;
    private int durationInDays;
    private BigDecimal payedInterest;
    private DepositType depositType;

    public Deposit(int customerNumber, BigDecimal depositBalance, int durationInDays, BigDecimal payedInterest, DepositType depositType) {
        this.customerNumber = customerNumber;
        this.depositBalance = depositBalance;
        this.durationInDays = durationInDays;
        this.payedInterest = payedInterest;
        this.depositType = depositType;

    }

    public Deposit() {

    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setDepositBalance(BigDecimal depositeBalance) {
        this.depositBalance = depositeBalance;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public BigDecimal getDepositBalance() {
        return depositBalance;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public BigDecimal getPayedInterest() {
        return payedInterest;
    }

    public void setPayedInterest(BigDecimal payedInterest) {
        this.payedInterest = payedInterest;
    }

    public void calculatePayedInterest() {
        payedInterest = depositBalance.multiply(new BigDecimal(durationInDays))
                .multiply(new BigDecimal(depositType.getInterestRate()))
                .divide(new BigDecimal(36500), 10, BigDecimal.ROUND_FLOOR);
    }

    @Override
    public int compareTo(Deposit comparableDeposit) {
        return comparableDeposit.payedInterest.compareTo(this.payedInterest);
    }

}
