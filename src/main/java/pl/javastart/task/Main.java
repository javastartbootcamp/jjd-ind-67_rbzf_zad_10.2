package pl.javastart.task;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new MixContract(1, .1, .5, .5, 2, 1, 1));

        phone.printAccountState();
        phone.call(189);
        phone.sendMms();
        phone.sendSms();
        phone.sendMms();
        phone.printAccountState();

        Phone phone1 = new Phone(new SubscriptionContract(10.));
        phone1.printAccountState();
        phone1.call(40);
        phone1.sendMms();
        phone1.sendSms();
        phone1.sendMms();
        phone1.printAccountState();

    }
}
