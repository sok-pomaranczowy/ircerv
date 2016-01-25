package pl.edu.uksw.irc.tests;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.edu.uksw.irc.executor.MessageParser;
import pl.edu.uksw.irc.executor.MessageRenderer;
import pl.edu.uksw.irc.executor.User;
import pl.edu.uksw.irc.executor.UserRepository;

import java.nio.channels.SelectionKey;

/**
 * Created by sok_pomaranczowy on 25.01.16.
 */
public class UserRepositoryTest {
    UserRepository repository;

    @Before
    public void onSetUp() {
        repository = new UserRepository();
    }

    @Test
    public void testAddingUniqueUsers() {
        User user1 = new User(Mockito.mock(SelectionKey.class), "user1", "localhost", "zbigniew");
        User user2 = new User(Mockito.mock(SelectionKey.class), "user2", "localhost", "zbigniew");

        Assert.assertTrue(repository.addUser(user1));
        Assert.assertTrue(repository.addUser(user2));

        Assert.assertFalse(repository.addUser(user1));
        Assert.assertFalse(repository.addUser(user2));
    }

    @Test
    public void testDeletingUsers() {
        User user1 = new User(Mockito.mock(SelectionKey.class), "user1", "localhost", "zbigniew");
        User user2 = new User(Mockito.mock(SelectionKey.class), "user2", "localhost", "zbigniew");

        Assert.assertTrue(repository.addUser(user1));
        Assert.assertTrue(repository.addUser(user2));

        Assert.assertTrue(repository.removeUser(user1));
        Assert.assertTrue(repository.removeUser(user2));
    }

    @Test
    public void testAddingExistingUser() {
        User user1 = new User(Mockito.mock(SelectionKey.class), "user1", "localhost", "zbigniew");

        Assert.assertTrue(repository.addUser(user1));
        Assert.assertFalse(repository.addUser(user1));
    }

    @Test
    public void testRemovingNonExistingUser() {
        User user1 = new User(Mockito.mock(SelectionKey.class), "user1", "localhost", "zbigniew");
        Assert.assertFalse(repository.removeUser(user1));
    }
}
