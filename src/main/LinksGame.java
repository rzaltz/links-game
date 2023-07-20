package main;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class LinksGame {

    public static void main(String[] args) {
        final LinksGameModel linksGameModel = new LinksGameModel(LinksGame.createLinks());
        new LinksGame().play(linksGameModel);
    }

    public static LinkedList<Integer> createLinks() {
        System.out.println("Initializing the links game...");

        int minLinkLength = 5;
        int maxLinkLength = 100;
        int minLinkValue = -100;
        int maxLinkValue = 100;

        int linkLength = ThreadLocalRandom.current().nextInt(minLinkLength, maxLinkLength + 1);

        LinkedList<Integer> links = new LinkedList<>();

        for (int i = 0; i <= linkLength; i++) {
            links.add(i, ThreadLocalRandom.current().nextInt(minLinkValue, maxLinkValue + 1));
        }

        System.out.printf("There are %s links.%n", links.size());

        return links;

    }

    public void play(final LinksGameModel linksGameModel) {
        while (!linksGameModel.getLinkedList().isEmpty()) {
            Scanner input = new Scanner(System.in);

            linksGameModel.getLinkedList().forEach(link -> System.out.print(link + " "));
            System.out.printf("\nPlayer %s - Enter First or Last:%n", linksGameModel.isPlayerOnesTurn() ? 1 : 2);

            String inputVal = input.next();

            try {
                if (!inputVal.equals("First") && !inputVal.equals("Last")) {
                    System.out.println("Invalid input. Please re-enter input: First or Last");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please re-enter input: First or Last");
                continue;
            }

            if (linksGameModel.isPlayerOnesTurn()) {
                linksGameModel.setPlayerOneScore(linksGameModel.getPlayerOneScore() + getLinkValue(linksGameModel, inputVal));
                linksGameModel.setPlayerOnesTurn(false);
            } else {
                linksGameModel.setPlayerTwoScore(linksGameModel.getPlayerTwoScore() + getLinkValue(linksGameModel, inputVal));
                linksGameModel.setPlayerOnesTurn(true);
            }
        }
        getFinalScore(linksGameModel);
    }

    public void getFinalScore(LinksGameModel linksGameModel) {
        if (linksGameModel.getPlayerTwoScore() > linksGameModel.getPlayerOneScore()) {
            System.out.println("Player Two won!");
        } else if (linksGameModel.getPlayerOneScore() > linksGameModel.getPlayerTwoScore()) {
            System.out.println("Player One won!");
        } else {
            System.out.println("Tie game!");
        }

        System.out.printf("Player 1 Score: %s%n", linksGameModel.getPlayerOneScore());
        System.out.printf("Player 2 Score: %s %n", linksGameModel.getPlayerTwoScore());

    }

    public int getLinkValue(LinksGameModel linksGameModel, String inputValue) {
        var links = linksGameModel.getLinkedList();
        Integer linkValue;

        if (inputValue.equals("First")) {
            linkValue = links.getFirst();
            links.removeFirst();
        } else {
            linkValue = links.getLast();
            links.removeLast();
        }
        return linkValue;
    }
}