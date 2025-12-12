package game.dialog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Dialog_logicTest {

    @Test
    void test_start_game_valid_count() {
        Dialog_logic logic = new Dialog_logic();

        String result = logic.start_game(7);
        assertNotNull(result);
        // Выведем результат, если тест падает
        if (!result.contains("Распределение ролей для 7 игроков:")) {
            System.out.println("Фактический результат: " + result);
        }
        assertTrue(result.contains("Распределение ролей для 7 игроков:"));
        assertTrue(result.contains("1."));
        assertTrue(result.contains("7."));

        String[] lines = result.split("\n");
        assertEquals(8, lines.length);
    }

    @Test
    void test_start_game_edge_cases() {
        Dialog_logic logic = new Dialog_logic();

        String result_5 = logic.start_game(5);
        assertNotNull(result_5);
        assertTrue(result_5.contains("5 игроков"));

        String result_19 = logic.start_game(19);
        assertNotNull(result_19);
        assertTrue(result_19.contains("19 игроков"));
    }

    @Test
    void test_process_start_game_invalid_count() {
        Dialog_logic logic = new Dialog_logic();

        String result_low = logic.start_game(4);
        assertEquals("Ошибка: некорректное количество игроков. Должно быть от 5 до 19", result_low);

        String result_high = logic.start_game(20);
        assertEquals("Ошибка: некорректное количество игроков. Должно быть от 5 до 19", result_high);

        String result_negative = logic.start_game(-1);
        assertEquals("Ошибка: некорректное количество игроков. Должно быть от 5 до 19", result_negative);

        String result_zero = logic.start_game(0);
        assertEquals("Ошибка: некорректное количество игроков. Должно быть от 5 до 19", result_zero);
    }

    @Test
    void test_process_start_game_role_distribution() {
        Dialog_logic logic = new Dialog_logic();

        String result = logic.start_game(6);
        assertNotNull(result);

        String[] lines = result.split("\n");
        assertEquals(7, lines.length);

        for (int i = 1; i < lines.length; i++) {
            String role_line = lines[i];
            assertTrue(role_line.matches("\\d+\\.\\s.+"),
                    "Строка роли должна быть в формате 'номер. роль': " + role_line);
        }
    }
}