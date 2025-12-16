package game.console;

import java.util.Scanner;

public class DefaultConsoleIO implements ConsoleIO {
    private Scanner scanner;

    public DefaultConsoleIO() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }


}