package com.ppcodes.elasticjob;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.jupiter.api.Test;

public class PlayGroundTest {

    @Test
    void playingLorem() {
        Lorem lorem = LoremIpsum.getInstance();
        String words = lorem.getWords(10, 200);

        System.out.println(words);

    }




}
