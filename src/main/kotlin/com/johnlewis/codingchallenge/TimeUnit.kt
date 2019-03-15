package com.johnlewis.codingchallenge

import java.math.BigInteger

enum class Unit (internal val SingularUnitName : String,internal val PluralUnitName : String, internal val ratio : BigInteger){

    Year("Year","Years", BigInteger.valueOf(31536000)),
    Days("Day","Days", BigInteger.valueOf(86400)),
    Hours("Hour","Hours", BigInteger.valueOf(3600)),
    Minutes("Minute","Minutes", BigInteger.valueOf(60)),
    Seconds("Second","Seconds", BigInteger.valueOf(1));
}