package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestValidator {

    @Test
    public void testValidatorString() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertTrue(schema.isValid(null));

        schema.required();

        assertTrue(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));

        schema.required();

        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
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
        assertFalse(schema.isValid(-maxNumber)); // false
        assertFalse(schema.positive().isValid(null));

        schema.required();
        schema.range(nimNumber, maxNumber);
        assertTrue(schema.isValid(nimNumber));
        assertTrue(schema.isValid(maxNumber));
        assertFalse(schema.isValid(nimNumber - 1));
        assertFalse(schema.isValid(maxNumber + 1));
    }

}
