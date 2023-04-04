package pl.javastart.task;

class SubscriptionContract extends Contract {
    private double monthlyPayment;

    public SubscriptionContract(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    void sendSms() {
        System.out.println("SMS wyslany");
        smsCounter++;
    }

    @Override
    void sendMms() {
        mmsCounter++;
    }

    @Override
    void call(int seconds) {
        System.out.println("Rozmowa trwala " + seconds + " sekund.");
        totalCallsTime += seconds;
    }

    @Override
    void printAccountState() {
        super.printAccountState();
        System.out.println("Miesieczna oplata " + monthlyPayment + " zł");
        System.out.println("==================");
    }
}
