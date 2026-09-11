package oop.class_problems;

import java.util.Random;

class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove))
            return "Draw";

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {

        String[] playerMoves = {"Rock","Paper","Scissors","Rock","Paper"};
        String[] options = {"Rock","Paper","Scissors"};

        Random random = new Random();

        int wins=0, losses=0, draws=0;

        System.out.println("Round | Player | Computer | Result");

        for(int i=0;i<5;i++){

            String computer=options[random.nextInt(3)];
            String result=playRound(playerMoves[i],computer);

            System.out.println((i+1)+" | "+playerMoves[i]+" | "+computer+" | "+result);

            if(result.equals("Player Wins")) wins++;
            else if(result.equals("Computer Wins")) losses++;
            else draws++;
        }

        double winPercent=(wins/5.0)*100;

        System.out.println("Wins: "+wins+" | Losses: "+losses+" | Draws: "+draws+" | Win % = "+winPercent);
    }
}