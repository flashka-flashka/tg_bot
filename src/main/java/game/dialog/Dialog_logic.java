package game.dialog;

import game.questions.Role_generator;

public class Dialog_logic {
    private final Role_generator role_generator;

    public Dialog_logic() {
        this.role_generator = new Role_generator();
    }

    public String start_game(int players_count) {
        String[] roles = role_generator.get_roles(players_count);

        if (roles == null) {
            return "Ошибка: некорректное количество игроков. Должно быть от 5 до 19";
        }

        StringBuilder result = new StringBuilder();
        result.append("Распределение ролей для ").append(players_count).append(" игроков:\n");
        for (int i = 0; i < roles.length; i++) {
            result.append(i + 1).append(". ").append(roles[i]).append("\n");
        }
        return result.toString();
    }
    public String help(){
        return "Доступные команды:\n" +
                "1. /start_game [N] - начать игру с N игроками (5-19)\n" +
                "   Пример: /start_game 7\n" +
                "   Если N не указано, бот запросит его отдельно\n" +
                "2. \\help - показать эту справку\n" +
                "3. exit - выйти из программы";

    }
    public String start(){
        return "Привет! Я бот для игры в Мафию.\n" +
                "Я могу распределить роли для 5-19 игроков.\n" +
                "Команды:\n" +
                "/start_game [N] - начать игру с N игроками (5-19)\n" +
                "\\help - показать справку\n" +
                "exit - выйти из программы";
    }

}