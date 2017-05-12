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
public class HumanPlayer extends Player {
    
    public HumanPlayer(String name,int wins, int losses, int ties, char symbol)
    {
            super(name, wins, losses, ties, symbol);
    }
    
    public String HumanPlayerName()
    {
        System.out.println("Enter your name: ");
        
        Scanner n1 = new Scanner(System.in);
        String hname = n1.nextLine();
        
        return hname;
        
    }
    
}
