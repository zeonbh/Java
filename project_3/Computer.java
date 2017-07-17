package project_3;

import java.io.File;
import java.util.ArrayList;

public class Computer extends GameLogic{
    private ArrayList<Deck> computercards= new ArrayList<>();
    
    public Computer(String cardname, File file) {
        super(cardname, file);
        HandCards(computercards);
    }
    
    public ArrayList<Deck> getComputerCards() {
        return computercards;
    } 

}
