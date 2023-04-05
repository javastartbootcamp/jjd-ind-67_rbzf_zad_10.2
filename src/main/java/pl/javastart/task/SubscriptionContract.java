package pl.javastart.task;

class SubscriptionContract extends Contract {
    private double monthlyPayment;

    public SubscriptionContract(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    boolean sendSms() {
        smsCounter++;
        return true;
    }

    @Override
    boolean sendMms() {
        mmsCounter++;
        return true;
    }

    @Override
    int call(int seconds) {
        totalCallsTime += seconds;
        return seconds;
    }

    @Override
    void printAccountState() {
        super.printAccountState();
        System.out.println("Miesieczna oplata " + monthlyPayment + " zł");
        System.out.println("==================");
    }
}
