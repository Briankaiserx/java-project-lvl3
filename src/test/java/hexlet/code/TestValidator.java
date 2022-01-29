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
    @Test
    public void testValidatorNumber(){
        Validator v = new Validator();
        NumberSchema schema = v.numberSchema();
        assertTrue(schema.isValid(null));

        schema.required();

        assertTrue(schema.isValid(8));
        assertFalse(schema.isValid("5"));
        assertFalse(schema.isValid(null));


        assertTrue(schema.positive().isValid(8)); // true
        assertFalse(schema.isValid(-8)); // false
        assertFalse(schema.positive().isValid(null)); // true

        schema.required();
        schema.range(3, 8);
        assertTrue(schema.isValid(3)); // true
        assertTrue(schema.isValid(8)); // true
        assertFalse(schema.isValid(3 - 1)); // false
        assertFalse(schema.isValid(8 + 1)); // false
    }

}