package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestValidator {

    @Test
    public void testValidatorString() {
        Validator v = new Validator();
        StringSchema schema = v.stringSchema();
        assertTrue(schema.isValid(null));

        schema.required();
        assertTrue(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));

        schema.required();
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));

    }
    @Test
    public void testValidatorStringMinLength() {
        //Почему-то тест работал некорректно, когда я его поместил в общий метод теста testValidatorString()
        Validator v = new Validator();
        StringSchema schema = v.stringSchema();
        schema.required();
        assertTrue(schema.minLength(2).isValid("fo"));
        assertFalse(schema.minLength(maxNumber).isValid("what"));
    }
    private final int nimNumber = 3;
    private final int maxNumber = 8;
    @Test
    public void testValidatorNumber() {
        Validator v = new Validator();
        NumberSchema schema = v.numberSchema();
        assertTrue(schema.isValid(null));

        schema.required();

        assertTrue(schema.isValid(maxNumber));
        assertFalse(schema.isValid("5"));
        assertFalse(schema.isValid(null));


        assertTrue(schema.positive().isValid(maxNumber));
        assertFalse(schema.isValid(-maxNumber));
        assertFalse(schema.positive().isValid(null));

        schema.required();
        schema.range(nimNumber, maxNumber);
        assertTrue(schema.isValid(nimNumber));
        assertTrue(schema.isValid(maxNumber));
        assertFalse(schema.isValid(nimNumber - 1));
        assertFalse(schema.isValid(maxNumber + 1));
    }

    @Test
    public void testValidatorMap() {
        Validator v = new Validator();
        MapSchema schema = v.mapSchema();
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap()));

        schema.required();
        Map<String, String> str = new HashMap<>();
        str.put("key1", "value1");
        assertTrue(schema.isValid(str));

        schema.sizeof(2);

        assertFalse(schema.isValid(str));
        str.put("key2", "value2");
        assertTrue(schema.isValid(str));
    }
}

