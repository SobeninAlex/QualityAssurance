import org.junit.Assert;
import org.junit.Test;

public class TestMarkResult {

    @Test
    public void AllTests() {
        testMark(-5, "no mark result");

        testMark(0, "2");
        testMark(25, "2");
        testMark(35, "2");

        testMark(36, "3");
        testMark(45, "3");
        testMark(56, "3");

        testMark(57, "4");
        testMark(65, "4");
        testMark(71, "4");

        testMark(72, "5");
        testMark(87, "5");
        testMark(100, "5");

        testMark(150, "no mark result");
    }

    private void testMark(Integer mark, String expectedMarkResult) {
        var actualResult = getMarkResult(mark);
        Assert.assertEquals(expectedMarkResult, actualResult);
    }

    // mark < 0, return no mark result
    @Test
    public void testMarkResult() {
        var mark = getMarkResult(-5);
        Assert.assertEquals("no mark result", mark);
    }

    // mark >= 0 and mark <= 35, return 2
    @Test
    public void testMarkResult_MarkIs_0() {
        var mark = getMarkResult(0);
        Assert.assertEquals("2", mark);
    }
    @Test
    public void testMarkResult_MarkIs_35() {
        var mark = getMarkResult(35);
        Assert.assertEquals("2", mark);
    }
    @Test
    public void testMarkResult_MarkIs_20() {
        var mark = getMarkResult(20);
        Assert.assertEquals("2", mark);
    }

    // mark >= 36 and mark <= 56, return 3
    @Test
    public void testMarkResult_MarkIs_36() {
        var mark = getMarkResult(36);
        Assert.assertEquals("3", mark);
    }
    @Test
    public void testMarkResult_MarkIs_56() {
        var mark = getMarkResult(56);
        Assert.assertEquals("3", mark);
    }
    @Test
    public void testMarkResult_MarkIs_45() {
        var mark = getMarkResult(45);
        Assert.assertEquals("3", mark);
    }

    // mark >= 57 and mark <= 71, return 4
    @Test
    public void testMarkResult_MarkIs_57() {
        var mark = getMarkResult(57);
        Assert.assertEquals("4", mark);
    }
    @Test
    public void testMarkResult_MarkIs_71() {
        var mark = getMarkResult(71);
        Assert.assertEquals("4", mark);
    }
    @Test
    public void testMarkResult_MarkIs_62() {
        var mark = getMarkResult(62);
        Assert.assertEquals("4", mark);
    }

    // mark >= 72 and mark <= 100, return 5
    @Test
    public void testMarkResult_MarkIs_72() {
        var mark = getMarkResult(72);
        Assert.assertEquals("5", mark);
    }
    @Test
    public void testMarkResult_MarkIs_100() {
        var mark = getMarkResult(100);
        Assert.assertEquals("5", mark);
    }
    @Test
    public void testMarkResult_MarkIs_89() {
        var mark = getMarkResult(89);
        Assert.assertEquals("5", mark);
    }

    // mark > 100, return no mark result
    @Test
    public void testMarkResult_MarkIs_150() {
        var mark = getMarkResult(150);
        Assert.assertEquals("no mark result", mark);
    }
    @Test
    public void testMarkResult_MarkIs_125000() {
        var mark = getMarkResult(125000);
        Assert.assertEquals("no mark result", mark);
    }

    private String getMarkResult(Integer mark) {

        if(mark>=0 && mark <=35) return "2";
        if(mark>35 && mark <=56) return "3";
        if(mark>56 && mark<71) return "4";
        if(mark>72 && mark<100) return "5";
        return "no mark result";
    }
}
