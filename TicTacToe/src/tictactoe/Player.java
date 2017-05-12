/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.Scanner;
/**
 *
 * @author Bharath
 */
public class Player {
    
    private String name;
    private int wins;
    private int losses;
    private int ties;
    private char symbol;
    
    
    public Player(String name, int wins, int losses, int ties, char symbol)
    {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.symbol = symbol;
    }
    
    public String PlayerName(String n)
    {
//        Scanner n1 = new Scanner(System.in);
//        name = n1.nextLine();
        
        return name;
    }
    
//    public int GamePoint(int pcount, int ccount)
//    {
//        
//    }
    
    public char PlayerSymbol()
    {
       Scanner n2 = new Scanner(System.in);
       symbol = n2.next().charAt(0);
       
       symbol = Character.toUpperCase(symbol);
       
       if(symbol != 'X' || symbol != 'O')
       {
           symbol = 'z';
       }
       
       return symbol;
    }

}