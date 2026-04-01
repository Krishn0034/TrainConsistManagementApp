import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        list.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));

        Map<String, List<TrainConsistManagementApp.Bogie>> result = TrainConsistManagementApp.groupBogiesByType(list);

        assertEquals(1, result.size());
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        list.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        Map<String, List<TrainConsistManagementApp.Bogie>> result = TrainConsistManagementApp.groupBogiesByType(list);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertEquals(2, result.size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        Map<String, List<TrainConsistManagementApp.Bogie>> result = TrainConsistManagementApp.groupBogiesByType(list);

        assertTrue(result.isEmpty(), "Result should be an empty map for an empty input list.");
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        int originalSize = list.size();

        TrainConsistManagementApp.groupBogiesByType(list);

        assertEquals(originalSize, list.size(), "The original list should not be modified by the grouping operation.");
    }
}