package com.johnlewis.codingchallenge


import com.johnlewis.codingchallenge.FirstChallenge.TimeMeasurement
import com.johnlewis.codingchallenge.FirstChallenge.TimeValue
import jdk.nashorn.internal.runtime.RewriteException.populateArray
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger

@SpringBootApplication
@RestController
class CodingChallengeController {

    @GetMapping("/{numberOfSeconds}")
    fun getDate(@PathVariable(value = "numberOfSeconds") numberOfSeconds: String): String {

        try {
            BigInteger(numberOfSeconds)
        } catch (Ex: Exception) {
            return "None"
        }

        var objMeasurement = TimeMeasurement()

        var finalTimeValueList: List<TimeValue> =
            objMeasurement.populateArray(BigInteger(numberOfSeconds))
        return objMeasurement.formatTimeUnitList(finalTimeValueList)
    }


}