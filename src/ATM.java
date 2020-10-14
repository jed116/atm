public class ATM{
    private Card currentCard = null;
    private String lastOperationName = "";
    private int lastOperationNumber = 0;
    private Card[] cardsArray;

    public ATM(Card[] cardsArray) {
        this.cardsArray = cardsArray;
    }

    public boolean  setCurrentCard(int id) {
        boolean result = false;
        this.currentCard = null;
        if (id == 0){
            result = true;
        }
        for(Card card : cardsArray) {
            if (card.getId() == id){
                this.currentCard = card;
                result = true;
                break;
            }
        }
        return result;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public String getLastOperationName() {
        return lastOperationName;
    }

    public int getLastOperationNumber() {
        return lastOperationNumber;
    }

    public boolean makeOperation(int value){
        boolean result = false;
        if (value == 0){
            setCurrentCard(0);
            result = true;
            lastOperationName = " завершения ";
        }
        if (value> 0){
            result = putMoney(value * 1);
            lastOperationName = " внесения ДС ";
        }
        if (value < 0){
            result = takeMoney(value * (-1));
            lastOperationName = " снятия ДС ";
        }
        lastOperationNumber = lastOperationNumber + 1;
        return result;
    }

    private boolean putMoney(int moneyValue){
        if (this.currentCard == null){
            return false;
        }
        this.currentCard.setSumm(this.currentCard.getSumm() + moneyValue);
        return true;
    }

    private boolean takeMoney(int moneyValue){
        if (this.currentCard == null){
            return false;
        }
        if (this.currentCard.getSumm() < moneyValue){
            return false;
        }
        this.currentCard.setSumm(this.currentCard.getSumm() - moneyValue);
        return true;
    }
}
