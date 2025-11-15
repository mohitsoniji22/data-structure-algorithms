package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnackLadder {
    private static Map<Integer, Integer> snakeMap = new HashMap<>();
    private static Map<Integer, Integer> ladderMap = new HashMap<>();
    private static int winNum = 100;
    private static boolean won = false;
    private static boolean isWin(int playerPos){
        if(playerPos == 100) {
            won = true;
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        initiateSnacksNLadders();
        int player1Pos = 0, player2Pos = 0, player1Turn = 1, player2Turn = 0;
        do {
            Scanner s = new Scanner(System.in);
            String keyPressed = s.next();
            if (keyPressed != null) {
                if(player1Turn == 1) {
                    System.out.println("Player 1 throwing dice");
                    int diceNum = rollDice();
                    player1Pos = calculateNewPosition(player1Pos, diceNum);
                    System.out.println("Player 1 position: "+player1Pos);
                    System.out.println(isWin(player1Pos) ? "*******************Player 1 Won****************":"--------Player 2 Turn");
                    player1Turn = 0;
                    player2Turn = 1;
                } else if(player2Turn == 1){
                    System.out.println("Player 2 throwing dice");
                    int diceNum = rollDice();
                    player2Pos = calculateNewPosition(player2Pos, diceNum);
                    System.out.println("Player 2 position: "+player2Pos);
                    System.out.println(isWin(player2Pos) ? "*******************Player 2 Won****************":"--------Player 1 Turn");
                    player1Turn = 1;
                    player2Turn = 0;
                }
            }
        }while(!won);
    }

    private static void initiateSnacksNLadders() {
        snakeMap.put(99, 54);
        snakeMap.put(70, 55);
        snakeMap.put(52, 42);
        snakeMap.put(25, 2);
        snakeMap.put(95, 72);

        ladderMap.put(6, 25);
        ladderMap.put(11, 40);
        ladderMap.put(60, 85);
        ladderMap.put(46, 90);
        ladderMap.put(17, 69);
    }

    private static int calculateNewPosition(int playerPos, int diceNum) {
        playerPos = playerPos + diceNum;
        if(playerPos > winNum) {
            playerPos = playerPos - diceNum;
            return playerPos;
        }
        if(snakeMap.containsKey(playerPos)) {
            playerPos = snakeMap.get(playerPos);
            System.out.println("Eaten by Snack: slide down to: "+playerPos);
        }

        if(ladderMap.containsKey(playerPos)) {
            playerPos = ladderMap.get(playerPos);
            System.out.println("Got Ladder: slide up to: "+playerPos);
        }
        return playerPos;
    }

    private static int rollDice() {
        Random random = new Random();
        int diceNum = random.nextInt(1, 7);
        System.out.println("Dice Number: "+diceNum);
        return diceNum;
    }
}
