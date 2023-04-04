package pl.javastart.task;

abstract class Contract {
    protected int smsCounter = 0;
    protected int mmsCounter = 0;
    protected int totalCallsTime = 0;

    abstract void sendSms();

    abstract void sendMms();

    abstract void call(int seconds);

    void printAccountState() {
        System.out.println("=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + smsCounter);
        System.out.println("Wysłanych MMSów: " + mmsCounter);
        System.out.println("Liczba sekund rozmowy: " + totalCallsTime);
    }
}
