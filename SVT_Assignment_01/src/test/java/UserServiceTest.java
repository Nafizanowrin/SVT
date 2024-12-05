import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


//                           ** Question 8 **

    @Test
    void FindUser() {

        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        User mockUser = new User(7, "Nowrin");
        when(userRepository.findById(1)).thenReturn(mockUser);

        User result = userService.findUserById(1);

        // Verify the behavior
        assertNotNull(result);
        assertEquals(7, result.getId());
        assertEquals("Nowrin", result.getName());

        // Verify the interaction with the mock
        verify(userRepository).findById(1);
    }
}
