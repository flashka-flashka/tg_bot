package game.questions;
import java.util.Random;
public class DefaultRoleGenerator implements RoleGenerator {
    private final String[] allRoles = {
            "Мафия", "Мирный житель", "Шериф", "Дон", "Доктор",
            "Путана", "Маньяк", "Самурай", "Агент", "Судья",
            "Прокурор", "Адвокат", "Журналист", "Психолог",
            "Телохранитель", "Снайпер", "Клоун", "Вор", "Священник"
    };

    @Override
    public String[] getRoles(int count) {
        if (count < 5 || count > 19) {
            return null;
        }


        String[] selectedRoles = new String[count];
        for (int i = 0; i < count; i++) {
            selectedRoles[i] = allRoles[i];
        }
        shuffleArray(selectedRoles);

        return selectedRoles;
    }
    private void shuffleArray(String[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            String temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}