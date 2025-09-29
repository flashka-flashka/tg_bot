package game.console;

import java.util.Scanner;

public class Console_IO {
    private Scanner scanner;

    public Console_IO() {
        this.scanner = new Scanner(System.in);
    }

    public String read_line() {
        return scanner.nextLine();
    }

    public void print(String message) {
        System.out.println(message);
    }


}