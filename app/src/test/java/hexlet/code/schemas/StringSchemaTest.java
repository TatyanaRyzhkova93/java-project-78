package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    private static Validator v;
    @BeforeAll
    public static void beforeAll() {
        v = new Validator();
    }
    @Test
    public void testContains() throws Exception {
        assertFalse(v.string().contains("absd").contains("absdff").isValid("absd"));
        assertTrue(v.string().contains("absd").contains("absdff").isValid("absdff"));
        assertFalse(v.string().contains("absss").isValid(null));
        assertFalse(v.string().contains(null).isValid("absd"));
    }
    @Test
    public void testRequired() throws Exception {
        assertTrue(v.string().required().isValid("absdff"));
        assertFalse(v.string().required().isValid(null));
    }
    @Test
    public void testMinLength() throws Exception {
        assertFalse(v.string().minLength(5).isValid("absd"));
        assertTrue(v.string().minLength(3).isValid("absdff"));
        assertFalse(v.string().minLength(5).isValid(null));
        assertFalse(v.string().minLength(5).isValid(""));
    }
    @Test
    public void testAll() throws Exception {
        assertTrue(v.string().minLength(10).minLength(3).required().isValid("absdff"));
        assertTrue(v.string().required().contains("ssss").contains("abs").isValid("absdff"));
    }
}
