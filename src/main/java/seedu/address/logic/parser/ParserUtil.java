package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.FRIDAY;
import static seedu.address.logic.parser.CliSyntax.MONDAY;
import static seedu.address.logic.parser.CliSyntax.SATURDAY;
import static seedu.address.logic.parser.CliSyntax.SUNDAY;
import static seedu.address.logic.parser.CliSyntax.THURSDAY;
import static seedu.address.logic.parser.CliSyntax.TUESDAY;
import static seedu.address.logic.parser.CliSyntax.WEDNESDAY;

import java.time.DayOfWeek;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.lesson.Subject;
import seedu.address.model.lesson.Timeslot;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";
    public static final String MESSAGE_INVALID_DAY = "Day is not recognized, it should be the short form of each day. "
            + String.format("%s,%s,%s for example.", MONDAY, WEDNESDAY, SATURDAY);

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    /**
     * Parses a {@code String subject} into a {@code Subject}.
     * @param subject string name of a subject
     * @return Subject that was represented by string
     * @throws ParseException if the {@code subject} is invalid.
     */
    public static Subject parseSubject(String subject) throws ParseException {
        requireNonNull(subject);
        subject = subject.trim();
        if (!Subject.isValidName(subject)) {
            throw new ParseException(Subject.MESSAGE_CONSTRAINTS);
        }
        return new Subject(subject);
    }

    /**
     * Parses a {@code String startTime} and {@code String endTime} into a {@code Timeslot}
     * @param startTime start time in required format
     * @param endTime end time in required format
     * @return Timeslot with the given start and end times
     * @throws ParseException if the timings are invalid
     */
    public static Timeslot parseTimeslot(String startTime, String endTime) throws ParseException {
        requireNonNull(startTime);
        requireNonNull(endTime);
        startTime = startTime.trim();
        endTime = endTime.trim();
        if (!Timeslot.isValidTimeslot(startTime, endTime)) {
            throw new ParseException(Timeslot.MESSAGE_CONSTRAINTS);
        }
        return new Timeslot(startTime, endTime);
    }

    /**
     * Parses a {@code String day} into a {@code DayOfWeek}
     * @param day String representation of a day
     * @return a DayOfWeek with the day represented in the String
     * @throws ParseException if the String is invalid
     */
    public static DayOfWeek parseDayOfWeek(String day) throws ParseException {
        requireNonNull(day);
        day = day.trim().toLowerCase(Locale.ROOT);
        int dayNum;
        switch(day) {
        case MONDAY:
            dayNum = 1;
            break;
        case TUESDAY:
            dayNum = 2;
            break;
        case WEDNESDAY:
            dayNum = 3;
            break;
        case THURSDAY:
            dayNum = 4;
            break;
        case FRIDAY:
            dayNum = 5;
            break;
        case SATURDAY:
            dayNum = 6;
            break;
        case SUNDAY:
            dayNum = 7;
            break;
        default:
            throw new ParseException(MESSAGE_INVALID_DAY);
        }
        return DayOfWeek.of(dayNum);
    }
}
