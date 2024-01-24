package kg.aiylbank.aiylbanktask;

import kg.aiylbank.aiylbanktask.dto.request.TaskRequest;
import kg.aiylbank.aiylbanktask.dto.response.SimpleResponse;
import kg.aiylbank.aiylbanktask.entity.Task;
import kg.aiylbank.aiylbanktask.exception.exceptions.NotFoundException;
import kg.aiylbank.aiylbanktask.repository.TaskRepository;
import kg.aiylbank.aiylbanktask.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;


import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

public class TestTaskServices {
    private TaskRepository mock = mock(TaskRepository.class);

    private TaskServiceImpl serviceW = new TaskServiceImpl(mock);


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveTask() {
        TaskRepository mockRepository = mock();
        TaskServiceImpl service = serviceW;

        TaskRequest request = new TaskRequest("Task description", false);

        SimpleResponse response = service.saveTask(request);

        verify(mockRepository).save(argThat(task -> {
            assertEquals("Task description", task.getDescription());
            assertFalse(task.isCompleted());
            return true;
        }));

        assertEquals(HttpStatus.OK, response.httpStatus());
        assertEquals("The task was successfully saved with id 1", response.message()); // Предположим, что ID задачи равен 1
    }

    @Test
    public void testGetAllTasks() {
        TaskRepository mockRepository = mock();
        TaskServiceImpl service = serviceW;

        when(mockRepository.findAll()).thenReturn(Collections.emptyList());

        List<Task> tasks = service.getAllTasks();

        assertNotNull(tasks);
        assertTrue(tasks.isEmpty());
    }

    @Test
    public void testGetTaskById() {
        TaskRepository mockRepository = mock();
        TaskServiceImpl service = serviceW;

        when(mockRepository.findById(1L)).thenReturn(java.util.Optional.of(new Task()));

        Task task = service.getTaskById(1L);

        assertNotNull(task);
    }

    @Test
    public void testUpdateTask() {
        TaskRepository mockRepository = mock();
        TaskServiceImpl service = serviceW;

        when(mockRepository.findById(1L)).thenReturn(java.util.Optional.of(new Task()));

        TaskRequest request = new TaskRequest("Updated description", true);

        SimpleResponse response = service.updateTask(1L, request);

        verify(mockRepository).save(argThat(task -> {
            assertEquals("Updated description", task.getDescription());
            assertTrue(task.isCompleted());
            return true;
        }));

        assertEquals(HttpStatus.OK, response.httpStatus());
        assertEquals("The task was successfully updated with identifier 1", response.message());
    }

    @Test
    public void testDeleteTask() {
        TaskRepository mockRepository = mock();
        TaskServiceImpl service = serviceW;

        when(mockRepository.findById(1L)).thenReturn(java.util.Optional.of(new Task()));

        SimpleResponse response = service.deleteTask(1L);

        verify(mockRepository).delete(any());

        assertEquals(HttpStatus.OK, response.httpStatus());
        assertEquals("The task was successfully deleted with identifier 1", response.message());
    }

    @Test
    public void testDeleteTask_InvalidId() {
        TaskServiceImpl service = serviceW;

        SimpleResponse response = service.deleteTask(-1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.httpStatus());
        assertEquals("Invalid task id: -1", response.message());
    }

    @Test
    public void testDeleteTask_NotFound() {
        TaskRepository mockRepository = mock();
        TaskServiceImpl service = serviceW;

        when(mockRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> service.deleteTask(1L));

        assertEquals("Task with id 1 not found", exception.getMessage());
    }
}
