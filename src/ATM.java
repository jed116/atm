public class ATM {
    private int moneyTotal;

    public ATM() {
        moneyTotal = 0;
    }

    public int getMoneyTotal() {
        return moneyTotal;
    }

    public boolean putMoney(int moneyValue) {
        if (moneyValue < 0) {
            return false;
        }
        moneyTotal += moneyValue;
        return true;
    }

    public boolean takeMoney(int moneyValue) {
        if (moneyValue > moneyTotal) {
            return false;
        }
        moneyTotal -= moneyValue;
        return true;
    }
}
