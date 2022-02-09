package hexlet.code;


import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
    public void testValidatorStringMinLength() {
        //Почему-то тест работал некорректно, когда я его поместил в общий метод теста testValidatorString()
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        assertTrue(schema.minLength(2).isValid("fo"));
        assertFalse(schema.minLength(maxNumber).isValid("what"));
    }
    private final int nimNumber = 3;
    private final int maxNumber = 8;
    @Test
    public void testValidatorNumber() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
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
        MapSchema schema = v.map();
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

    @Test
    public void testValidatorMapShape() {
        Validator v = new Validator();

        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", maxNumber);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertFalse(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -nimNumber);
        assertFalse(schema.isValid(human4));
    }
}
