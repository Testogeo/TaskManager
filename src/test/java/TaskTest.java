import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(123, "Купить Хлеб");

        boolean actual = task.matches("Хлеб");


        Assertions.assertTrue(actual);

    }

    @Test
    public void testSimpleTaskNOTMatches() {
        SimpleTask task = new SimpleTask(123, "Купить Хлеб");

        boolean actual = task.matches("Колбаса");

        Assertions.assertFalse(actual);

    }

    @Test
    public void testEpicMatches() {
        Epic task = new Epic(22, new String[]{"Молоко", "Яйцо", "Хлеб"});

        boolean actual = task.matches("Яйцо");


        Assertions.assertTrue(actual);
    }

    @Test
    public void testNotEpicMatches() {
        Epic task = new Epic(22, new String[]{"Молоко", "Яйцо", "Хлеб"});

        boolean actual = task.matches("Нефть");


        Assertions.assertFalse(actual);
    }

    @Test
    public void testMatchesReturnsTrueWhenQueryInTopic() {
        Meeting meeting = new Meeting(1, "Встреча", "Китай", "2024-01-13 09:00:00");
        String query = "Встреча";

        boolean actual = meeting.matches(query);

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesReturnsTrueWhenQueryInProject() {
        Meeting meeting = new Meeting(1, "Встреча", "Китай", "2024-01-13 09:00:00");
        String query = "Китай";

        boolean actual = meeting.matches(query);

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesReturnsFalseWhenQueryNotInTopicOrProject() {
        Meeting meeting = new Meeting(1, "Встреча", "Китай", "2024-01-13 09:00:00");
        String query = "Корея";

        boolean actual = meeting.matches(query);

        Assertions.assertFalse(actual);
    }
}