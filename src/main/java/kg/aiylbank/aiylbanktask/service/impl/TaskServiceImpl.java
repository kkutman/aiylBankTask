package kg.aiylbank.aiylbanktask.service.impl;

import kg.aiylbank.aiylbanktask.dto.request.TaskRequest;
import kg.aiylbank.aiylbanktask.dto.response.SimpleResponse;
import kg.aiylbank.aiylbanktask.entity.Task;
import kg.aiylbank.aiylbanktask.exception.exceptions.NotFoundException;
import kg.aiylbank.aiylbanktask.repository.TaskRepository;
import kg.aiylbank.aiylbanktask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Override
    public SimpleResponse saveTask(TaskRequest request) {
        Task newTask = Task.builder()
                .description(request.description())
                .completed(request.completed())
                .build();
        repository.save(newTask);
        return SimpleResponse.builder().httpStatus(HttpStatus.OK)
                .message(String.format("The  task was successfully saved with id %s", newTask.getId()))
                .build();
    }

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        if (id == null || id < 0) {
            new SimpleResponse(HttpStatus.BAD_REQUEST, "Invalid task id: " + id);
        }
        assert id != null;
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Task with id %s not found", id))
        );
    }

    @Override
    public SimpleResponse updateTask(Long taskId, TaskRequest request) {
        if (taskId == null || taskId < 0) {
            new SimpleResponse(HttpStatus.BAD_REQUEST, "Invalid task id: " + taskId);
        }
        assert taskId != null;
        Task oldTask = repository.findById(taskId).orElseThrow(
                () -> new NotFoundException(String.format("Task with id %s not found", taskId))
        );
        oldTask.setDescription(request.description());
        oldTask.setCompleted(request.completed());
        repository.save(oldTask);
        return SimpleResponse.builder().httpStatus(HttpStatus.OK)
                .message(String.format("The task was successfully updated with identifier %s", taskId))
                .build();
    }

    @Override
    public SimpleResponse deleteTask(Long id) {
        if (id == null || id < 0) {
            new SimpleResponse(HttpStatus.BAD_REQUEST, "Invalid task id: " + id);
        }
        assert id != null;
        Task oldTask = repository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Task with id %s not found", id))
        );
        repository.delete(oldTask);
        return SimpleResponse.builder().httpStatus(HttpStatus.OK)
                .message(String.format("The task was successfully deleted with identifier %s", id))
                .build();
    }
}









