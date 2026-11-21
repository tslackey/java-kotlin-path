
package path.junior.tracker.j;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class TaskStore {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task add(String title) {
        throw new UnsupportedOperationException("Implement me");
    }

    public List<Task> list() {
        throw new UnsupportedOperationException("Implement me");
    }

    public boolean complete(int id) {
        throw new UnsupportedOperationException("Implement me");
    }

    public void save(Path file) throws IOException {
        throw new UnsupportedOperationException("Implement me");
    }

    public void load(Path file) throws IOException {
        throw new UnsupportedOperationException("Implement me");
    }
}
