package pl.javastart.task;

class CardContract extends Contract {
    private double accountBalance;
    private double smsCost;
    private double mmsCost;
    private double oneMinuteCallCost;

    CardContract(double accountBalance, double smsCost, double mmsCost, double oneMinuteCallCost) {
        this.accountBalance = accountBalance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.oneMinuteCallCost = oneMinuteCallCost;
    }

    @Override
    void sendSms() {
        if (smsCost <= accountBalance) {
            System.out.println("SMS wyslany");
            smsCounter++;
            accountBalance -= smsCost;
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }
    }

    @Override
    void sendMms() {
        if (mmsCost <= accountBalance) {
            System.out.println("MMS wyslany");
            mmsCounter++;
            accountBalance -= mmsCost;
        } else {
            System.out.println("Nie udało się wysłać MMSa");
        }
    }

    @Override
    void call(int seconds) {
        if (accountBalance <= 0) {
            System.out.println("Brak srodkow na koncie.");
        } else if ((seconds / 60.) <= (accountBalance / oneMinuteCallCost)) {
            System.out.println("Rozmowa trwala " + seconds + " sekund.");
            accountBalance -= (seconds / 60.) * oneMinuteCallCost;
            totalCallsTime += seconds;
        } else {
            System.out.println("Rozmowa trwala " + (accountBalance / oneMinuteCallCost) * 60  + " sek. " +
                    "i zostala przerwana z powodu braku srodkow na koncie");
            totalCallsTime += (accountBalance / oneMinuteCallCost) * 60;
            accountBalance = 0;
        }
    }

    @Override
    void printAccountState() {
        super.printAccountState();
        System.out.printf("Na koncie zostało %.2f zł\n", accountBalance);
        System.out.println("==================");
    }
}
