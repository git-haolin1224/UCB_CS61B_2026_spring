import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

public class ArrayDeque61BEhancementTest {
    @Test
    public void IteratorTest(){
        Deque61B<Integer> lld = new ArrayDeque61B<Integer>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addFirst(null);
        lld.addLast(6);
        assertThat(lld).containsExactly( null,1,2,6);
    }

    @Test
    public void testEqualDeques61B() {
        Deque61B<String> ad = new ArrayDeque61B<>();
        Deque61B<String> ad2 = new ArrayDeque61B<>();

        ad.addLast("front");
        ad.addLast("middle");
        ad.addLast("back");

        ad2.addLast("front");
        ad2.addLast("middle");
        ad2.addLast("back");

        assertThat(ad).isEqualTo(ad2);
    }

    @Test

    public void testStringToDeques61B() {
        Deque61B<String> ad = new ArrayDeque61B<>();

        ad.addLast("front");
        ad.addLast("middle");
        ad.addLast("back");

        assertThat(ad.toString()).isEqualTo("[front, middle, back]");
    }

    @Test
    public void testZeroStringToDeques61B() {
        Deque61B<String> ad = new ArrayDeque61B<>();

        assertThat(ad.toString()).isEqualTo("[]");
    }
}


