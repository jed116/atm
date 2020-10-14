public class Card {
    private int id;
    private String name;
    private int summ;

    public Card(int id, String name, int summ) {
        this.id = id;
        this.name = name;
        this.summ = summ;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }
}
