package seedu.address.logic.parser.persons;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.persons.EditPersonCommand;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_EXAM;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

public class PersonRemoveExamParserTest {

    private PersonRemoveExamParser parser = new PersonRemoveExamParser();

    private String INVALID_FORMAT = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            PersonRemoveExamParser.MESSAGE_USAGE);

    @Test
    public void parse_validArgs_returnsCorrectCommand() {
        EditPersonCommand.EditPersonDescriptor descriptor = new EditPersonCommand.EditPersonDescriptor();
        descriptor.removeExam(INDEX_FIRST_EXAM);
        assertParseSuccess(parser,  INDEX_FIRST_PERSON.getOneBased() + " " + INDEX_FIRST_EXAM.getOneBased(),
                new EditPersonCommand(INDEX_FIRST_PERSON, descriptor, PersonRemoveExamParser.MESSAGE_SUCCESS));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "...", INVALID_FORMAT);

        assertParseFailure(parser, "abc 1", INVALID_FORMAT);
    }
}
