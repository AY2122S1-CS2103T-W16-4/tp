package seedu.address.model.lesson;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import seedu.address.model.person.Name;

/**
 * Represents a lessons that has a day, timing and subject to be taught
 */
public class Lesson implements Comparable<Lesson> {

    // Scheduling fields
    private final Timeslot timeslot;
    private final DayOfWeek dayOfWeek;

    // Identity fields
    private final Subject subject;
    private final List<Name> attendees;
    /**
     * Every field must be present and not null.
     */
    public Lesson(Timeslot timeslot, Subject subject, DayOfWeek dayOfWeek, List<Name> attendees) {
        requireAllNonNull(timeslot, subject, dayOfWeek, attendees);
        this.timeslot = timeslot;
        this.subject = subject;
        this.dayOfWeek = dayOfWeek;
        this.attendees = attendees;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public Subject getSubject() {
        return subject;
    }

    public List<Name> getAttendees() {
        return Collections.unmodifiableList(attendees);
    }

    public void addAttendee(Name name) {
        attendees.add(name);
    }

    /**
     * Returns true if lessons overlap within the same period
     * Overlap is defined as timings overlapping and being on the same day
     * @param other The other lesson object to check overlap with
     * @return true if lessons do overlap, false otherwise
     */
    public boolean doLessonsOverlap(Lesson other) {
        if (other == null || !dayOfWeek.equals(other.dayOfWeek)) {
            return false;
        }

        return timeslot.doTimingsOverlap(other.timeslot);
    }

    /**
     * Returns true if both persons have the same identity and schedules
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Lesson)) {
            return false;
        }

        Lesson otherLesson = (Lesson) other;
        return otherLesson.timeslot.equals(timeslot)
                && otherLesson.dayOfWeek.equals(dayOfWeek)
                && otherLesson.subject.equals(subject);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(timeslot, dayOfWeek, subject);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(subject)
                .append(" on ")
                .append(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH))
                .append(" from ")
                .append(timeslot);

        return builder.toString();
    }


    @Override
    public int compareTo(Lesson o) {
        if (dayOfWeek.compareTo(o.dayOfWeek) != 0) {
            // if not same day, judge based on day
            return dayOfWeek.compareTo(o.dayOfWeek);
        } else {
            // judge based on timeslot
            return timeslot.compareTo(o.timeslot);
        }
    }
}
