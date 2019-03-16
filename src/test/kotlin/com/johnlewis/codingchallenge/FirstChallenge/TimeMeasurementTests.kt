package com.johnlewis.codingchallenge.FirstChallenge

import com.johnlewis.codingchallenge.FirstChallenge.Unit.*
import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.math.BigInteger

class TimeMeasurementTests {


    var expectedlistTimeValue = mutableListOf<TimeValue>()
    var actuallistTimeValue = listOf<TimeValue>()


    @Disabled
    @Test
    fun `Should be able to convert seconds into valid set of TimeValues`() {

        var objTimeValue1 = TimeValue()
        var objTimeValue2 = TimeValue()
        var objTimeValue3 = TimeValue()
        var objTimeMeasurement = TimeMeasurement()

        objTimeValue1.Amount = BigInteger.valueOf(12)
        objTimeValue1.Unit = Hours.PluralUnitName
        expectedlistTimeValue .add(objTimeValue1)

        objTimeValue2.Amount = BigInteger.valueOf(1)
        objTimeValue2.Unit = Minutes.SingularUnitName
        expectedlistTimeValue .add(objTimeValue2)

        actuallistTimeValue=objTimeMeasurement.populateArray(BigInteger.valueOf(43260))

        assertEquals(expectedlistTimeValue, actuallistTimeValue )

        objTimeValue3.Amount = BigInteger.valueOf(1)
        objTimeValue3.Unit = Seconds.SingularUnitName
        expectedlistTimeValue .add(objTimeValue3)

        actuallistTimeValue=objTimeMeasurement.populateArray(BigInteger.valueOf(43261))

        assertEquals(expectedlistTimeValue, actuallistTimeValue )

    }

}