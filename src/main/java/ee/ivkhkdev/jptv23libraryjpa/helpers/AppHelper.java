package ee.ivkhkdev.jptv23libraryjpa.helpers;

import java.util.List;
import java.util.Optional;

public interface AppHelper<T> {
    Optional<T> create();
    Optional<T> update(T t);
    boolean printList(List<T> ts);
}
