package seedu.address.model.id;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

import seedu.address.model.person.Person;
import seedu.address.model.task.Task;

/**
 * A class that represents unique ids for tasks/students using UUID.
 */
public class UniqueId {
    /**
     * The owner of the id. It can be a task or a student.
     */
    private final HasUniqueId owner;
    private final UUID id;

    private UniqueId(HasUniqueId owner) {
        requireNonNull(owner);
        this.owner = owner;
        this.id = UUID.randomUUID();
    }

    /**
     * Generates a unique id for a task.
     *
     * @return A unique id for a task.
     */
    public static UniqueId generateId(HasUniqueId owner) {
        return new UniqueId(owner);
    }

    public HasUniqueId getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof UniqueId)) {
            return false;
        }

        UniqueId otherId = (UniqueId) other;
        return this.id.equals(otherId.id) && this.owner.equals(otherId.owner);
    }

    @Override
    public String toString() {
        if (owner instanceof Task) {
            return "T-" + this.id.toString();
        }
        if (owner instanceof Person) {
            return "S-" + this.id.toString();
        }

        return "#INVALID";
    }
}
