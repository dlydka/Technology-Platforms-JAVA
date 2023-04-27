import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MageRepositoryTest {
    Collection<Mage> collection = new ArrayList<>();

    @Test
    public void find_notExistingObject() {
        Mage mage1 =  new Mage("Mage1", 1);
        collection.add(mage1);
        MageRepository repository = new MageRepository(collection);

        Mage mage2 = new Mage("Mage2", 2);
        Optional<Mage> optional = repository.find(mage2.getName());
        assertThat(optional).isEmpty();
    }

    @Test
    public void find_existingObject() {
        Mage mage1 =  new Mage("Mage1", 1);
        collection.add(mage1);
        MageRepository repository = new MageRepository(collection);

        Optional<Mage> optional = repository.find(mage1.getName());
        assertThat(optional).isNotEmpty();
    }

    @Test
    public void delete_notExistingObject() {
        Mage mage1 =  new Mage("Mage1", 1);
        collection.add(mage1);
        MageRepository repository = new MageRepository(collection);

        Mage mage2 = new Mage("Mage2", 2);

        assertThrows(IllegalArgumentException.class, () -> {
            repository.delete(mage2.getName());
        });
    }

    @Test
    public void save_existingKey() {
        Mage mage1 =  new Mage("Mage1", 1);
        collection.add(mage1);
        MageRepository repository = new MageRepository(collection);

        Mage mage2 = new Mage("Mage1", 2);

        assertThrows(IllegalArgumentException.class, () -> {
            repository.save(mage2);
        });
    }
}