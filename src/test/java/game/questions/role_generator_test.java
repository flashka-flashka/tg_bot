package game.questions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Role_generatorTest {

    @Test
    void test_get_roles_valid_count() {
        Role_generator generator = new Role_generator();

        String[] roles_5 = generator.get_roles(5);
        assertNotNull(roles_5);
        assertEquals(5, roles_5.length);

        String[] roles_10 = generator.get_roles(10);
        assertNotNull(roles_10);
        assertEquals(10, roles_10.length);

        String[] roles_19 = generator.get_roles(19);
        assertNotNull(roles_19);
        assertEquals(19, roles_19.length);
    }

    @Test
    void test_get_roles_invalid_count() {
        Role_generator generator = new Role_generator();

        assertNull(generator.get_roles(4));
        assertNull(generator.get_roles(20));
        assertNull(generator.get_roles(0));
        assertNull(generator.get_roles(-1));
    }

    @Test
    void test_get_roles_content() {
        Role_generator generator = new Role_generator();
        String[] roles = generator.get_roles(7);

        assertNotNull(roles);
        assertEquals(7, roles.length);

        for (String role : roles) {
            assertNotNull(role);
            assertFalse(role.trim().isEmpty());
        }

        String[] first_seven_original = {
                "Мафия", "Мирный житель", "Шериф", "Дон", "Доктор", "Путана", "Маньяк"
        };

        boolean is_different_order = false;
        for (int i = 0; i < roles.length; i++) {
            if (!roles[i].equals(first_seven_original[i])) {
                is_different_order = true;
                break;
            }
        }

        assertTrue(is_different_order, "Роли должны быть перемешаны");
    }

    @Test
    void test_get_roles_all_roles_available() {
        Role_generator generator = new Role_generator();

        String[] all_roles = generator.get_roles(19);
        assertNotNull(all_roles);

        for (int i = 0; i < all_roles.length; i++) {
            for (int j = i + 1; j < all_roles.length; j++) {
                assertNotEquals(all_roles[i], all_roles[j],
                        "Роли в одном распределении должны быть уникальными");
            }
        }
    }
}