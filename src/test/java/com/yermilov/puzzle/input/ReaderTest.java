package com.yermilov.puzzle.input;

import com.yermilov.puzzle.domain.Direction;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class ReaderTest {

    @Test
    public void getDirection_ReturnsRightDirections_ForDifferentCases(){
        final String[] TO_RETURN = {"a","A","d","w","s"};
        final Direction[] ANSWERS = {Direction.LEFT,Direction.LEFT,Direction.RIGHT,Direction.UP,Direction.DOWN};
        ConsoleReader consoleReader = spy(ConsoleReader.class);
        for(int i=0;i<TO_RETURN.length;i++){
            doReturn(TO_RETURN[i]).when(consoleReader).readDirection();
            assertEquals(ANSWERS[i],consoleReader.getDirection());
        }
    }
}
