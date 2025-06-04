import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    void testValidPerson() {
        Person person = new Person(
            "56s_d%&fAB", 
            "John", 
            "Doe", 
            "32|Highland Street|Melbourne|Victoria|Australia", 
            "15-11-1990"
        );
        
        assertTrue(person.addPerson());
    }

    @Test
    void testInvalidPersonID() {
        Person person = new Person(
            "56s_d%&f",  // Too short
            "John", 
            "Doe", 
            "32|Highland Street|Melbourne|Victoria|Australia", 
            "15-11-1990"
        );
        
        assertFalse(person.addPerson());
    }

    @Test
    void testInvalidAddress() {
        Person person = new Person(
            "56s_d%&fAB", 
            "John", 
            "Doe", 
            "32|Highland Street|Melbourne|NSW|Australia",  // Wrong state
            "15-11-1990"
        );
        
        assertFalse(person.addPerson());
    }

    @Test
    void testInvalidBirthdate() {
        Person person = new Person(
            "56s_d%&fAB", 
            "John", 
            "Doe", 
            "32|Highland Street|Melbourne|Victoria|Australia", 
            "15/11/1990"  // Wrong format
        );
        
        assertFalse(person.addPerson());
    }

    @Test
    void testGetters() {
        Person person = new Person(
            "78#$%mnpCD", 
            "Sarah", 
            "Connor", 
            "123|Main Street|Melbourne|Victoria|Australia", 
            "25-12-1985"
        );
        
        assertEquals("Sarah", person.getFirstName());
        assertEquals("Connor", person.getLastName());
        assertFalse(person.isSuspended());
    }
}