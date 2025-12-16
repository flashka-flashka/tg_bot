package game.dialog;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import game.questions.RoleGenerator;
import org.mockito.Mockito;

class DialogLogicTest {

    RoleGenerator mockRoleGenerator = Mockito.mock(RoleGenerator.class);

    @Test
    void startGameWith7Players() {
        int playersCount = 7;
        String[] mockRoles = {"Мафия", "Мирный", "Мирный", "Мирный", "Шериф", "Мирный", "Дон"};

        when(mockRoleGenerator.getRoles(playersCount)).thenReturn(mockRoles);

        DialogLogic dialog = new DefaultDialogLogic(mockRoleGenerator);

        String result = dialog.startGame(playersCount);

        String expected = "Распределение ролей для 7 игроков:\n" +
                "1. Мафия\n" +
                "2. Мирный\n" +
                "3. Мирный\n" +
                "4. Мирный\n" +
                "5. Шериф\n" +
                "6. Мирный\n" +
                "7. Дон\n";

        assertEquals(expected, result);
    }

    @Test
    void startGameWith5Players() {
        int playersCount = 5;
        String[] mockRoles = {"Мафия", "Мирный", "Шериф", "Мирный", "Мирный"};

        when(mockRoleGenerator.getRoles(playersCount)).thenReturn(mockRoles);

        DialogLogic dialog = new DefaultDialogLogic(mockRoleGenerator);
        String result = dialog.startGame(playersCount);

        String expected = "Распределение ролей для 5 игроков:\n" +
                "1. Мафия\n" +
                "2. Мирный\n" +
                "3. Шериф\n" +
                "4. Мирный\n" +
                "5. Мирный\n";

        assertEquals(expected, result);
    }

    @Test
    void startGameWith11Players() {
        int playersCount = 11;
        String[] mockRoles = {
                "Мафия", "Мафия", "Дон", "Шериф",
                "Мирный", "Мирный", "Мирный", "Мирный",
                "Мирный", "Мирный", "Мирный"
        };

        when(mockRoleGenerator.getRoles(playersCount)).thenReturn(mockRoles);

        DialogLogic dialog = new DefaultDialogLogic(mockRoleGenerator);
        String result = dialog.startGame(playersCount);

        String expected = "Распределение ролей для 11 игроков:\n" +
                "1. Мафия\n" +
                "2. Мафия\n" +
                "3. Дон\n" +
                "4. Шериф\n" +
                "5. Мирный\n" +
                "6. Мирный\n" +
                "7. Мирный\n" +
                "8. Мирный\n" +
                "9. Мирный\n" +
                "10. Мирный\n" +
                "11. Мирный\n";

        assertEquals(expected, result);
    }

    @Test
    void startGameWith17Players() {
        int playersCount = 17;
        String[] mockRoles = {
                "Мафия", "Мафия", "Мафия", "Дон", "Шериф", "Доктор",
                "Мирный", "Мирный", "Мирный", "Мирный", "Мирный",
                "Мирный", "Мирный", "Мирный", "Мирный", "Мирный", "Мирный"
        };

        when(mockRoleGenerator.getRoles(playersCount)).thenReturn(mockRoles);

        DialogLogic dialog = new DefaultDialogLogic(mockRoleGenerator);
        String result = dialog.startGame(playersCount);

        String expected = "Распределение ролей для 17 игроков:\n" +
                "1. Мафия\n" +
                "2. Мафия\n" +
                "3. Мафия\n" +
                "4. Дон\n" +
                "5. Шериф\n" +
                "6. Доктор\n" +
                "7. Мирный\n" +
                "8. Мирный\n" +
                "9. Мирный\n" +
                "10. Мирный\n" +
                "11. Мирный\n" +
                "12. Мирный\n" +
                "13. Мирный\n" +
                "14. Мирный\n" +
                "15. Мирный\n" +
                "16. Мирный\n" +
                "17. Мирный\n";

        assertEquals(expected, result);
    }

    @Test
    void startGameWith19Players() {
        int playersCount = 19;
        String[] mockRoles = {
                "Мафия", "Мафия", "Мафия", "Мафия", "Дон", "Шериф", "Доктор", "Любовница",
                "Мирный", "Мирный", "Мирный", "Мирный", "Мирный", "Мирный",
                "Мирный", "Мирный", "Мирный", "Мирный", "Мирный"
        };

        when(mockRoleGenerator.getRoles(playersCount)).thenReturn(mockRoles);

        DialogLogic dialog = new DefaultDialogLogic(mockRoleGenerator);
        String result = dialog.startGame(playersCount);

        String expected = "Распределение ролей для 19 игроков:\n" +
                "1. Мафия\n" +
                "2. Мафия\n" +
                "3. Мафия\n" +
                "4. Мафия\n" +
                "5. Дон\n" +
                "6. Шериф\n" +
                "7. Доктор\n" +
                "8. Любовница\n" +
                "9. Мирный\n" +
                "10. Мирный\n" +
                "11. Мирный\n" +
                "12. Мирный\n" +
                "13. Мирный\n" +
                "14. Мирный\n" +
                "15. Мирный\n" +
                "16. Мирный\n" +
                "17. Мирный\n" +
                "18. Мирный\n" +
                "19. Мирный\n";

        assertEquals(expected, result);
    }

    @Test
    void startGameWithInvalidPlayersCountReturnsErrorMessage() {
        int invalidPlayersCount = 3;

        when(mockRoleGenerator.getRoles(invalidPlayersCount)).thenReturn(null);

        DialogLogic dialog = new DefaultDialogLogic(mockRoleGenerator);

        String result = dialog.startGame(invalidPlayersCount);

        String expected = "Ошибка: некорректное количество игроков. Должно быть от 5 до 19";
        assertEquals(expected, result);
    }

    @Test
    void helpShouldReturnHelpMessage() {
        DialogLogic dialog = new DefaultDialogLogic();
        String expectedMessage = "Доступные команды:\n" +
                "1. /start_game [N] - начать игру с N игроками (5-19)\n" +
                "   Пример: /start_game 7\n" +
                "   Если N не указано, бот запросит его отдельно\n" +
                "2. \\help - показать эту справку\n";

        String actualMessage = dialog.help();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void startShouldReturnWelcomeMessage() {
        DialogLogic dialog = new DefaultDialogLogic();
        String expectedMessage = "Привет! Я бот для игры в Мафию.\n" +
                "Я могу распределить роли для 5-19 игроков.\n" +
                "Команды:\n" +
                "/start_game [N] - начать игру с N игроками (5-19)\n" +
                "\\help - показать справку\n";
        String actualMessage = dialog.start();
        assertEquals(expectedMessage, actualMessage);
    }
}