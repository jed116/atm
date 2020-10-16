import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("* * * Всего в банкомате ДС: " + atm.getMoneyTotal() + " * * *");
            System.out.print("Внести (+ДС) / Cнять (-ДС) или 0 для завершения: ");
            int value = scanner.nextInt();
            if (value == 0) {
                break;
            }
            if (atm.putMoney(value)) {
                continue;
            }
            if (!atm.takeMoney(value * (-1))) {
                System.out.println("! ! ! Не достаточно ДС в банкомате ! ! !");
            }
        }
        scanner.close();
    }
}
