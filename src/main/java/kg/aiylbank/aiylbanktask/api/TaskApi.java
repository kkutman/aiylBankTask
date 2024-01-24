package kg.aiylbank.aiylbanktask.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.aiylbank.aiylbanktask.dto.request.TaskRequest;
import kg.aiylbank.aiylbanktask.dto.response.SimpleResponse;
import kg.aiylbank.aiylbanktask.entity.Task;
import kg.aiylbank.aiylbanktask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
@Tag(name = "Task", description = "Task API")
public class TaskApi {
    private final TaskService taskService;

    @PostMapping("/save")
    @Operation(summary = "Save task", description = "This method is used to save the task")
    SimpleResponse saveTask(@RequestBody TaskRequest request) {
        return taskService.saveTask(request);
    }

    @GetMapping("/get_all")
    @Operation(summary = "Get all task", description = "This method retrieves all task")
    List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }



    @GetMapping("/get_by")
    @Operation(summary = "Get by ID task", description = "This method get by ID task")
    Task getTaskById(@RequestParam Long id) {
        return taskService.getTaskById(id);
    }



    @PutMapping("/update")
    @Operation(summary = "Updated task", description = "This method is for task updates")
    SimpleResponse updateTask(@RequestParam Long taskId, @RequestBody TaskRequest request) {
        return taskService.updateTask(taskId, request);
    }



    @DeleteMapping("delete")
    @Operation(summary = "Deleted task", description = "This method is for task removal")
    SimpleResponse deleteTask(@RequestParam Long id) {
        return taskService.deleteTask(id);
    }


}
