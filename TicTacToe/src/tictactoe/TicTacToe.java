/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Bharath
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String a = "";
        int w = 0,l = 0,t = 0;
        char s = 'l';
        HumanPlayer HP = new HumanPlayer(a, w, l, t, s);
        ComputerPlayer CP = new ComputerPlayer(a, w, l, t, s);
        System.out.println("Human Player: ");
        a = HP.HumanPlayerName();
        System.out.println("Your name is: " + a);
        a = CP.ComputerPlayerName();
        System.out.println("You are Playing against " + a);
    }
    
}
