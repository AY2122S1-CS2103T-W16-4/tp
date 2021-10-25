package seedu.address.logic.parser.persons;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.persons.EditPersonCommand;

class PersonRemoveLessonParserTest {

    private PersonRemoveLessonParser parser = new PersonRemoveLessonParser();

    @Test
    void parse_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> parser.parse(null));
    }

    @Test
    public void parse_validArgs_returnsCorrectCommand() {
        EditPersonCommand.EditPersonDescriptor editPersonDesc = new EditPersonCommand.EditPersonDescriptor();
        editPersonDesc.removeLesson(INDEX_FIRST_PERSON);
        assertParseSuccess(parser, "1 1", new EditPersonCommand(INDEX_FIRST_PERSON, editPersonDesc,
                PersonRemoveLessonParser.MESSAGE_SUCCESS));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        // all wrong
        assertParseFailure(parser, "abcdefgh", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                PersonRemoveLessonParser.MESSAGE_USAGE));

        // half right :)
        assertParseFailure(parser, "1 abc", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                PersonRemoveLessonParser.MESSAGE_USAGE));
    }
}
