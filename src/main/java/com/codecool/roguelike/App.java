package com.codecool.roguelike;

import com.codecool.roguelike.boardElements.Board;
import com.codecool.roguelike.exceptions.TooManyGatesException;
import com.codecool.roguelike.ui.GameInputReader;
import com.codecool.roguelike.ui.GameUI;
import com.codecool.roguelike.ui.console.ConsoleGameInputReader;
import com.codecool.roguelike.ui.console.ConsoleUI;

import java.io.IOException;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws IOException {
        final int boardWidth = 20;
        final int boardHeight = 10;
        final char wallIcon = '#';
        final int numberOfGates = 2;
        final int numberOfInnerWalls = 20;
        final char gateIconHorizontal = '=';
        final char gateIconVertical = '"';
        final int playerStartX = 3;
        final int playerStartY = 3;
        final char playerIcon = '@';

        System.out.println("Choose a name for your hero!");
        String playerName = Util.getInputString();

        System.out.println("Choose the race of your hero!");
        System.out.println("1 - Human");
        System.out.println("2 - Elf");
        System.out.println("3 - Dwarf");
        Race playerRace = Race.HUMAN;
        int userRaceChoice = Util.getInputInt();

        switch (userRaceChoice) {
            case 1 -> {
                System.out.println("You will play as a human");
                playerRace = Race.HUMAN;
            }
            case 2 -> {
                System.out.println("You will play as an elf");
                playerRace = Race.ELF;
            }
            case 3 -> {
                System.out.println("You will play as a dwarf");
                playerRace = Race.DWARF;
            }
        }

        Coordinates playerStartingCoordinates = new Coordinates(playerStartX, playerStartY);

        Player player = new Player(playerName, playerRace, playerStartingCoordinates);

        Board board;
        try {
            board = Engine.createBoard(boardWidth, boardHeight, wallIcon, numberOfGates, numberOfInnerWalls,
                    gateIconHorizontal,
                    gateIconVertical);
        } catch (TooManyGatesException e) {
            System.out.println(e.getMessage());
            return;
        }

        Util.clearScreen();

        GameUI ui = new ConsoleUI();
        GameInputReader reader = new ConsoleGameInputReader();

        boolean isRunning = true;
        boolean isGameStarting = true;
        while (isRunning) {
            if (isGameStarting) {
                Engine.placePlayerNextToAGate(board, player);
                Engine.createNpc(board.getCharBoard());
                Engine.createMobs(board.getCharBoard());
            } else {
                Engine.putCharacterOnBoard(board.getCharBoard(), player);
                Engine.putCharactersOnBoard(board.getCharBoard());
            }

            ui.displayBoard(board.getCharBoard());
            ((ConsoleUI) ui).displayCharacterStats(player);

            char key = Util.getKeyStroke(reader, 1500);
            //char key = Util.getInputChar();

            if (key == 'q') {
                isRunning = false;
            } else {
                switch (key) {
                    case 'w' -> {
                        Engine.removeCharacterFromBoard(board.getCharBoard(), player);
                        player.moveUp();
                    }
                    case 's' -> {
                        Engine.removeCharacterFromBoard(board.getCharBoard(), player);
                        player.moveDown();
                    }
                    case 'a' -> {
                        Engine.removeCharacterFromBoard(board.getCharBoard(), player);
                        player.moveLeft();
                    }
                    case 'd' -> {
                        Engine.removeCharacterFromBoard(board.getCharBoard(), player);
                        player.moveRight();
                    }
                    case 'i' -> {
                        player.displayInventory();
                    }
                    default -> System.out.println("Move with W,A,S,D, open inventory with I, or quit with Q!");
                }

                if (Arrays.asList('w', 'a', 's', 'd').contains(key)) {
                    Engine.removeCharactersFromBoard(board.getCharBoard());
                    Engine.moveMobs(player);
                }//TODO move mobs
            }
            isGameStarting = false;
        }
    }
}
