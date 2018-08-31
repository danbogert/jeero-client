package com.yogurtpowered.jeero;

import com.yogurtpowered.jeero.utils.InputHelper;

import java.util.Optional;
import java.util.Scanner;

public class TestClient {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final JeeroClient JEERO = new JeeroClient();

    public static void main(String[] args) {
        Action action;
        do {
            action = getAction();
            Optional<?> result = JEERO.perform(action);
            if (result.isPresent()) {
                System.out.println(result.get().toString());
            } else {
                System.out.println("No result");
            }

            System.out.println();
        } while (Action.EXIT != action);

        SCANNER.close();
    }

    private static Action getAction() {
        Action[] actions = Action.values();

        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ") " + actions[i].getDisplayName());
        }

        int choice = InputHelper.getInt(SCANNER, "What would you like to do? ", 0, actions.length - 1);
        return actions[choice];
    }
}
