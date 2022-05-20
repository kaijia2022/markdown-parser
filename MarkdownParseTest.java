import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    //@Test
    public void addition(){
        assertEquals(5,3+2);
    }

    //@Test
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

    //@Test
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


    @Test
    public void test_md1() throws IOException{
        String[] args = new String[1];
        args[0] = "report-test-1.md";
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);

        String[] expected = new String[4];
        expected[0] = "url.com";
        expected[1] = "`google.com";
        expected[2] = "google.com";
        expected[3] = "ucsd.edu";

        String[] actual = new String[links.size()];
        for (int i = 0; i < actual.length; i++){
            actual[i] = links.get(i);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_md2() throws IOException{
        String[] args = new String[1];
        args[0] = "report-test-2.md";
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);

        String[] expected = new String[4];
        expected[0] = "a.com";
        expected[1] = "b.com";
        expected[2] = "a.com(())";
        expected[3] = "example.com";

        String[] actual = new String[links.size()];
        for (int i = 0; i < actual.length; i++){
            actual[i] = links.get(i);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_md3() throws IOException{
        String[] args = new String[1];
        args[0] = "report-test-3.md";
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);

        String[] expected = new String[4];
        expected[0] = "https://www.twitter.com";
        expected[1] = "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/scheduleb.com";
        expected[2] = "github.com";
        expected[3] = "https://cse.ucsd.edu/";

        String[] actual = new String[links.size()];
        for (int i = 0; i < actual.length; i++){
            actual[i] = links.get(i);
        }
        assertArrayEquals(expected, actual);
    }
}
