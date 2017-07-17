package project_3;

import java.io.File;
import java.util.ArrayList;

public class GameLogic extends Deck{
    
    public GameLogic(String cardname, File file) {
        super(cardname,file);
        NewCardDeck();
        DrawPile();
    }
    
    public void StartGame() {
        
    }
    
    public void HandCards(ArrayList cards) { // Function to hand out cards to player and computer.
        for(int i = 0; i < 4; i++) {
            cards.add(getDrawPile().pop());
        }
    }
    
    public void GameTurn(int turn) { //Function to decide who should play next.
        if (turn == 1) {
            // computer plays next.
        } else {
            // player plays next.
        }
    }
    
    public boolean hasWon(ArrayList<Deck> deck) { // Function to check whether the player or the computer haswon the game;
        boolean haswon = false;
        String testcard = "";
        testcard = deck.get(0).getCardName();
        
        for(Deck checkcard : deck) {
            if (testcard.substring(0, (testcard.length() - 1)).equalsIgnoreCase(checkcard.getCardName().substring(0, (checkcard.getCardName().length() - 1)))) {
                haswon = true;
            } else {
                haswon = false;
                break;
            }
        }
        return haswon;
    }

}
