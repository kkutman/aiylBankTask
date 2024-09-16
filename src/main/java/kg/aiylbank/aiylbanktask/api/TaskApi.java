package kg.aiylbank.aiylbanktask.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task"
)
@Tag(name = "Task", description = "Task API")
public class TaskApi {

    @PostMapping("/save")
    @Operation(summary = "Save task", description = "This method is used to save the task")
    String saveTask() {
        return "taskService.saveTask(request)";
    }
}
