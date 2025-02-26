package pr2;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GraphTest {
    @Test
    public void onePathFindsAPath() {
        System.out.println("Ejecutando test: onePathFindsAPath");
        System.out.println("-------------------------------");

        Graph<Integer> graph = new Graph<>();
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(1, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(5);
        expected.add(6);
        expected.add(4);

        assertEquals(expected, graph.onePath(1, 4));
    }
}
