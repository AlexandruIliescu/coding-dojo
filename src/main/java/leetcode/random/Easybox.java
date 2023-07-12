package leetcode.random;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Easybox {

    public static void main(String[] args) {
        EasyboxContainer e1 = new EasyboxContainer(1, "S", false);
        EasyboxContainer e2 = new EasyboxContainer(2, "S", false);
        EasyboxContainer e3 = new EasyboxContainer(3, "S", true);
        EasyboxContainer e4 = new EasyboxContainer(4, "M", true);
        EasyboxContainer e5 = new EasyboxContainer(5, "L", true);

        List<EasyboxContainer> containers = new ArrayList<>();
        containers.add(e1);
        containers.add(e2);
        containers.add(e3);
        containers.add(e4);
        containers.add(e5);

        System.out.println(getEasyboxSize(containers, "S"));
    }

    private static int getEasyboxSize(List<EasyboxContainer> easyboxes, String packageSize) {
        Optional<EasyboxContainer> availableContainer = easyboxes.stream()
                .filter(container -> container.getSize().equals(packageSize))
                .filter(EasyboxContainer::isAvailable)
                .findFirst();

        return availableContainer.map(EasyboxContainer::getId).orElse(-1);
    }
}

@Data
@AllArgsConstructor
class EasyboxContainer {
    private int id;
    private String size;
    private boolean available;
}
