package auca.ac.rw.question5_task_api.controller.Task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import auca.ac.rw.question5_task_api.modal.taskmanagement.Task;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task(1L, "Finish Assignment", "Complete REST API project", false, "HIGH", "2026-02-10"));
        tasks.add(new Task(2L, "Study Spring Boot", "Revise controllers", true, "MEDIUM", "2026-02-08"));
        tasks.add(new Task(3L, "Buy groceries", "Milk and bread", false, "LOW", "2026-02-09"));
    }

    // GET /api/tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(tasks);
    }

    // GET /api/tasks/{taskId}
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                return ResponseEntity.ok(task);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // GET /api/tasks/status?completed=true
    @GetMapping("/status")
    public ResponseEntity<List<Task>> getTasksByStatus(@RequestParam boolean completed) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted() == completed) {
                result.add(task);
            }
        }
        return ResponseEntity.ok(result);
    }

    // GET /api/tasks/priority/{priority}
    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Task>> getTasksByPriority(@PathVariable String priority) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                result.add(task);
            }
        }
        return ResponseEntity.ok(result);
    }

    // POST /api/tasks
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        tasks.add(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    // PUT /api/tasks/{taskId}
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setPriority(updatedTask.getPriority());
                task.setDueDate(updatedTask.getDueDate());
                task.setCompleted(updatedTask.isCompleted());
                return ResponseEntity.ok(task);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // PATCH /api/tasks/{taskId}/complete
    @PatchMapping("/{taskId}/complete")
    public ResponseEntity<Task> markCompleted(@PathVariable Long taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                task.setCompleted(true);
                return ResponseEntity.ok(task);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // DELETE /api/tasks/{taskId}
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                tasks.remove(task);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
