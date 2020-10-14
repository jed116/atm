import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Card[] cardsArray = new Card[3];
        cardsArray[0] = new Card(1, "Эдик", 100);
        cardsArray[1] = new Card(2, "Вася", 10);
        cardsArray[2] = new Card(3, "Миша", 1);

        ATM atm = new ATM(cardsArray);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            if (atm.getCurrentCard() == null){
                System.out.println("* * * * * * * * * * * * * * * * * * *");
                System.out.print("Введите номер карты или 0 для выхода: ");
                int cardId = scanner.nextInt();
                if (cardId == 0) {
                    exit = true;
                }
                if (!atm.setCurrentCard(cardId) && !exit){
                    System.out.println("Карта № "+cardId+" не обслуживается!");
                }
            }else{
                System.out.println("Текущуй остаток по карте № "+ atm.getCurrentCard().getId() + " (владелец "+ atm.getCurrentCard().getName()+"): "+ atm.getCurrentCard().getSumm());
                System.out.print("Внести (+) / снять (-) ДС или 0 для завершения: ");
                int summ = scanner.nextInt();

                boolean resultOperation = atm.makeOperation(summ);
                String nameOperation = atm.getLastOperationName();
                int numberOperation = atm.getLastOperationNumber();

                System.out.println(numberOperation + ") " + (!resultOperation ? "Не возможно выполнить операцию " + nameOperation +" !!!" : "Операция" + nameOperation + "выполнена успешно!!!"));
            }
        }
        scanner.close();
    }
}
