package org.b2.tptodo.service;

import org.b2.tptodo.model.Task;
import org.b2.tptodo.model.TaskStatus;
import org.b2.tptodo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task not found with id: " + id));
    }

    public Task createTask(Task task) {
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre est obligatoire");
        }
        if (task.getStatus() == null) {
            task.setStatus(TaskStatus.TODO);
        }
        return taskRepository.save(task);
    }

    // Mise à jour complète
    public Task updateTask(Long id, Task taskDetails) {
        Task existingTask = getTaskById(id); // Lance 404 si introuvable

        if (taskDetails.getTitle() == null || taskDetails.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide");
        }

        existingTask.setTitle(taskDetails.getTitle());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setStatus(taskDetails.getStatus());
        existingTask.setDueDate(taskDetails.getDueDate());

        return taskRepository.save(existingTask);
    }

    // Mise à jour partielle du statut
    public Task updateStatus(Long id, String statusStr) {
        Task task = getTaskById(id);

        try {
            TaskStatus newStatus = TaskStatus.valueOf(statusStr.toUpperCase());
            task.setStatus(newStatus);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Status invalide. Valeurs possibles: TODO, IN_PROGRESS, DONE");
        }

        return taskRepository.save(task);
    }

    // Suppression
    public void deleteTask(Long id) {
        if (!taskRepository.deleteById(id)) {
            throw new NoSuchElementException("Impossible de supprimer : Task non trouvée avec l'id: " + id);
        }
    }
}
