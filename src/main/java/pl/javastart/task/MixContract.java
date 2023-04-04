package pl.javastart.task;

class MixContract extends Contract {
    private int smsNumber;
    private int mmsNumber;
    private int callMinutesNumber;
    private double accountBalance;
    private double smsCost;
    private double mmsCost;
    private double oneMinuteCallCost;

    MixContract(int smsNumber, int mmsNumber, int callMinutesNumber,
                       double accountBalance, double smsCost, double mmsCost, double oneMinuteCallCost) {
        this.smsNumber = smsNumber;
        this.mmsNumber = mmsNumber;
        this.callMinutesNumber = callMinutesNumber;
        this.accountBalance = accountBalance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.oneMinuteCallCost = oneMinuteCallCost;
    }

    @Override
    void sendSms() {
        if (smsCounter < smsNumber) {
            System.out.println("SMS wyslany");
            smsCounter++;
        } else if (smsCost <= accountBalance) {
            System.out.println("SMS wyslany");
            accountBalance -= smsCost;
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }
    }

    @Override
    void sendMms() {
        if (mmsCounter < mmsNumber) {
            System.out.println("MMS wyslany");
            mmsCounter++;
        } else if (mmsCost <= accountBalance) {
            System.out.println("MMS wyslany");
            accountBalance -= mmsCost;
        } else {
            System.out.println("Nie udało się wysłać MMSa");
        }
    }

    @Override
    void call(int seconds) {
        if ((seconds / 60.) <= callMinutesNumber) {
            takeFromDefaultMinutesCall(seconds);
        }
        if ((seconds / 60.) > callMinutesNumber) {
            takeFromBalanceCall(seconds);
        }
    }

    private void takeFromDefaultMinutesCall(int seconds) {
        System.out.println("Rozmowa trwala " + seconds + " sek.");
        if (seconds % 60 == 0) {
            callMinutesNumber -= seconds / 60;
        } else if (seconds % 60 > 0) {
            callMinutesNumber -= (seconds / 60) + 1;
        }
    }

    private void takeFromBalanceCall(int seconds) {
        if (accountBalance <= 0) {
            System.out.println("Brak srodkow na koncie.");
        } else if ((seconds / 60.) <= (accountBalance / oneMinuteCallCost)) {
            System.out.println("Rozmowa trwala " + seconds + " sek.");
            accountBalance -= (seconds / 60.) * oneMinuteCallCost;
            totalCallsTime += seconds;
        } else {
            System.out.println("Rozmowa trwala " + (accountBalance / oneMinuteCallCost) * 60 + " sek. " +
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

