package kg.aiylbank.aiylbanktask.service;

import kg.aiylbank.aiylbanktask.dto.request.TaskRequest;
import kg.aiylbank.aiylbanktask.dto.response.SimpleResponse;
import kg.aiylbank.aiylbanktask.entity.Task;

import java.util.List;

public interface TaskService {
    SimpleResponse saveTask(TaskRequest request);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    SimpleResponse updateTask(Long taskId,TaskRequest request);
    SimpleResponse deleteTask (Long id);
}
