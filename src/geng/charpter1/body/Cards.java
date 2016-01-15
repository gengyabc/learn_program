package geng.charpter1.body;

/**
 * Created by yu on 2016-1-12.
 */
public class Cards {

    private int numCards;
    private int suitLength;
    private int rankLength;
    private String deck[];

    public String[] suit;
    public String[] rank;

    public Cards () {
        suit = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};
        rank = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "11", "12", "13"};
        suitLength = suit.length;
        rankLength = rank.length;
        numCards = suitLength * rankLength;
        deck = new String[numCards];
        formDeck();
    }

    public void printRadomCard() {
        String color = suit[(int)(Math.random() * 4)];
        String num = rank[(int)(Math.random() * 13)];
        System.out.println(num + " of " + color);
    }

    private void formDeck() {
        for (int i = 0; i < rankLength; i++) {
            for (int j = 0; j < suitLength; j++) {
                deck[suitLength * i + j] = rank[i] + " of " + suit[j];
            }
        }
    }

    public void printDeck() {
        for(int i = 0; i < numCards; i ++) {
            System.out.print(deck[i] + ", ");
            if ( (i + 1) % 4 == 0) System.out.println();
        }
    }

    public void shuffle() {
        for(int i = 0; i < numCards; i ++) {
            // from i to numCards - 1
            int randomIndex = i + (int)(Math.random() * numCards - i);
            String tmp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = tmp;
        }
    }

    public void sample(int n) {
        if (n > numCards) System.out.println("no more than " + numCards);
        else {
            for(int i = 0; i < n; i ++) {
                int randomIndex = i + (int)(Math.random() * numCards - i);
                String tmp = deck[i];
                deck[i] = deck[randomIndex];
                deck[randomIndex] = tmp;
                System.out.println(deck[i]);
            }
        }
    }

    /**
     * Find how many times should try to collect all the first n cards
     * @param n the first n of cards what to collect
     */
    public void couponCollector(int n) {
        if (n > numCards) System.out.println("no more than " + numCards);
        else {
            boolean isCardFound[] = new boolean[n];
            boolean isAllFound = false;
            int numTry = 0;
            int numToFind = n;
            while( !isAllFound){
                numTry ++;
                int randomIndex = (int)(Math.random() * numCards);
                if (randomIndex < n) {
                    if (isCardFound[randomIndex] == false) {
                        isCardFound[randomIndex] = true;
                        numToFind --;
                    }
                }
                if (numToFind == 0) isAllFound = true;
            }
            System.out.println(numTry);
        }
    }
}
