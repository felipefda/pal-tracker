package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeEntryRepository {
    @Autowired
    InMemoryTimeEntryRepository repository;

    public TimeEntry create(TimeEntry any) {
        return repository.create(any);
    }

    public TimeEntry find(long timeEntryId) {
        return repository.find(timeEntryId);
    }

    public List<TimeEntry> list() {
        return repository.list();
    }

    public TimeEntry update(long eq, TimeEntry any) {
        return repository.update(eq, any);
    }

    public void delete(long timeEntryId) {
        repository.delete(timeEntryId);
    }
}
