package game.dialog;

import game.console.ConsoleIO;
import game.console.DefaultConsoleIO;

public class DialogManager {
    private ConsoleIO console;
    private DialogLogic dialogLogic;


    public DialogManager() {
        this.console = new DefaultConsoleIO();
        this.dialogLogic = new DefaultDialogLogic();

    }

    public void startDialog() {
        console.print(dialogLogic.start());
        boolean chating = true;
        while (chating) {
            console.print("\nВведите команду:");
            String userInput = console.readLine();

            if (userInput.equals("\\help")) {
                console.print(dialogLogic.help());
            }
            else if (userInput.startsWith("/start_game")) {
                handleStartGame(userInput);
            }
            else {
                console.print("Неизвестная команда. Введите \\help для справки.");
            }
        }


    }

    private void handleStartGame(String input) {
        String[] parts = input.split(" ");
        int playersCount = -1;

        if (parts.length >= 2) {
            try {
                playersCount = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
            }
        }
        else {
            console.print("Введите количество игроков (5-19):");
            String countInput = console.readLine();
            try {
                playersCount = Integer.parseInt(countInput);
            } catch (NumberFormatException e) {
                console.print("Ошибка: введено некорректное число");
                return;
            }
        }
        String result = dialogLogic.startGame(playersCount);
        console.print(result);
    }


}
