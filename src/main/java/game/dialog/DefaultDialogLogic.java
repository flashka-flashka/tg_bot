package game.dialog;

import game.questions.DefaultRoleGenerator;
import game.questions.RoleGenerator;

public class DefaultDialogLogic implements DialogLogic {
    private RoleGenerator roleGenerator;
    public DefaultDialogLogic() {
        this(new DefaultRoleGenerator());
    }
    public DefaultDialogLogic(RoleGenerator roleGenerator) {
        this.roleGenerator = roleGenerator;
    }
    @Override
    public String startGame(int playersCount) {
        String[] roles = roleGenerator.getRoles(playersCount);

        if (roles == null) {
            return "Ошибка: некорректное количество игроков. Должно быть от 5 до 19";
        }

        StringBuilder result = new StringBuilder();
        result.append("Распределение ролей для ").append(playersCount).append(" игроков:\n");
        for (int i = 0; i < roles.length; i++) {
            result.append(i + 1).append(". ").append(roles[i]).append("\n");
        }
        return result.toString();
    }

    @Override
    public String help() {
        return "Доступные команды:\n" +
                "1. /start_game [N] - начать игру с N игроками (5-19)\n" +
                "   Пример: /start_game 7\n" +
                "   Если N не указано, бот запросит его отдельно\n" +
                "2. \\help - показать эту справку\n";
    }

    @Override
    public String start() {
        return "Привет! Я бот для игры в Мафию.\n" +
                "Я могу распределить роли для 5-19 игроков.\n" +
                "Команды:\n" +
                "/start_game [N] - начать игру с N игроками (5-19)\n" +
                "\\help - показать справку\n";
    }
}