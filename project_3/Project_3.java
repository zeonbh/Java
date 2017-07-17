
package project_3;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Project_3 extends Application{

    String cardname = "";
    File file = new File("");
    Deck gamedeck = new Deck(cardname, file);
    Player player = new Player(cardname, file);
    Computer computer = new Computer(cardname, file);
    
    // GUI Elements
    Image blank = new Image(getClass().getResource("Cards/card_blank.png").toExternalForm(), 400, 200, true, true);
    Image back = new Image(getClass().getResource("Cards/card_back.png").toExternalForm(), 400, 200, true, true);
    Button discardpilebutton = new Button();
    Button playertempbutton = new Button();
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage cardstage) throws Exception {
        BorderPane gameboard = new BorderPane();
        gameboard.setTop(ComputerDeck());
        gameboard.setCenter(PileDeck());
        gameboard.setBottom(PlayerDeck()); 
        
        Scene cardscene = new Scene(gameboard, 850, 650);
        cardstage.setScene(cardscene);
        cardstage.setTitle("Card Game");
        cardstage.show();
    }
    
    public HBox ComputerDeck() {
        HBox computerdeck = new HBox();
        
        Button computerbutton1 = new Button();
        computerbutton1.setGraphic(new ImageView(back));
        Button computerbutton2 = new Button();
        computerbutton2.setGraphic(new ImageView(back));
        Button computerbutton3 = new Button();
        computerbutton3.setGraphic(new ImageView(back));
        Button computerbutton4 = new Button();
        computerbutton4.setGraphic(new ImageView(back));
        
        computerdeck.getChildren().addAll(computerbutton1, computerbutton2, computerbutton3, computerbutton4);
        
        return computerdeck;
    }
    
    public HBox PileDeck() {
        HBox piledeck = new HBox();
        
        Alert pilealert = new Alert(AlertType.INFORMATION);
        pilealert.setHeaderText(null);
        pilealert.setTitle("Card Game");
        
        /*********************************** Draw Pile button Action *********************************/
        Button drawpilebutton = new Button();
        drawpilebutton.setGraphic(new ImageView(back));
        drawpilebutton.setOnAction(drawevent -> {
            if(player.getTempCard().isEmpty()) {
                player.PlayerDrawPile();
                Image tempcard = new Image(getClass().getResource(player.getTempCard().peek().getCardFile().toString()).toExternalForm(), 400, 200, true, true);
                playertempbutton.setGraphic(new ImageView(tempcard));
            } else {
                pilealert.setContentText("Card Already drawn from the deck.");
                pilealert.showAndWait();
            }
        });
        
        /*********************************** Discard Pile button Action *********************************/
        if(gamedeck.getDiscardPile().isEmpty()) {
            discardpilebutton.setGraphic(new ImageView(blank));
        }
        discardpilebutton.setOnAction(discardevent -> {
            if(player.getTempCard().isEmpty() && !player.getDiscardPile().isEmpty()) {
                player.PlayerDiscardPile();
                Image tempcard = new Image(getClass().getResource(player.getTempCard().peek().getCardFile().toString()).toExternalForm(), 400, 200, true, true);
                playertempbutton.setGraphic(new ImageView(tempcard));
                if(!player.getDiscardPile().isEmpty()) {
                Image nextcard = new Image(getClass().getResource(player.getDiscardPile().peekFirst().getCardFile().toString()).toExternalForm(), 400, 200, true, true);
                discardpilebutton.setGraphic(new ImageView(nextcard));
                } else {
                    discardpilebutton.setGraphic(new ImageView(blank));
                }
            } else if(player.getDiscardPile().isEmpty() && player.getTempCard().isEmpty()) {
                pilealert.setContentText("The discard pile is empty.");
                pilealert.showAndWait();
            } else {
                pilealert.setContentText("Card Already drawn from the deck.");
                pilealert.showAndWait();
            }
        });
        
        piledeck.getChildren().addAll(drawpilebutton, discardpilebutton);
        
        return piledeck;
    }
    
    public HBox PlayerDeck() {
        HBox playerdeck = new HBox();
        
        Button playerbutton1 = new Button();
        Image playercard1 = new Image(getClass().getResource(player.getPlayerCards().get(0).getCardFile().toString()).toExternalForm(), 400, 200, true, true);
        playerbutton1.setGraphic(new ImageView(playercard1));
        playerbutton1.setOnAction(playerbuttonevent -> {
            if(!player.getTempCard().isEmpty()) {
                Image discardcard = new Image(getClass().getResource(player.getPlayerCards().get(0).getCardFile().toString()).toExternalForm(), 400, 200, true, true);
                Image card1 = new Image(getClass().getResource(player.getTempCard().peek().getCardFile().toString()).toExternalForm(), 400, 200, true, true);
                player.PlayerDiscardCard("playerdeck", 0);
                playerbutton1.setGraphic(new ImageView(card1));
                discardpilebutton.setGraphic(new ImageView(discardcard));
                playertempbutton.setGraphic(new ImageView(blank));
            }
        });
        
        Button playerbutton2 = new Button();
        Image playercard2 = new Image(getClass().getResource(player.getPlayerCards().get(1).getCardFile().toString()).toExternalForm(), 400, 200, true, true);
        playerbutton2.setGraphic(new ImageView(playercard2));
        playerbutton2.setOnAction(playerbuttonevent -> {
            if(!player.getTempCard().isEmpty()) {
                Image discardcard = new Image(getClass().getResource(player.getPlayerCards().get(1).getCardFile().toString()).toExternalForm(), 400, 200, true, true);
                Image card2 = new Image(getClass().getResource(player.getTempCard().peek().getCardFile().toString()).toExternalForm(), 400, 200, true, true);
                player.PlayerDiscardCard("playerdeck", 1);
                playerbutton2.setGraphic(new ImageView(card2));
                discardpilebutton.setGraphic(new ImageView(discardcard));
                playertempbutton.setGraphic(new ImageView(blank));
            }
        });
        
        Button playerbutton3 = new Button();
        Image playercard3 = new Image(getClass().getResource(player.getPlayerCards().get(2).getCardFile().toString()).toExternalForm(), 400, 200, true, true);
        playerbutton3.setGraphic(new ImageView(playercard3));
        playerbutton3.setOnAction(playerbuttonevent -> {
            if(!player.getTempCard().isEmpty()) {
                Image discardcard = new Image(getClass().getResource(player.getPlayerCards().get(2).getCardFile().toString()).toExternalForm(), 400, 200, true, true);
                Image card3 = new Image(getClass().getResource(player.getTempCard().peek().getCardFile().toString()).toExternalForm(), 400, 200, true, true);
                player.PlayerDiscardCard("playerdeck", 2);
                playerbutton3.setGraphic(new ImageView(card3));
                discardpilebutton.setGraphic(new ImageView(discardcard));
                playertempbutton.setGraphic(new ImageView(blank));
            }
        });
        
        Button playerbutton4 = new Button();
        Image playercard4 = new Image(getClass().getResource(player.getPlayerCards().get(3).getCardFile().toString()).toExternalForm(), 400, 200, true, true);
        playerbutton4.setGraphic(new ImageView(playercard4));
        playerbutton4.setOnAction(playerbuttonevent -> {
            if(!player.getTempCard().isEmpty()) {
                Image discardcard = new Image(getClass().getResource(player.getPlayerCards().get(3).getCardFile().toString()).toExternalForm(), 400, 200, true, true);
                Image card4 = new Image(getClass().getResource(player.getTempCard().peek().getCardFile().toString()).toExternalForm(), 400, 200, true, true);
                player.PlayerDiscardCard("playerdeck", 0);
                playerbutton4.setGraphic(new ImageView(card4));
                discardpilebutton.setGraphic(new ImageView(discardcard));
                playertempbutton.setGraphic(new ImageView(blank));
            }
        });
        
        playertempbutton.setOnAction(playerbuttonevent -> {
                Image discardcard = new Image(getClass().getResource(player.getTempCard().peek().getCardFile().toString()).toExternalForm(), 400, 200, true, true);                
                player.PlayerDiscardCard("playertempdeck", -1);
                playertempbutton.setGraphic(new ImageView(blank));
                discardpilebutton.setGraphic(new ImageView(discardcard));
        });
        
        playerdeck.getChildren().addAll(playerbutton1, playerbutton2, playerbutton3, playerbutton4, playertempbutton);

        
        return playerdeck;
    }
    
}
