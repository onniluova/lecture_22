import org.junit.Test;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.io.InputStreamReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class LocalizedGreetingTest {

    @Test
    public void testEnglishGreeting() {
        Locale locale = new Locale("en", "US");
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        String greeting = messages.getString("greeting");
        assertEquals("Hello!", greeting);
    }

    @Test
    public void testSpanishGreeting() {
        Locale locale = new Locale("es", "ES");
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        String greeting = messages.getString("greeting");
        assertEquals("Hola!", greeting);
    }

    @Test
    public void testFrenchGreeting() {
        Locale locale = new Locale("fr", "FR");
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        String greeting = messages.getString("greeting");
        assertEquals("Bonjour!", greeting);
    }

    @Test
    public void testInvalidChoiceDefaultsToEnglish() {
        Locale locale = new Locale("en", "US"); // Simulate default choice
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        String greeting = messages.getString("greeting");
        assertEquals("Hello!", greeting); // Expected default is English
    }

    @Test
    public void testPersianGreeting() throws IOException {
        Locale locale = new Locale("fa", "IR");
        try (InputStreamReader reader = new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("MessagesBundle_fa_IR.properties"), "UTF-8")) {
            ResourceBundle messages = new PropertyResourceBundle(reader);
            String greeting = messages.getString("greeting");
            assertEquals("سلام! به برنامه ما خوش آمدی", greeting);
        }
    }
}