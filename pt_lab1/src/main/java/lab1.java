import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class lab1 {
    public static void main(String[] args) {
        FamilyMember mem1 = new FamilyMember("Andrzej", 60, 1.89, null);
        FamilyMember mem2 = new FamilyMember("Jacek", 60, 1.89, null);
        FamilyMember mem3 = new FamilyMember("Witold", 35, 1.89, null);
        FamilyMember mem4 = new FamilyMember("Wieslaw", 40, 1.67, null);
        FamilyMember mem5 = new FamilyMember("Dawid", 25, 1.88, null);
        FamilyMember mem6 = new FamilyMember("Dawid", 25, 1.80, null);
        FamilyMember mem7 = new FamilyMember("Ignacy", 22, 1.59, null);
        FamilyMember mem8 = new FamilyMember("Dawid", 26, 1.80, null);
        FamilyMember mem9 = new FamilyMember("Maciej", 21, 1.84, null);
        FamilyMember mem10 = new FamilyMember("Rafal", 18, 1.79, null);

        Set<FamilyMember> children1 = new TreeSet<>();
        children1.add(mem2);
        children1.add(mem3);
        children1.add(mem4);
        mem1.setChildren(children1);

        Set<FamilyMember> children2 = new TreeSet<>();
        children2.add(mem5);
        children2.add(mem6);
        children2.add(mem7);
        mem2.setChildren(children2);

        Set<FamilyMember> children3 = new TreeSet<>();
        children3.add(mem8);
        children3.add(mem9);
        mem6.setChildren(children3);

        Set<FamilyMember> children4 = new TreeSet<>();
        children4.add(mem10);
        mem7.setChildren(children4);

        FamilyComparator comparator = new FamilyComparator();

        int sortType = Integer.parseInt(args[0]);

        if (sortType == 0) {
            Set<FamilyMember> members = new HashSet<>();
            mem1.createHashSet((HashSet) members);
            for (FamilyMember member : members) {
                System.out.println(member.toString());
            }
        }
        else if (sortType == 1) {
            Set<FamilyMember> members = new TreeSet<>();
            mem1.createTreeSet((TreeSet) members);
            for (FamilyMember member : members) {
                System.out.println(member.toString());
            }
        }
        else if (sortType == 2) {
            Set<FamilyMember> members = new TreeSet<>(comparator);
            mem1.createTreeSet((TreeSet) members);
            for (FamilyMember member : members) {
                System.out.println(member.toString());
            }
        }

        System.out.println("Wypisanie rekursywne:");
        mem1.recursiveToString(mem1, 1, sortType, comparator);

    }
}
