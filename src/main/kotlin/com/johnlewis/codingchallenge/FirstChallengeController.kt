package com.johnlewis.codingchallenge


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
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

    data class TimeUnit(

        var Amount: BigInteger = BigInteger.ZERO,
        var Unit: String = ""

    )

}