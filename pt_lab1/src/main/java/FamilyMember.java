import java.util.*;

public class FamilyMember implements Comparable<FamilyMember>{
    private String name;
    private int age;
    private double height;
    private Set<FamilyMember> children;

    public FamilyMember(String name, int age, double height, Set<FamilyMember> children) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Set<FamilyMember> getChildren() {
        return children;
    }

    public void setChildren(Set<FamilyMember> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember that = (FamilyMember) o;
        return age == that.age && Double.compare(that.height, height) == 0 && name.equals(that.name) && Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height, children);
    }

    @Override
    public int compareTo(FamilyMember o) {
        int ret = age - o.age;

        if (ret == 0) {
            ret = name.compareTo(o.name);
        }
        if (ret == 0) {
            double a = (height - o.height) * 100;
            ret = (int) a;
        }

        return ret;
    }

    public void createHashSet(HashSet members) {
        members.add(this);
        if (this.children != null) {
            for (FamilyMember child : children) {
                child.createHashSet(members);
            }
        }
    }

    public void createTreeSet(TreeSet members) {
        members.add(this);
        if (this.children != null) {
            for (FamilyMember child : children) {
                child.createTreeSet(members);
            }
        }
    }


    @Override
    public String toString() {
        return "FamilyMember{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    public void recursiveToString(FamilyMember member, int level, int sortType, FamilyComparator comparator) {
        for (int i=0; i<level; i++) {
            System.out.print("-");
        }
        System.out.println(member.toString());

        if (member.children != null) {
            List<FamilyMember> targetList = new ArrayList<>(children);

            if (sortType == 1) {
                Collections.sort(targetList);
            }
            else if (sortType == 2) {
                Collections.sort(targetList, comparator);
            }

            for (FamilyMember child : targetList) {
                child.recursiveToString(child, level+1, sortType, comparator);
            }
        }
    }
}
