package com.fezekanzama.Model;

public class BoardModel {
    public Player[] players =  new Player[2];
    private Player active;
    private int movesRemainingInGame = 9;
    public Symbol[] playsMade = new Symbol[9];
    private Player winner; 

    public Player[] getPlayers() {
        return this.players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int getMovesRemainingInGame() {
        return this.movesRemainingInGame;
    }

    public void setMovesRemainingInGame() {
        this.movesRemainingInGame--;
    }

    //Getters and Setters
    public void setActive(Player active){
        this.active = active;
    }

    public Player getActive(){
        return active;
    }

    public void setWinner(Player winner){
        this.winner = winner;
    }

    public Player getWinner(){
        return winner;
    }

    //
    public void play(int index){

        //update playsMade list
        playsMade[index] = active.getSymbol();

        if(movesRemainingInGame<6 && (checkRow() || checkCol() || checkDiag())){
                setWinner(active);       
        }

        //update active player - lets O play)
        setActive(players[movesRemainingInGame%2]);

        //update moves remaining in the whole game
        setMovesRemainingInGame();
    }

    private Boolean checkRow(){
        //check if row adds up

        if((playsMade[0]!=null && playsMade[0]==playsMade[1] && playsMade[1] == playsMade[2]) || (playsMade[3]!=null && playsMade[3]==playsMade[4] && playsMade[4] == playsMade[5]) || (playsMade[6]!=null && playsMade[6]==playsMade[7] && playsMade[7] == playsMade[8])){
            return true;
        }
        return false;
    }

    private Boolean checkCol(){
        //check if beginning of col is null
        if((playsMade[0]!=null && playsMade[0]==playsMade[3] && playsMade[3] == playsMade[6]) || (playsMade[1]!=null && playsMade[1]==playsMade[4] && playsMade[4] == playsMade[7]) || (playsMade[2]!=null && playsMade[2]==playsMade[5] && playsMade[5] == playsMade[8])){
            return true;
        }
        return false;

    }

    private Boolean checkDiag(){
        if((playsMade[0]!=null && playsMade[0]==playsMade[4] && playsMade[4]==playsMade[8]) || (playsMade[2]!=null && playsMade[2]==playsMade[4] && playsMade[4]==playsMade[6])){
            return true; 
        }
        else{
            return false;
        }

    }

    public void resetBoard(){
        //reset players ie. swap who starts
        Player hold = players[0];
        players[0] = players[1];
        players[1] = hold; 

        //reset winner
        setWinner(null);

        //reset playsMade array
        for(int i=0; i<9; i++ ){
            playsMade[i] = null;
        }

        //reset moves remaiing in game
        movesRemainingInGame = 9;
    }
}
