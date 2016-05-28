public class Qarz extends Deposits {

    int     interestRate        =       0;
    float   payedInterest       =       0;

    public float  PayedInterest(){
        payedInterest       =       (interestRate*durationInDays*depositeBalance)/36500;
        return payedInterest;
    }
}
