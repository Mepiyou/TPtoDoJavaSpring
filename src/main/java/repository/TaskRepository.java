package repository;

import model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;


@Repository
public class TaskRepository {

    private final Map<Long, Task> tasks = new HashMap<>();
    // Compteur atomique pour générer des IDs uniques de manière sécurisée
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }
    public Task save(Task task) {
        if (task.getId() == 0) { // Si la tâche n'a pas encore d'ID
            long newId = idCounter.getAndIncrement();
            task.setId(newId);
        }
        tasks.put(task.getId(), task);
        return task;
    }

    public boolean deleteById(Long id) {
        return tasks.remove(id) != null;
    }
}
