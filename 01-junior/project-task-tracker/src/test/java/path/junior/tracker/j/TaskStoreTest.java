
package path.junior.tracker.j;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TaskStoreTest {

    @TempDir
    Path tmp;

    @Test
    void addListComplete() {
        TaskStore store = new TaskStore();
        store.add("Buy milk");
        store.add("Write tests");
        assertThat(store.complete(1)).isTrue();
        assertThat(store.complete(99)).isFalse();
        assertThat(store.list()).extracting(Task::done).containsExactly(true, false);
        assertThatThrownBy(() -> store.add("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> store.add("a|b")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void persists() throws Exception {
        Path file = tmp.resolve("tasks.txt");
        TaskStore store = new TaskStore();
        store.add("One");
        store.add("Two");
        store.complete(1);
        store.save(file);

        TaskStore loaded = new TaskStore();
        loaded.load(file);
        assertThat(loaded.list()).containsExactly(new Task(1, "One", true), new Task(2, "Two", false));
        Task third = loaded.add("Three");
        assertThat(third.id()).isEqualTo(3);
    }

    @Test
    void mainFormatsList() {
        TaskStore store = new TaskStore();
        store.add("Ship it");
        assertThat(Main.run(store, new String[] {"list"})).isZero();
        assertThat(Main.format(store.list().get(0))).isEqualTo("1 [ ] Ship it");
    }
}
