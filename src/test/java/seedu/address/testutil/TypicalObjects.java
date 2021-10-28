package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.TypicalLessons.MON_10_12_BIOLOGY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.lesson.NoOverlapLessonList;
import seedu.address.model.person.Person;
import seedu.address.model.task.Task;

/**
 * A utility class containing a list of {@code Person} and {@code Task} objects to be used in tests.
 */
public class TypicalObjects {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253")
            .withTags("friends")
            .withLessonsList((new NoOverlapLessonList()).addLesson(MON_10_12_BIOLOGY))
            .withId("05404585-7339-4fb4-9899-c470e0068829")
            .build();

    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withTags("owesMoney", "friends").withId("99f5ad00-6e1b-49c8-98d8-5ae3459bb262").build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street")
            .withId("984c2915-9d24-4931-917c-03b98c621f39").build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends")
            .withId("559ab00a-ce9a-4799-be3d-a126290707b1").build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave")
            .withId("25706097-cc50-4832-b972-2a115f08f26f").build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo")
            .withId("bcf3308b-6813-4482-96e4-7eae771e78f4").build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street")
            .withId("f4907d65-ffdb-4041-ae04-5165214eec67").build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    public static final Task REPORT_1 = new TaskBuilder().withDescription("Report 1")
            .withUniqueId("f31648db-5619-4bad-99d2-87367a2b5f28").withDeadline("2021-10-10").build();

    public static final Task REPORT_2 = new TaskBuilder().withDescription("Report 2")
            .withUniqueId("84213370-69bf-44e4-9d11-229411f3c1c9").withDeadline("2021-10-20").build();
    public static final Task MATH_HOMEWORK = new TaskBuilder().withDescription("Math Homework")
            .withUniqueId("d3ecfc97-be80-40b3-a798-1674c542ed46").withDeadline("2021-12-21").build();
    public static final Task STATS_ASSIGNMENT = new TaskBuilder().withDescription("Statistics assignment")
            .withUniqueId("c6ada13b-2617-4870-8f57-d9c39c94229b").withDeadline("2021-11-15").build();

    private TypicalObjects() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        for (Task task : getTypicalTasks()) {
            ab.addTask(task);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(List.of(REPORT_1, REPORT_2,
                MATH_HOMEWORK, STATS_ASSIGNMENT));
    }
}
