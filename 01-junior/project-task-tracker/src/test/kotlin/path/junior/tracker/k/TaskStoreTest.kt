
package path.junior.tracker.k

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path

class TaskStoreTest {

    @TempDir
    lateinit var tmp: Path

    @Test
    fun addListComplete() {
        val store = TaskStore()
        store.add("Buy milk")
        store.add("Write tests")
        assertThat(store.complete(1)).isTrue()
        assertThat(store.complete(99)).isFalse()
        assertThat(store.list().map { it.done }).containsExactly(true, false)
        assertThatThrownBy { store.add("") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { store.add("a|b") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun persists() {
        val file = tmp.resolve("tasks.txt")
        val store = TaskStore()
        store.add("One")
        store.add("Two")
        store.complete(1)
        store.save(file)

        val loaded = TaskStore()
        loaded.load(file)
        assertThat(loaded.list()).containsExactly(Task(1, "One", true), Task(2, "Two", false))
        assertThat(loaded.add("Three").id).isEqualTo(3)
    }

    @Test
    fun mainFormatsList() {
        val store = TaskStore()
        store.add("Ship it")
        assertThat(run(store, arrayOf("list"))).isZero()
        assertThat(format(store.list()[0])).isEqualTo("1 [ ] Ship it")
    }
}
