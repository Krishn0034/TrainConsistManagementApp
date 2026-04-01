import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));

        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterBogies(list, 70);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));

        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterBogies(list, 70);

        assertTrue(result.isEmpty(), "Bogies with capacity equal to threshold should be excluded.");
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("First Class", 24));

        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterBogies(list, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        int originalSize = list.size();

        TrainConsistManagementApp.filterBogies(list, 70);

        assertEquals(originalSize, list.size(), "The original list must remain unchanged after stream processing.");
    }
}