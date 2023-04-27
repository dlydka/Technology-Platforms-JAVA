import java.util.Comparator;

public class FamilyComparator implements Comparator<FamilyMember> {
@Override
public int compare(FamilyMember o1, FamilyMember o2) {
       int ret = o1.getName().compareTo(o2.getName());

       if (ret == 0) {
              double a = (o1.getHeight() - o2.getHeight()) * 100;
              ret = (int) a;
       }

       if (ret == 0) {
              ret = o1.getAge() - o2.getAge();
       }

       return ret;
}
}
