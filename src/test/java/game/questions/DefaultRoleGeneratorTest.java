package game.questions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DefaultRoleGeneratorTest {
    private final DefaultRoleGenerator generator = new DefaultRoleGenerator();

    @Test
    void getRolesForMinus1() {
        assertEquals(null, generator.getRoles(-1));
    }

    @Test
    void getRolesForMinus6() {
        assertEquals(null, generator.getRoles(-6));
    }

    @Test
    void getRolesFor0() {
        assertEquals(null, generator.getRoles(0));
    }

    @Test
    void getRolesFor3() {
        assertEquals(null, generator.getRoles(3));
    }

    @Test
    void getRolesFor5() {
        String[] result = generator.getRoles(5);
        assertNotEquals(null, result);
        boolean mafia = false;
        boolean civilian = false;
        for (String role : result) {
            if ("Мафия".equals(role)) mafia = true;
            if ("Мирный житель".equals(role)) civilian = true;
        }
        assertEquals(true, mafia);
        assertEquals(true, civilian);
    }

    @Test
    void getRolesFor8() {
        String[] result = generator.getRoles(8);
        assertNotEquals(null, result);
        boolean mafia = false;
        boolean civilian = false;
        for (String role : result) {
            if ("Мафия".equals(role)) mafia = true;
            if ("Мирный житель".equals(role)) civilian = true;
        }
        assertEquals(true, mafia);
        assertEquals(true, civilian);
    }

    @Test
    void getRolesFor12() {
        String[] result = generator.getRoles(12);
        assertNotEquals(null, result);
        boolean mafia = false;
        boolean civilian = false;
        for (String role : result) {
            if ("Мафия".equals(role)) mafia = true;
            if ("Мирный житель".equals(role)) civilian = true;
        }
        assertEquals(true, mafia);
        assertEquals(true, civilian);
    }

    @Test
    void getRolesFor19() {
        String[] result = generator.getRoles(19);
        assertNotEquals(null, result);
        boolean mafia = false;
        boolean civilian = false;
        for (String role : result) {
            if ("Мафия".equals(role)) mafia = true;
            if ("Мирный житель".equals(role)) civilian = true;
        }
        assertEquals(true, mafia);
        assertEquals(true, civilian);
    }

    @Test
    void getRolesFor22() {
        assertEquals(null, generator.getRoles(22));
    }
}