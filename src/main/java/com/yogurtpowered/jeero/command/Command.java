package com.yogurtpowered.jeero.command;

import java.util.Optional;
import java.util.Scanner;

public interface Command<T> {
    Scanner SCANNER = new Scanner(System.in);

    Optional<T> execute();
}
