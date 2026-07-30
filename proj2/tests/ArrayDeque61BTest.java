import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

public class ArrayDeque61BTest {

    @Test
    public void addFirstTest(){
        Deque61B<Integer> lld = new ArrayDeque61B<Integer>();
        lld.addFirst(0);
        lld.addFirst(8);
        lld.addFirst(null);
        lld.addFirst(6);
        assertThat(lld.toList()).containsExactly(6, null, 8, 0).inOrder();

    }

    @Test
    public void addLastTest(){
        Deque61B<Integer> lld = new ArrayDeque61B<Integer>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(null);
        lld.addLast(6);
        assertThat(lld.toList()).containsExactly(1, 2, null, 6).inOrder();

    }

    @Test

    public void toListTest(){
        Deque61B<Integer> lld = new ArrayDeque61B<Integer>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addFirst(null);
        lld.addLast(6);
        assertThat(lld.toList()).containsExactly( null, 1, 2, 6).inOrder();
    }

    @Test

    public void sizeTest(){
        Deque61B<Integer> lld = new ArrayDeque61B<Integer>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addFirst(null);
        lld.addLast(6);
        assertThat(lld.size()).isEqualTo( 4);
    }

    @Test

    public void noEmptyTest(){
        Deque61B<Integer> lld = new ArrayDeque61B<Integer>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addFirst(null);
        lld.addLast(6);
        boolean result = lld.isEmpty();
        assertThat(result).isEqualTo( false);
    }

    @Test

    public void emptyTest(){
        Deque61B<Integer> lld = new ArrayDeque61B<Integer>();
        boolean result = lld.isEmpty();
        assertThat(result).isEqualTo( true);
    }

    @Test

    public void getFirstTest(){
        Deque61B<Integer> lld = new ArrayDeque61B<Integer>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addFirst(8);
        lld.addLast(6);
        assertThat(lld.getFirst()).isEqualTo( 8);
    }

    @Test

    public void getFirstNullTest(){
        Deque61B<Integer> lld = new ArrayDeque61B<Integer>();
        assertThat(lld.getFirst()).isEqualTo( null);
    }

    @Test

    public void getLastTest(){
        Deque61B<Integer> lld = new ArrayDeque61B<Integer>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addFirst(8);
        lld.addLast(6);
        assertThat(lld.getLast()).isEqualTo( 6);
    }

    @Test

    public void getLastNullTest(){
        Deque61B<Integer> lld = new ArrayDeque61B<Integer>();
        assertThat(lld.getLast()).isEqualTo( null);
    }

    @Test

    public void getTestnormal(){
        Deque61B<Integer> lld = new ArrayDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addFirst(8);
        lld.addLast(6);
        assertThat(lld.get(3)).isEqualTo(6);
    }

    @Test
    public void getTestOutOfBound(){
        Deque61B<Integer> lld = new ArrayDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addFirst(8);
        lld.addLast(6);
        assertThat(lld.get(5)).isEqualTo(null);
    }


    @Test

    public void getStringTest(){
        Deque61B<String> lld = new ArrayDeque61B<>();
        lld.addLast("out");
        lld.addLast("of");
        lld.addFirst("bound");
        lld.addLast("asusual");
        assertThat(lld.get(3)).isEqualTo("asusual");
    }

    @Test

    public void removeFirstTest(){
        Deque61B<String> lld = new ArrayDeque61B<>();
        lld.addLast("out");
        lld.addLast("of");
        lld.addFirst("bound");
        lld.addLast("asusual");
        lld.addFirst("666");
        lld.addFirst("777");
        lld.addFirst("888");
        lld.addFirst("999");
        assertThat(lld.removeFirst()).isEqualTo("999");
    }

    @Test

    public void removeLastTest(){
        Deque61B<String> lld = new ArrayDeque61B<>();
        lld.addLast("out");
        lld.addLast("of");
        lld.addFirst("bound");
        lld.addLast("asusual");
        assertThat(lld.removeLast()).isEqualTo("asusual");
    }

    @Test

    public void addFirstresizeTest(){
        Deque61B<String> lld = new ArrayDeque61B<String>();
        lld.addLast("out");
        lld.addLast("of");
        lld.addFirst("bound");
        lld.addLast("asusual");
        lld.addFirst("666");
        lld.addFirst("777");
        lld.addFirst("888");
        lld.addFirst("999");
        lld.addFirst("100");
        assertThat(lld.toList()).containsExactly("100", "999", "888", "777", "666", "bound", "out", "of", "asusual").inOrder();

    }

    @Test

    public void addLastresizeTest(){
        Deque61B<String> lld = new ArrayDeque61B<String>();
        lld.addLast("out");
        lld.addLast("of");
        lld.addFirst("bound");
        lld.addLast("asusual");
        lld.addFirst("666");
        lld.addFirst("777");
        lld.addFirst("888");
        lld.addFirst("999");
        lld.addLast("100");
        assertThat(lld.toList()).containsExactly( "999", "888", "777", "666", "bound", "out", "of", "asusual", "100").inOrder();

    }

    @Test

    public void removeresizeTest(){
        Deque61B<String> lld = new ArrayDeque61B<String>();
        lld.addLast("out");
        lld.addLast("of");
        lld.addFirst("bound");
        lld.addLast("asusual");
        lld.addFirst("666");
        lld.addFirst("777");
        lld.addFirst("888");
        lld.addFirst("999");
        lld.addLast("100");
        lld.addLast("out");
        lld.addLast("of");
        lld.addFirst("bound");
        lld.addLast("asusual");
        lld.addFirst("666");
        lld.addFirst("777");
        lld.addFirst("888");
        lld.addFirst("999");
        lld.addLast("100");
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        assertThat(lld.toList()).containsExactly( "999", "888").inOrder();

    }




}
