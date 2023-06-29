package org.example;

public abstract class UserInteractionTemplate {
    public final void execute() {

        printMessage();
        boolean isValid;
        do {
            String userInput = getUserInput();
            isValid = validateInput(userInput);
            if (!isValid) {
                printErrorMessage();
            }
        } while (!isValid);
    }

    protected abstract void printMessage();
    protected abstract String getUserInput();
    protected abstract boolean validateInput(String input);
    protected abstract void printErrorMessage();
}