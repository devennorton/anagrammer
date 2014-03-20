package com.devenops.anagrammer;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertFalse;

/**
 * @author dnorton
 */
public class AnagrammerTest {

    String[][][] testlists = {{{"boku"}, {"nextdoor"}, {"sumo"}, {"glassdoor"}, {"salesforce"}, {"ifttt"}},
            {{"gobears", "agerobs"}, {"pys", "spy"}, {"history", "thisroy"}, {"eat", "ate"}}};

    /*
            I admit this test is quite naive and not very good at all. testing this turns out to be more work than I though when I started.
         */
    @Test
    public void testAnagramsAsListOfLists() throws Exception {
        for (String[][] lists : testlists) {
            List<String> alist = new ArrayList<String>();

            for (String[] list : lists) {
                alist.addAll(Arrays.asList(list));
            }
            List<List<String>> solution = Anagrammer.anagramsAsListOfLists(alist);

            for (String[] list : lists) {
                boolean fail = true;


                for (Iterator<List<String>> iter = solution.iterator(); iter.hasNext() && fail; ) {
                    List<String> check = iter.next();
                    if (check.containsAll(Arrays.asList(list))) {
                        fail = false;
                    }
                }

                assertFalse(fail, "anagrams not found: " + Arrays.toString(list));

            }

        }
    }
}
