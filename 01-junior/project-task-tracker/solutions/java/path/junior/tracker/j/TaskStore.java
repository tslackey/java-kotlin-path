
package path.junior.tracker.j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class TaskStore {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task add(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title");
        }
        if (title.contains("|")) {
            throw new IllegalArgumentException("title cannot contain |");
        }
        Task task = new Task(nextId++, title.trim(), false);
        tasks.add(task);
        return task;
    }

    public List<Task> list() {
        return List.copyOf(tasks);
    }

    public boolean complete(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.id() == id) {
                tasks.set(i, task.complete());
                return true;
            }
        }
        return false;
    }

    public void save(Path file) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Task task : tasks) {
            lines.add(task.id() + "|" + (task.done() ? "1" : "0") + "|" + task.title());
        }
        Files.write(file, lines, StandardCharsets.UTF_8);
    }

    public void load(Path file) throws IOException {
        tasks.clear();
        nextId = 1;
        if (!Files.exists(file)) {
            return;
        }
        for (String line : Files.readAllLines(file, StandardCharsets.UTF_8)) {
            if (line.isBlank()) {
                continue;
            }
            String[] parts = line.split("\\|", 3);
            Task task = new Task(Integer.parseInt(parts[0]), parts[2], "1".equals(parts[1]));
            tasks.add(task);
            nextId = Math.max(nextId, task.id() + 1);
        }
    }
}
