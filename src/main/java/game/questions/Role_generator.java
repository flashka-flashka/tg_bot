package game.questions;
import java.util.Random;
public class Role_generator {
    private final String[] allRoles = {
            "Мафия", "Мирный житель", "Шериф", "Дон", "Доктор",
            "Путана", "Маньяк", "Самурай", "Агент", "Судья",
            "Прокурор", "Адвокат", "Журналист", "Психолог",
            "Телохранитель", "Снайпер", "Клоун", "Вор", "Священник"
    };

    public String[] get_roles(int count) {
        if (count < 5 || count > 19) {
            return null;
        }

        // Создаем копию первых count ролей
        String[] selected_roles = new String[count];
        for (int i = 0; i < count; i++) {
            selected_roles[i] = allRoles[i];
        }

        // Перемешиваем роли
        shuffle_array(selected_roles);

        return selected_roles;
    }
    private void shuffle_array(String[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            String temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}