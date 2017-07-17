package project_3;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Player extends GameLogic{
    private ArrayList<Deck> playercards = new ArrayList<>();
    private ArrayDeque<Deck> playertempcard = new ArrayDeque<>();
    
    public Player(String cardname, File file) {
        super(cardname,file);
        HandCards(playercards);
    }
    
    public ArrayList<Deck> getPlayerCards() {
        return playercards;
    }
    
    public ArrayDeque<Deck> getTempCard() {
        return playertempcard;
    }
    
    public void PlayerDrawPile() { // Function to draw card from Draw pile to player deck.
            playertempcard.offer(getDrawPile().pollLast());
    }
    
    public void PlayerDiscardPile() { // Function to draw card from Discard pile to player deck.
            playertempcard.offer(getDiscardPile().pollLast());
    }
    
    public void PlayerDiscardCard(String deck, int cardindex) { // Function to discard card.
        if(deck.equalsIgnoreCase("playertempdeck") && cardindex == -1 && !playertempcard.isEmpty()) {
            getDiscardPile().offer(playertempcard.pop());
        } else if(deck.equalsIgnoreCase("playerdeck")) {
            switch(cardindex) {
                case 0:
                    getDiscardPile().offer(playercards.get(cardindex));
                    playercards.set(cardindex, playertempcard.pop());
                    break;
                case 1:
                    getDiscardPile().offer(playercards.get(cardindex));
                    playercards.set(cardindex, playertempcard.pop());
                    break;
                case 2:
                    getDiscardPile().offer(playercards.get(cardindex));
                    playercards.set(cardindex, playertempcard.pop());
                    break;
                case 3:
                    getDiscardPile().offer(playercards.get(cardindex));
                    playercards.set(cardindex, playertempcard.pop());
                    break;
                default:
                    break;
            }
        }
    }

}
