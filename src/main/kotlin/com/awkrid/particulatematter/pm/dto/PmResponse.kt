package com.awkrid.particulatematter.pm.dto

data class PmResponse(
    val stationName: String,
    val pm25Value: String,
    val pm10Value: String,
    val pm25Grade: String,
    val pm10Grade: String,
) {
    companion object {
        fun from(pmInfo: PmInfo): PmResponse {
            return PmResponse(
                stationName = pmInfo.stationName,
                pm25Value = pmInfo.pm25Value,
                pm10Value = pmInfo.pm10Value,
                pm25Grade = pmInfo.pm25Grade,
                pm10Grade = pmInfo.pm10Grade,
            )
        }
    }
}

