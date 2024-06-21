package com.awkrid.particulatematter.pm.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PmApiResponse(
    @JsonProperty("response") val response: ApiResponse
)

data class ApiResponse(
    @JsonProperty("body") val body: ApiBody
)

data class ApiBody(
    @JsonProperty("totalCount") val totalCount: Int,
    @JsonProperty("items") val pmInfos: List<PmInfo>
)

data class PmInfo(
    @JsonProperty("pm10Value") val pm10Value: String,
    @JsonProperty("pm25Value") val pm25Value: String,
    @JsonProperty("pm10Grade") val pm10Grade: String,
    @JsonProperty("pm25Grade") val pm25Grade: String,
    @JsonProperty("stationName") val stationName: String,
)