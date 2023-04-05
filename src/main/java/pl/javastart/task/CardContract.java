package pl.javastart.task;

class CardContract extends Contract {
    protected double accountBalance;
    private double smsCost;
    private double mmsCost;
    protected double oneMinuteCallCost;

    CardContract(double accountBalance, double smsCost, double mmsCost, double oneMinuteCallCost) {
        this.accountBalance = accountBalance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.oneMinuteCallCost = oneMinuteCallCost;
    }

    @Override
    boolean sendSms() {
        if (smsCost <= accountBalance) {
            smsCounter++;
            accountBalance -= smsCost;
            return true;
        } else {
            return false;
        }
    }

    @Override
    boolean sendMms() {
        if (mmsCost <= accountBalance) {
            mmsCounter++;
            accountBalance -= mmsCost;
            return true;
        } else {
            return false;
        }
    }

    @Override
    int call(int seconds) {
        if (accountBalance <= 0) {
            return 0;
        } else if ((seconds / 60.) <= (accountBalance / oneMinuteCallCost)) {
            accountBalance -= (seconds / 60.) * oneMinuteCallCost;
            totalCallsTime += seconds;
            return seconds;
        } else {
            int callTime = (int) (accountBalance / oneMinuteCallCost) * 60;
            totalCallsTime += callTime;
            accountBalance = 0;
            return callTime;
        }
    }

    @Override
    void printAccountState() {
        super.printAccountState();
        System.out.printf("Na koncie jest aktualnie %.2f zł\n", accountBalance);
        System.out.println("==================");
    }
}
