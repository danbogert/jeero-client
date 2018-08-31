package com.yogurtpowered.jeero.command;

import java.util.Optional;

public class ExitCommand implements Command<String> {
    @Override
    public Optional<String> execute() {
        SCANNER.close();
        return Optional.of("Exiting");
    }
}
