import java.util.Collection;
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
@ToString
@EqualsAndHashCode
public class MageController {
    private MageRepository repository;
    public MageController(MageRepository repository) {
        this.repository = repository;
    }
    public String find(String name) {
        Optional<Mage> optionalMage = repository.find(name);
        return optionalMage.map((Mage::toString)).orElse("not found");
    }
    public String delete(String name) {
        try {
            repository.delete(name);
            return "done";
        } catch (IllegalArgumentException ex) {
            return "not found";
        }
    }
    public String save(String name, String level) {
        try {
            int lvl = Integer.parseInt(level);
            repository.save(new Mage(name, lvl));
            return "done";
        } catch (IllegalArgumentException ex) {
            return "bad request";
        }
    }
}
