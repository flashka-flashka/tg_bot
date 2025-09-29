package game.dialog;

import game.console.Console_IO;

public class Dialog_manager {
    private  Console_IO console;
    private  Dialog_logic dialog_logic;
    private  String welcome_message;
    private  String help_message;

    public Dialog_manager() {
        this.console = new Console_IO();
        this.dialog_logic = new Dialog_logic();

    }

    public void startDialog() {
        console.print(dialog_logic.start());
        boolean chating = true;
        while (chating) {
            console.print("\nВведите команду:");
            String userInput = console.read_line();

            if (userInput.equals("\\help")) {
                console.print(dialog_logic.help());
            }
            else if (userInput.startsWith("/start_game")) {
                handle_start_game(userInput);
            }
            else {
                console.print("Неизвестная команда. Введите \\help для справки");
            }
        }


    }

    private void handle_start_game(String input) {
        String[] parts = input.split(" ");
        int playersCount = -1;

        if (parts.length >= 2) {
            try {
                playersCount = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
            }
        }
        if (playersCount == -1) {
            console.print("Введите количество игроков (5-19):");
            String count_input = console.read_line();
            try {
                playersCount = Integer.parseInt(count_input);
            } catch (NumberFormatException e) {
                console.print("Ошибка: введено некорректное число");
                return;
            }
        }

        // Обрабатываем команду через чистую логику
        String result = dialog_logic.start_game(playersCount);
        console.print(result);
    }


}
