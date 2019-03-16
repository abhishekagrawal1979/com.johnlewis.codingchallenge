package com.johnlewis.codingchallenge.FirstChallenge
import java.math.BigInteger

class TimeMeasurement {


    public fun populateArray(numberOfSeconds: BigInteger): List<TimeValue> {

        var timeUnitList = mutableListOf<TimeValue>()
        var remainingSeconds: BigInteger = numberOfSeconds


        enumValues<Unit>().forEach {
            if (remainingSeconds / it.ratio > BigInteger.ZERO) {
                var objTimeUnit = TimeValue()
                objTimeUnit.Amount = ((remainingSeconds) / it.ratio)
                objTimeUnit.Unit = if (objTimeUnit.Amount > BigInteger.ONE) it.PluralUnitName else it.SingularUnitName
                remainingSeconds = (remainingSeconds % it.ratio)
                timeUnitList.add(objTimeUnit)
            }
        }
        return timeUnitList
    }

    public fun formatTimeUnitList(finalTimeValueList: List<TimeValue>): String {

        var outputString: String = ""

        if (finalTimeValueList.isEmpty()) outputString = "None"
        else if (finalTimeValueList.size == 1)
            return (finalTimeValueList[0].Amount.toString() + " " + finalTimeValueList[0].Unit.toString())
        else if (finalTimeValueList.size == 2) {
            outputString = finalTimeValueList[0].Amount.toString() + " " + finalTimeValueList[0].Unit.toString()
            outputString =
                outputString + " and " + finalTimeValueList[1].Amount.toString() + " " + finalTimeValueList[1].Unit.toString()


        } else if (finalTimeValueList.size > 2) {

            for (i in 0..(finalTimeValueList.size - 3)) {
                outputString =
                    outputString + finalTimeValueList[i].Amount.toString() + " " + finalTimeValueList[i].Unit.toString() + ", "
            }
            outputString =
                outputString + finalTimeValueList[finalTimeValueList.size - 2].Amount.toString() + " " + finalTimeValueList[finalTimeValueList.size - 2].Unit.toString()
            outputString =
                outputString + " and " + finalTimeValueList[finalTimeValueList.size - 1].Amount.toString() + " " + finalTimeValueList[finalTimeValueList.size - 1].Unit.toString()
        }
        return outputString
    }

    data class TimeValue(

        var Amount: BigInteger = BigInteger.ZERO,
        var Unit: String = ""

    )

}


