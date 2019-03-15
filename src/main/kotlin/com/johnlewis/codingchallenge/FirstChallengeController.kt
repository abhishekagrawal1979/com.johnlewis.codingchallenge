package com.johnlewis.codingchallenge


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.io.Console
import java.math.BigInteger


@RestController
class FirstChallengeController {

    var remainingSeconds: Int = 0


    @GetMapping("/{numberOfSeconds}")
    fun getDate(@PathVariable(value = "numberOfSeconds") numberOfSeconds: String): String {

        try {
            BigInteger(numberOfSeconds)
        } catch (Ex: Exception) {
            return "None"
        }


        var finalTimeUnitList: List<TimeUnit>
        finalTimeUnitList = populateArray(BigInteger(numberOfSeconds))
        return formatTimeUnitList(finalTimeUnitList)
    }

    fun populateArray(numberOfSeconds: BigInteger): List<TimeUnit> {

        var timeUnitList = mutableListOf<TimeUnit>()
        var remainingSeconds: BigInteger = numberOfSeconds


        enumValues<Unit>().forEach {
            if (remainingSeconds / it.ratio > BigInteger.ZERO) {
                var objTimeUnit = TimeUnit()
                objTimeUnit.Amount = ((remainingSeconds) / it.ratio)
                objTimeUnit.Unit = if (objTimeUnit.Amount > BigInteger.ONE) it.PluralUnitName else it.SingularUnitName
                remainingSeconds = (remainingSeconds % it.ratio)
                timeUnitList.add(objTimeUnit)
            }
        }
        return timeUnitList
    }

    private fun formatTimeUnitList(finalTimeUnitList: List<TimeUnit>): String {

        var outputString: String = ""

        if (finalTimeUnitList.isEmpty()) outputString = "None"
        else if (finalTimeUnitList.size == 1)
            return (finalTimeUnitList[0].Amount.toString() + " " + finalTimeUnitList[0].Unit.toString())
        else if (finalTimeUnitList.size == 2) {
            outputString = finalTimeUnitList[0].Amount.toString() + " " + finalTimeUnitList[0].Unit.toString()
            outputString =
                outputString + " and " + finalTimeUnitList[1].Amount.toString() + " " + finalTimeUnitList[1].Unit.toString()


        } else if (finalTimeUnitList.size > 2) {

            for (i in 0..(finalTimeUnitList.size - 3)) {
                outputString =
                    outputString + finalTimeUnitList[i].Amount.toString() + " " + finalTimeUnitList[i].Unit.toString() + ", "
            }
            outputString =
                outputString + finalTimeUnitList[finalTimeUnitList.size - 2].Amount.toString() + " " + finalTimeUnitList[finalTimeUnitList.size - 2].Unit.toString()
            outputString =
                outputString + " and " + finalTimeUnitList[finalTimeUnitList.size - 1].Amount.toString() + " " + finalTimeUnitList[finalTimeUnitList.size - 1].Unit.toString()
        }
        return outputString
    }

//    fun processSecondsIntoArray(numberOfSeconds: Int): List<TimeUnit> {
//
//        remainingSeconds = numberOfSeconds
//
//        var timeUnitList = mutableListOf<TimeUnit>()
//        var tempObj: TimeUnit
//
//        tempObj = countNumberOfYears(remainingSeconds)
//        if (tempObj.Unit != "") timeUnitList.add(tempObj)
//
//        tempObj = countNumberOfDays(remainingSeconds)
//        if (tempObj.Unit != "") timeUnitList.add(tempObj)
//
//        tempObj = countNumberOfHours(remainingSeconds)
//        if (tempObj.Unit != "") timeUnitList.add(tempObj)
//
//        tempObj = countNumberOfMins(remainingSeconds)
//        if (tempObj.Unit != "") timeUnitList.add(tempObj)
//
//        tempObj = countNumberOfSeconds(remainingSeconds)
//        if (tempObj.Unit != "") timeUnitList.add(tempObj)
//
//        return timeUnitList
//
//    }


//    fun countNumberOfYears(numberOfSeconds: Int): TimeUnit {
//        var objTimeUnit = TimeUnit()
//        if ((numberOfSeconds / 31536000) > 0) {
//            objTimeUnit.Amount = numberOfSeconds / 31536000
//            if (objTimeUnit.Amount == 1) objTimeUnit.Unit = "Year" else objTimeUnit.Unit = "Years"
//            remainingSeconds = (numberOfSeconds % 31536000)
//        } else
//            remainingSeconds = numberOfSeconds
//        return objTimeUnit
//    }
//
//    fun countNumberOfDays(numberOfSeconds: Int): TimeUnit {
//        var objTimeUnit = TimeUnit()
//        if ((numberOfSeconds / 86400) > 0) {
//            objTimeUnit.Amount = numberOfSeconds / 86400
//            if (objTimeUnit.Amount == 1) objTimeUnit.Unit = "Day" else objTimeUnit.Unit = "Days"
//            remainingSeconds = (numberOfSeconds % 86400)
//        } else
//            remainingSeconds = numberOfSeconds
//        return objTimeUnit
//    }
//
//    fun countNumberOfHours(numberOfSeconds: Int): TimeUnit {
//        var objTimeUnit = TimeUnit()
//        if ((numberOfSeconds / 3600) > 0) {
//            objTimeUnit.Amount = numberOfSeconds / 3600
//            if (objTimeUnit.Amount == 1) objTimeUnit.Unit = "Hour" else objTimeUnit.Unit = "Hours"
//            remainingSeconds = (numberOfSeconds % 3600)
//        } else
//            remainingSeconds = numberOfSeconds
//        return objTimeUnit
//    }
//
//    fun countNumberOfMins(numberOfSeconds: Int): TimeUnit {
//        var objTimeUnit = TimeUnit()
//        if ((numberOfSeconds / 60) > 0) {
//            objTimeUnit.Amount = numberOfSeconds / 60
//            if (objTimeUnit.Amount == 1) objTimeUnit.Unit = "Minute" else objTimeUnit.Unit = "Minutes"
//            remainingSeconds = (numberOfSeconds % 60)
//        } else
//            remainingSeconds = numberOfSeconds
//        return objTimeUnit
//    }
//
//    fun countNumberOfSeconds(numberOfSeconds: Int): TimeUnit {
//        var objTimeUnit = TimeUnit()
//        if (numberOfSeconds > 0) {
//            objTimeUnit.Amount = numberOfSeconds
//            if (objTimeUnit.Amount == 1) objTimeUnit.Unit = "Second" else objTimeUnit.Unit = "Seconds"
//        }
//        return objTimeUnit
//    }

    data class TimeUnit(

        var Amount: BigInteger = BigInteger.ZERO,
        var Unit: String = ""

    )

}