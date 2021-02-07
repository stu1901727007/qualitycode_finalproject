package uni.plovdiv.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import uni.plovdiv.models.Project;
import uni.plovdiv.models.Task;
import uni.plovdiv.models.TaskMessage;
import uni.plovdiv.models.TaskStatus;
import uni.plovdiv.repositories.interfaces.TaskMessageRepoInterface;
import uni.plovdiv.repositories.interfaces.TaskRepoInterface;
import uni.plovdiv.services.interfaces.TaskMessageServiceInterface;
import uni.plovdiv.services.interfaces.TaskServiceInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class TaskMessageServiceTest {

    private TaskMessageServiceInterface taskMessageService;
    private TaskMessageRepoInterface taskMessageRepo;

    @BeforeEach
    void setUp() {
        this.taskMessageRepo = mock(TaskMessageRepoInterface.class);

        TaskMessage taskMessage = new TaskMessage();
        taskMessage.setTask(new Task());
        taskMessage.setStatus(TaskStatus.NEW);
        taskMessage.setMessage("new task");

        List<TaskMessage> messages = Arrays.asList(taskMessage);

        doReturn(messages).when(this.taskMessageRepo).findAll();
        doReturn(taskMessage).when(this.taskMessageRepo).findById(1);

        this.taskMessageService = new TaskMessageService(this.taskMessageRepo);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * @return
     */
    private static Stream<Arguments> NotValidTaskMessageDetails() {
        return Stream.of(
                Arguments.of(null, null, null),
                Arguments.of(new Task(), null, null),
                Arguments.of(null, TaskStatus.IN_PROGRESS, null),
                Arguments.of(null, null, "message"),
                Arguments.of(null, TaskStatus.IN_PROGRESS, "message"),
                Arguments.of(new Task(), null, "message"),
                Arguments.of(new Task(), TaskStatus.IN_PROGRESS, null)
        );
    }

    @ParameterizedTest
    @MethodSource("NotValidTaskMessageDetails")
    void testCreateTaskMessgaeWithInvalidDetails(Task task, TaskStatus status, String message) throws Exception {
        assertThrows(NullPointerException.class, () -> this.taskMessageService.createMessage(task, status, message));
    }

    @Test
    void testCreateTaskMessgaeWithValidDetails() throws Exception {
        assertTrue(this.taskMessageService.createMessage(new Task(), TaskStatus.IN_PROGRESS, "a") instanceof TaskMessage);
    }
}