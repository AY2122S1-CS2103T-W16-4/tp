package seedu.address.model.id;

import org.junit.jupiter.api.Test;
import seedu.address.model.person.Person;
import seedu.address.model.task.Task;
import seedu.address.testutil.TypicalPersons;
import seedu.address.testutil.TypicalTasks;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UniqueIdTest {
    List<Task> tasks = TypicalTasks.getTypicalTasks();
    List<Person> students = TypicalPersons.getTypicalPersons();

    @Test
    public void generateIdTest() {
        // id should be unique
        for (int i = 0; i < tasks.size() - 1; i++) {
            assertNotEquals(UniqueId.generateId(tasks.get(i)), UniqueId.generateId(tasks.get(i + 1)));
        }

        for (int i = 0; i < students.size() - 1; i++) {
            assertNotEquals(UniqueId.generateId(students.get(i)), UniqueId.generateId(students.get(i + 1)));
        }
    }

    @Test
    public void getOwnerTest() {
        for (Task task : tasks) {
            assertEquals(task, task.getId().getOwner());
        }
        for (Person student : students) {
            assertEquals(student, student.getId().getOwner());
        }
    }

    @Test
    public void equalsTest() {
        UniqueId id1 = UniqueId.generateId(tasks.get(0));
        UniqueId id2 = UniqueId.generateId(students.get(0));

        // Same id and owner -> equal
        assertEquals(id1, id1);
        assertEquals(id2, id2);

        // Not equal to null
        assertNotEquals(null, id1);
        assertNotEquals(null, id2);

        // Same owner but different id -> Not equal
        assertNotEquals(tasks.get(0).getId(), id1);
        assertNotEquals(students.get(0).getId(), id2);

        // Different id -> Not equal
        assertNotEquals(id1, id2);
    }

    @Test
    public void toStringTest() {
        for (Task task : tasks) {
            assertTrue(task.getId().toString().startsWith("T-"));
        }
        for (Person student : students) {
            assertTrue(student.getId().toString().startsWith("S-"));
        }

        HasUniqueIdStub hasUniqueIdStub = new HasUniqueIdStub();
        assertEquals("#INVALID", hasUniqueIdStub.getId().toString());
    }

    public static class HasUniqueIdStub implements HasUniqueId {
        @Override
        public UniqueId getId() {
            return UniqueId.generateId(this);
        }
    }
}
