import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class MageControllerTest {

    @Test
    public void delete_notExistingObject() {
        Mage mage = new Mage("Mage1", 1);
        MageRepository repository = mock(MageRepository.class);
        doThrow(new IllegalArgumentException()).when(repository).delete(mage.getName());

        MageController controller = new MageController(repository);
        String result = controller.delete(mage.getName());

        assertThat(result).isEqualTo("not found");
        verify(repository).delete(refEq(mage.getName()));
    }

    @Test
    public void delete_existingObject() {
        Mage mage = new Mage("Mage1", 1);
        MageRepository repository = mock(MageRepository.class);
        doThrow(new IllegalArgumentException()).when(repository).save(mage);

        MageController controller = new MageController(repository);
        String result = controller.delete(mage.getName());

        assertThat(result).isEqualTo("done");
        verify(repository).delete(refEq(mage.getName()));
    }

    @Test
    public void save_notExistingObject() {
        Mage mage = new Mage("Mage1", 1);
        MageRepository repository = mock(MageRepository.class);
        doThrow(new IllegalArgumentException()).when(repository).delete(mage.getName());

        MageController controller = new MageController(repository);
        String result = controller.save(mage.getName(), String.valueOf(mage.getLevel()));

        assertThat(result).isEqualTo("done");
        verify(repository).save(refEq(mage));
    }

    @Test
    public void save_existingObject() {
        Mage mage = new Mage("Mage1", 1);
        MageRepository repository = mock(MageRepository.class);
        doThrow(new IllegalArgumentException()).when(repository).save(mage);

        MageController controller = new MageController(repository);
        String result = controller.save(mage.getName(), String.valueOf(mage.getLevel()));

        assertThat(result).isEqualTo("bad request");
        verify(repository).save(refEq(mage));
    }

    @Test
    public void find_notExistingObject() {
        Mage mage = new Mage("Mage1", 1);
        MageRepository repository = mock(MageRepository.class);
        doThrow(new IllegalArgumentException()).when(repository).delete(mage.getName());

        MageController controller = new MageController(repository);
        String result = controller.find(mage.getName());

        assertThat(result).isEqualTo("not found");
        verify(repository).find(refEq(mage.getName()));
    }

    @Test
    public void find_existingObject() {
        Mage mage = new Mage("Mage1", 1);
        MageRepository repository = mock(MageRepository.class);
        when(repository.find(mage.getName())).thenReturn(Optional.of(mage));

        MageController controller = new MageController(repository);
        String result = controller.find(mage.getName());

        assertThat(result).isEqualTo(mage.toString());
        verify(repository).find(refEq(mage.getName()));
    }
}
