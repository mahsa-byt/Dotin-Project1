public class LongTerm extends Deposit {

    int interestRate = 20;
    float payedInterest = 0;

    public float PayedInterest() {
        payedInterest = (interestRate * durationInDays * depositeBalance) / 36500;
        return payedInterest;
    }
}
