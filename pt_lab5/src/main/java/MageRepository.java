import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MageRepository {
    private Collection<Mage> collection;

    public Optional<Mage> find(String name) {
        for (Mage mage : collection) {
            if (Objects.equals(name, mage.getName())){
                return Optional.of(mage);
            }
        }
        return Optional.empty();
    }
    public void delete(String name) {
        collection.removeIf(mage -> Objects.equals(name, mage.getName()));
        throw new IllegalArgumentException();
    }
    public void save(Mage mage) {
        for (Mage mage1 : collection) {
            if (Objects.equals(mage.getName(), mage1.getName())) {
                throw new IllegalArgumentException();
            }
        }
        collection.add(mage);
    }

}
