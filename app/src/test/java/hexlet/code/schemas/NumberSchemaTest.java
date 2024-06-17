package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    private static Validator v;
    private static NumberSchema schema;
    @BeforeAll
    public static void beforeAll() {
        v = new Validator();
        schema = v.number();
    }
    @Test
    public void testContains() throws Exception {
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));

        schema.required();

        assertFalse(schema.isValid(null)); // false
        schema.isValid(10); // true

        assertFalse(schema.isValid(-10)); // false
        assertFalse(schema.isValid(0)); // false

        schema.range(5, 10).positive();

        assertTrue(schema.isValid(5)); // true
        assertTrue(schema.isValid(10)); // true
        assertFalse(schema.isValid(4)); // false
        assertFalse(schema.isValid(11)); // false
    }
}
