package com.algorithms.dp;

/**
 * Problem statement: Find player1 maximum gains in a coins distribution(aligned in the linear form) game with another player if player1 is given first chance to take a coin.
 * <br> Constraints: One player should take one coin at a time either from left or right end. Player2 is also equally good as player1.
 * <br><br>
 * Test case:
 * <br>
 * Input: 3, 9, 1, 5
 * <br>
 * Output: 14 (player1 extractions - 5, 9)
 * <br>
 * @author Sasi on 07-Jun-2018, 11:40:56 pm
 */
public class OptimalGameStrategy {

	public int findPlayer1MaxGains(int[] coins){
		
		int totalCoins = coins.length;
		Game[][] scores = new Game[totalCoins][totalCoins];
		int i, j, k;
		
		for(i = 0; i < totalCoins; i++){
			scores[i][i] = new Game(coins[i], 0);			//Initializing scores matrix considering there is only element in coins array. So obviously player 1 selects it and player gets 0. 
		}
		
		for(k = 2; k <= totalCoins; k++){
			for(i = 0; i <= totalCoins - k; i++){
				 j = i + k -1;
				 int totalWithLeftEndCoin = coins[i] + scores[i + 1][j].player2Score;
				 int totalWithRightEndCoin = coins[j] + scores[i][j - 1].player2Score;
				 if(totalWithLeftEndCoin > totalWithRightEndCoin){
					 scores[i][j] = new Game(totalWithLeftEndCoin, scores[i + 1][j].player1Score);
				 }else{
					 scores[i][j] = new Game(totalWithRightEndCoin, scores[i][j - 1].player1Score);
				 }
			}
		}
		
		return scores[0][totalCoins - 1].player1Score;
	}
	
	public static void main(String[] args) {
		int[] coins = new int[]{3, 9, 1, 5};
		System.out.println("Player1 max gains: " + new OptimalGameStrategy().findPlayer1MaxGains(coins));
		
		coins = new int[]{1, 2, 3, 4, 5, 6};
		System.out.println("Player1 max gains: " + new OptimalGameStrategy().findPlayer1MaxGains(coins));
	}
	
	class Game{
		int player1Score;
		int player2Score;

		public Game(int player1Score, int player2Score) {
			super();
			this.player1Score = player1Score;
			this.player2Score = player2Score;
		}
	}
}
