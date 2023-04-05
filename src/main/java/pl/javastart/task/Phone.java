package pl.javastart.task;

class Phone {
    private Contract contract;

    Phone(Contract contract) {
        this.contract = contract;
    }

    void sendSms() {
        if (contract.sendSms()) {
            System.out.println("SMS wyslany");
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }
    }

    void sendMms() {
        if (contract.sendMms()) {
            System.out.println("MMS wyslany");
        } else {
            System.out.println("Nie udało się wysłać MMSa");
        }
    }

    void call(int seconds) {
        int callDuration = contract.call(seconds);
        if (callDuration == 0) {
            System.out.println("Brak mozliwosci przeprowadzenia rozmowy.");
        } else if (callDuration == seconds) {
            System.out.println("Rozmowa trwala " + seconds + " sek.");
        } else if (callDuration < seconds) {
            int diff = seconds - callDuration;
            System.out.println("Rozmowa zostala przerwana po " + callDuration + " sek.");
        }
    }

    void printAccountState() {
        contract.printAccountState();
    }
}
