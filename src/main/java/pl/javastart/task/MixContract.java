package pl.javastart.task;

import static java.lang.Math.abs;

class MixContract extends CardContract {
    private int smsNumber;
    private int mmsNumber;
    private int callMinutesNumber;

    MixContract(double accountBalance, double smsCost, double mmsCost, double oneMinuteCallCost,
                int smsNumber, int mmsNumber, int callMinutesNumber) {
        super(accountBalance, smsCost, mmsCost, oneMinuteCallCost);
        this.smsNumber = smsNumber;
        this.mmsNumber = mmsNumber;
        this.callMinutesNumber = callMinutesNumber;
    }

    @Override
    boolean sendSms() {
        if (smsCounter < smsNumber) {
            smsCounter++;
            return true;
        }
        return super.sendSms();
    }

    @Override
    boolean sendMms() {
        if (mmsCounter < mmsNumber) {
            mmsCounter++;
            return true;
        }
        return super.sendMms();
    }

    @Override
    int call(int seconds) {
        int diff = callMinutesNumber * 60 - seconds;
        if (diff < 0) {
            int packetSeconds = takeFromPacket(callMinutesNumber * 60);
            return (super.call((abs(diff))) + packetSeconds);
        } else {
            return takeFromPacket(seconds);
        }
    }

    private int takeFromPacket(int seconds) {
        if (seconds % 60 == 0) {
            callMinutesNumber -= seconds / 60;
        } else if (seconds % 60 > 0) {
            callMinutesNumber -= (int) (seconds / 60) + 1;
        }
        totalCallsTime += seconds;
        return seconds;
    }
}

