package seedu.address.logic.commands.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_TASKS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalObjects.getTypicalAddressBook;
import static seedu.address.testutil.TypicalTasks.MATH_HOMEWORK;
import static seedu.address.testutil.TypicalTasks.STATS_ASSIGNMENT;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.task.TaskNameContainsKeywordsPredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code FindTaskCommand}.
 */
public class FindTaskCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        TaskNameContainsKeywordsPredicate firstPredicate =
                new TaskNameContainsKeywordsPredicate(Collections.singletonList("first"));
        TaskNameContainsKeywordsPredicate secondPredicate =
                new TaskNameContainsKeywordsPredicate(Collections.singletonList("second"));

        FindTaskCommand findFirstCommand = new FindTaskCommand(firstPredicate);
        FindTaskCommand findSecondCommand = new FindTaskCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindTaskCommand findFirstCommandCopy = new FindTaskCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different task -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noTaskFound() {
        String expectedMessage = String.format(MESSAGE_TASKS_LISTED_OVERVIEW, 0);
        TaskNameContainsKeywordsPredicate predicate = preparePredicate(" ");
        FindTaskCommand command = new FindTaskCommand(predicate);
        expectedModel.updateFilteredTaskList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredTaskList());
    }

    @Test
    public void execute_multipleKeywords_multipleTasksFound() {
        String expectedMessage = String.format(MESSAGE_TASKS_LISTED_OVERVIEW, 2);
        TaskNameContainsKeywordsPredicate predicate = preparePredicate("assignment homework");
        FindTaskCommand command = new FindTaskCommand(predicate);
        expectedModel.updateFilteredTaskList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(MATH_HOMEWORK, STATS_ASSIGNMENT), model.getFilteredTaskList());
    }

    /**
     * Parses {@code userInput} into a {@code TaskNameContainsKeywordsPredicate}.
     */
    private TaskNameContainsKeywordsPredicate preparePredicate(String userInput) {
        return new TaskNameContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
