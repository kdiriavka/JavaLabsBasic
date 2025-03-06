import model.University;
import org.junit.jupiter.api.Test;
import utils.JsonManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityTest {
    @Test
    public void testJsonSerialization() {
        String filePath = "test_university.json";

        // Створення об'єкта університету
        University oldUniversity = Run.createTypicalUniversity();

        // Записуємо в JSON
        JsonManager.saveToJson(oldUniversity, filePath);

        // Зчитуємо з JSON
        University newUniversity = JsonManager.loadFromJson(filePath);

        // Перевіряємо еквівалентність об'єктів
        assertEquals(oldUniversity, newUniversity, "Universities should be equal after JSON serialization and deserialization");
    }
}
