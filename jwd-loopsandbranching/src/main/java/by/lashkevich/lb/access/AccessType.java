package by.lashkevich.lb.access;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for task with access checking
 * @author Roman Lashkevich
 */
public enum AccessType {
    A("A", Arrays.asList(9583, 1747)),
    B("B", Arrays.asList(9583, 1747, 3331, 7922)),
    C("C", Arrays.asList(9583, 1747, 3331, 7922, 9455, 8997));

    private static final String ACCESS_ERROR_MESSAGE = "Access error";
    private String name;
    private List<Integer> passwords;

    AccessType(String name, List<Integer> passwords) {
        this.name = name;
        this.passwords = passwords;
    }

    public void setPasswords(List<Integer> passwords) {
        this.passwords = passwords;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getPasswords() {
        return passwords;
    }

    public static List<String> checkAccess(int password) {
        List<String> accesses = Arrays.stream(AccessType.values())
                .filter(currentAccessType -> currentAccessType.getPasswords().contains(password))
                .map(AccessType::getName)
                .collect(Collectors.toList());

        if (accesses.size() == 0) {
            accesses.add(ACCESS_ERROR_MESSAGE);
        }

        return accesses;
    }
}

