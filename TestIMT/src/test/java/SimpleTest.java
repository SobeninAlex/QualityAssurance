import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {

    // for IMT > 0 and IMT <= 16, example IMT = 10 => "выраженному дефициту массы тела"
    @Test
    public void testDeficitWeight() {
        var actualResult = getIMTResult(200f, 40f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    // for IMT > 0 and IMT <= 16, example IMT = 16 => "выраженному дефициту массы тела"
    @Test
    public void testDeficitWeight_1() {
        var actualResult = getIMTResult(200f, 64f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    // for IMT > 16 and IMT < 19, example IMT = 17 => "недостаточной массе тела"
    @Test
    public void testNotEnoughWeight() {
        var actualResult = getIMTResult(200f, 68f);
        Assert.assertEquals("недостаточной массе тела", actualResult);
    }

    // for IMT >= 19 and IMT < 25, example IMT = 19 => "нормальной массе тела"
    @Test
    public void testNormalWeight() {
        var actualResult = getIMTResult(200f, 76f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    // for IMT >= 19 and IMT < 25, example IMT = 20 => "нормальной массе тела"
    @Test
    public void testNormalWeight_1() {
        var actualResult = getIMTResult(200f, 80f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    // for IMT >= 25, example IMT = 25 => "избыточной массе тела"
    @Test
    public void testExcessWeight() {
        var actualResult = getIMTResult(200f, 100f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }
    // for IMT >= 25, example IMT = 26 => "избыточной массе тела"
    @Test
    public void testExcessWeight_1() {
        var actualResult = getIMTResult(200f, 104f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }
    // for IMT >= 25, example IMT = 50 => "избыточной массе тела"
    @Test
    public void testExcessWeight_2() {
        var actualResult = getIMTResult(200f, 200f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

//==============================================================================================//


    // for height <= 0 or height > 350 => "указан некорректный рост"
    @Test
    public void testZeroHeight() {
        var actualResult = getIMTResult(0f, 75f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }
    @Test
    public void testNegativeHeight() {
        var actualResult = getIMTResult(-5f, 75f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }
    @Test
    public void testBigHeight() {
        var actualResult = getIMTResult(355f, 75f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    // for weight <= 0 or weight > 1000 => "указан некорректный вес"
    @Test
    public void testZeroWeight() {
        var actualResult = getIMTResult(180f, 0f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }
    @Test
    public void testNegativeWeight() {
        var actualResult = getIMTResult(180f, -50f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }
    @Test
    public void testBigWeight() {
        var actualResult = getIMTResult(180f, 1050f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }


    private String getIMTResult(Float heightCm, Float weightKg) {

        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));

        String userResult = null;

        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";

        } else if (userIndex > 16 && userIndex < 19)  {
            userResult = "недостаточной массе тела";

        } else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";

        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }

        if (heightCm.equals(0.0f)) {
            userResult+="указан некорректный рост";
        }

        return userResult;
    }
}
