import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition(){
        assertEquals(5,3+2);
    }

    @Test
    public void test_getLink() throws IOException{
        String[] args = new String[1];
        args[0] = "test-file8.md";
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	   
        String[] expected = new String[1];
        expected[0] = "a link on the first line";
        //expected[1] = "some-thing.html";

        String[] actual = new String[links.size()];
        for (int i = 0; i < actual.length; i++){
            actual[i] = links.get(i);
        }
        assertArrayEquals(expected, actual);
        
    }

    @Test
    public void failingTest() throws IOException{
        String[] args = new String[1];
        args[0] = "test5-file.md";
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	   
        String[] expected = new String[1];
        expected[0] = "hello.com";
        //expected[1] = "some-thing.html";

        String[] actual = new String[links.size()];
        for (int i = 0; i < actual.length; i++){
            actual[i] = links.get(i);
        }
        assertArrayEquals(expected, actual);
    }
}
