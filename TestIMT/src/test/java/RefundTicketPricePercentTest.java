import org.junit.Assert;
import org.junit.Test;

public class RefundTicketPricePercentTest {
    /** концерт был отменен => Boolean wasConcertCancelled = true
    * концерт НЕ был перенесен => Boolean wasConcertRescheduled = false
    * время до мероприятия не имеет значения */
    @Test
    public void testRefundTicketPricePercent_1 () {
        Integer actualResult = getRefundTicketPricePercent(0, true, false);
        Integer expectedResult = 100;
        Assert.assertEquals(expectedResult, actualResult);
    }
    /** мероприятие было отменено => Boolean wasConcertCancelled = true
     * мероприятие было перенесено => Boolean wasConcertRescheduled = true
     * время до мероприятия не имеет значения */
    @Test
    public void testRefundTicketPricePercent_2 () {
        Integer actualResult = getRefundTicketPricePercent(0, true, true);
        Integer expectedResult = 100;
        Assert.assertEquals(expectedResult, actualResult);
    }
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие было перенесено => Boolean wasConcertRescheduled = true
     * время до мероприятия не имеет значения */
    @Test
    public void testRefundTicketPricePercent_3 () {
        Integer actualResult = getRefundTicketPricePercent(0, false, true);
        Integer expectedResult = 100;
        Assert.assertEquals(expectedResult, actualResult);
    }
//====================================================================================================================//
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие НЕ было перенесено => Boolean wasConcertRescheduled = false
     * время до мероприятия: 10 и более дней (252 часа) */
    @Test
    public void testRefundTicketPricePercent_4 () {
        Integer actualResult = getRefundTicketPricePercent(252, false, false);
        Integer expectedResult = 100;
        Assert.assertEquals(expectedResult, actualResult);
    }
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие НЕ было перенесено => Boolean wasConcertRescheduled = false
     * время до мероприятия: 10 и более дней (240 часов) */
    @Test
    public void testRefundTicketPricePercent_5 () {
        Integer actualResult = getRefundTicketPricePercent(240, false, false);
        Integer expectedResult = 100;
        Assert.assertEquals(expectedResult, actualResult);
    }
//====================================================================================================================//
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие НЕ было перенесено => Boolean wasConcertRescheduled = false
     * время до мероприятия: от 6 до 10 дней (144 часа) */
    @Test
    public void testRefundTicketPricePercent_6 () {
        Integer actualResult = getRefundTicketPricePercent(144, false, false);
        Integer expectedResult = 50;
        Assert.assertEquals(expectedResult, actualResult);
    }
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие НЕ было перенесено => Boolean wasConcertRescheduled = false
     * время до мероприятия: от 6 до 10 дней (239 часов) */
    @Test
    public void testRefundTicketPricePercent_7 () {
        Integer actualResult = getRefundTicketPricePercent(239, false, false);
        Integer expectedResult = 50;
        Assert.assertEquals(expectedResult, actualResult);
    }
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие НЕ было перенесено => Boolean wasConcertRescheduled = false
     * время до мероприятия: от 6 (включительно) до 10 дней (211 часов) */
    @Test
    public void testRefundTicketPricePercent_8 () {
        Integer actualResult = getRefundTicketPricePercent(211, false, false);
        Integer expectedResult = 50;
        Assert.assertEquals(expectedResult, actualResult);
    }
//====================================================================================================================//
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие НЕ было перенесено => Boolean wasConcertRescheduled = false
     * время до мероприятия: от 3 до 5 (включительно) дней (73 часа) */
    @Test
    public void testRefundTicketPricePercent_9 () {
        Integer actualResult = getRefundTicketPricePercent(73, false, false);
        Integer expectedResult = 30;
        Assert.assertEquals(expectedResult, actualResult);
    }
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие НЕ было перенесено => Boolean wasConcertRescheduled = false
     * время до мероприятия: от 3 до 5 (включительно) дней (143 часа) */
    @Test
    public void testRefundTicketPricePercent_10 () {
        Integer actualResult = getRefundTicketPricePercent(143, false, false);
        Integer expectedResult = 30;
        Assert.assertEquals(expectedResult, actualResult);
    }
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие НЕ было перенесено => Boolean wasConcertRescheduled = false
     * время до мероприятия: от 3 до 5 (включительно) дней (100 часов) */
    @Test
    public void testRefundTicketPricePercent_11 () {
        Integer actualResult = getRefundTicketPricePercent(100, false, false);
        Integer expectedResult = 30;
        Assert.assertEquals(expectedResult, actualResult);
    }
//====================================================================================================================//
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие НЕ было перенесено => Boolean wasConcertRescheduled = false
     * время до мероприятия: 3 (включительно) и менее дней (72) */
    @Test
    public void testRefundTicketPricePercent_12 () {
        Integer actualResult = getRefundTicketPricePercent(72, false, false);
        Integer expectedResult = 0;
        Assert.assertEquals(expectedResult, actualResult);
    }
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие НЕ было перенесено => Boolean wasConcertRescheduled = false
     * время до мероприятия: 3 (включительно) и менее дней (7) */
    @Test
    public void testRefundTicketPricePercent_13 () {
        Integer actualResult = getRefundTicketPricePercent(7, false, false);
        Integer expectedResult = 0;
        Assert.assertEquals(expectedResult, actualResult);
    }
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие НЕ было перенесено => Boolean wasConcertRescheduled = false
     * время до мероприятия: 3 (включительно) и менее дней (0) */
    @Test
    public void testRefundTicketPricePercent_14 () {
        Integer actualResult = getRefundTicketPricePercent(0, false, false);
        Integer expectedResult = 0;
        Assert.assertEquals(expectedResult, actualResult);
    }
    /** мероприятие НЕ было отменено => Boolean wasConcertCancelled = false
     * мероприятие НЕ было перенесено => Boolean wasConcertRescheduled = false
     * время до мероприятия: 3 (включительно) и менее дней (-5) */
    @Test
    public void testRefundTicketPricePercent_15 () {
        Integer actualResult = getRefundTicketPricePercent(-5, false, false);
        Integer expectedResult = 0;
        Assert.assertEquals(expectedResult, actualResult);
    }
//====================================================================================================================//
    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled) {

        if(wasConcertCancelled && wasConcertRescheduled) return 100;

        if(hoursBeforeConcert>240) return 100;

        if(hoursBeforeConcert>=144 && hoursBeforeConcert<=240) return 50;

        if(hoursBeforeConcert>3 && hoursBeforeConcert<=144) return 30;

        return 0;

    }
}
