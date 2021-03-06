package gumi.builders;

import gumi.builders.url.UrlParameterMultimap;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Ideally, these tests should provide 100% coverage for UrlParameterMultimap.
 */
public class MultimapTest {

    private static Map.Entry<String, String> newEntry(final String key, final String value) {
        return new AbstractMap.SimpleImmutableEntry<String, String>(key, value);
    }

    @Test
    public void createMultimap() {
        final UrlParameterMultimap m1 = UrlParameterMultimap.newMultimap();
    }

    @Test
    public void createImmutable() {
        final UrlParameterMultimap.Immutable m1 = UrlParameterMultimap.newMultimap().immutable();
    }


    @Test
    public void addEntries() {
        final UrlParameterMultimap m1 = UrlParameterMultimap.newMultimap();
        m1.add("a", "1").add("b", "2").add("c", "3");
        assertEquals(m1.flatEntrySet().get(0), newEntry("a", "1"));
        assertEquals(m1.flatEntrySet().get(1), newEntry("b", "2"));
        assertEquals(m1.flatEntrySet().get(2), newEntry("c", "3"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void mutateImmutableParameterMap() {
        final UrlParameterMultimap m1 = UrlParameterMultimap.newMultimap();
        m1.add("a", "1").add("b", "2").add("c", "3");
        final UrlParameterMultimap.Immutable i1 = m1.immutable();
        i1.add("d", "4");
    }
}
