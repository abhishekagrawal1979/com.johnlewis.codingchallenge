package com.johnlewis.codingchallenge.FirstChallenge

import com.johnlewis.codingchallenge.FirstChallenge.Unit.*
import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.math.BigInteger
import java.util.Collections.list
import kotlin.test.assertNotEquals

class TimeMeasurementTests {

    var objTimeMeasurement = TimeMeasurement()
    var expectedlistTimeValue = mutableListOf<TimeValue>()

    @Test
    fun `Should be able to convert seconds into valid set of TimeValues`() {

        expectedlistTimeValue.add(0, TimeValue(BigInteger.valueOf(12), "Hours"))
        expectedlistTimeValue.add(1, TimeValue(BigInteger.valueOf(1), "Minute"))

        assertEquals(expectedlistTimeValue, objTimeMeasurement.populateArray(BigInteger.valueOf(43260)))

        expectedlistTimeValue.add(2, TimeValue(BigInteger.valueOf(1), "Second"))

        assertEquals(expectedlistTimeValue, objTimeMeasurement.populateArray(BigInteger.valueOf(43261)))
    }

    @Test
    fun `Should be able to convert a list of TimeValue objects into Time string`() {

        assertEquals(
            "12 Hours and 1 Minute",
            objTimeMeasurement.formatTimeUnitList(objTimeMeasurement.populateArray(BigInteger.valueOf(43260)))
        )
        assertEquals(
            "12 Hours, 1 Minute and 1 Second",
            objTimeMeasurement.formatTimeUnitList(objTimeMeasurement.populateArray(BigInteger.valueOf(43261)))
        )
        assertEquals(
            "None",
            objTimeMeasurement.formatTimeUnitList(objTimeMeasurement.populateArray(BigInteger.valueOf(0)))
        )
    }

    @Test
    fun `should not be equal to incorrect Time string`(){
        assertNotEquals(
            "12 Hours, 1 Minute and 1 Second",
            objTimeMeasurement.formatTimeUnitList(objTimeMeasurement.populateArray(BigInteger.valueOf(60)))
        )

    }
}