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
public class ComputerPlayer extends Player{
    
    public ComputerPlayer(String name,int wins, int losses, int ties, char symbol)
    {
        super(name, wins, losses, ties, symbol);
    }
    
    public String ComputerPlayerName()
    {
        String cname = "";
        int rname;
        
        rname = (int)(1 + Math.random() * 5);
        
        switch(rname)
        {
            case 1:
                cname = "Allen";
                break;
            case 2:
                cname = "Bob";
                break;
            case 3:
                cname = "Cathy";
                break;
            case 4:
                cname = "Dave";
                break;
            case 5:
                cname = "Eric";
                break;
             
        }
        return cname;
    }
    
}
