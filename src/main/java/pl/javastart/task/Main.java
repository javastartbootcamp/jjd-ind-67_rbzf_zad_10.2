package pl.javastart.task;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new CardContract(2, .1, .2, .5));

        phone.printAccountState();
        phone.call(120);
        phone.sendMms();
        phone.sendSms();
        phone.sendMms();
        phone.printAccountState();

        Phone phone1 = new Phone(new CardContract(3, .1, .2, .5));
        phone1.printAccountState();
        phone1.call(40);
        phone1.sendMms();
        phone1.sendSms();
        phone1.sendMms();
        phone1.printAccountState();

    }
}
