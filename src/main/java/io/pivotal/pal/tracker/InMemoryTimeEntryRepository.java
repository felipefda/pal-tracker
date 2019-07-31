package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    List<TimeEntry> list = new ArrayList<>();
    private long id = 1L;

    public TimeEntry create(TimeEntry timeEntry) {
        long id;

        timeEntry.setId(this.id);
        list.add(timeEntry);
        this.id++;
        return timeEntry;
    }

    public TimeEntry find(long id) {
        for (TimeEntry row : list) {
            if (row.getId() == id) {
                return row;
            }
        }
        return null;
    }

    public List<TimeEntry> list() {
        return list;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry old = this.find(id);
        if (old != null) {
            list.remove(old);
            timeEntry.setId(id);
            list.add(timeEntry);
            return timeEntry;
        } else {
            return null;
        }
    }

    public void delete(long id) {
        TimeEntry entry = this.find(id);
        list.remove(entry);
    }
}
