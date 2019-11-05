package se.lexicon.simon.car_management.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressTest {


    private Address testObject;

    @BeforeEach
    void setUp() {
        testObject = new Address("Teststreet 1", "12345", "Växjö");
    }

    @Test
    public void testObject_successfully_created(){
        assertEquals(0, testObject.getAddressId());
        assertEquals("Teststreet 1", testObject.getStreet());
        assertEquals("12345", testObject.getZipCode());
        assertEquals("Växjö", testObject.getCity());
    }

    @Test
    public void copyOf_testObject_equals_is_true(){
        Address copy = new Address("Teststreet 1", "12345", "Växjö");
        assertTrue(copy.equals(testObject));
        assertEquals(copy.hashCode(), testObject.hashCode());
    }

    @Test
    public void toString_contains_correct_information(){
        String toString = testObject.toString();
        assertTrue(
            toString.contains("0") &&
                    toString.contains("Teststreet 1") &&
                    toString.contains("12345") &&
                    toString.contains("Växjö")
        );
    }
}
