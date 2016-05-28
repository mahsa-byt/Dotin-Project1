public class ShortTerm extends Deposits {

    int     interestRate        =      10;
    float   payedInterest       =       0;

    public float  PayedInterest(){
        payedInterest       =       (interestRate*durationInDays*depositeBalance)/36500;
        return payedInterest;
    }
}
