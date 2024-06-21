package com.awkrid.particulatematter.pm.client

import com.awkrid.particulatematter.pm.dto.PmApiResponse
import com.awkrid.particulatematter.pm.dto.PmInfo
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@Component
class PmClient(
    @Value("\${pm.apiUrl}") private val apiUrl: String,
    @Value("\${pm.secretKey}") private val secretKey: String,
    private val restClient: RestClient
) {
    fun retrievePmInfos(): List<PmInfo> {
        val apiResponse = restClient.get()
            .uri(generateApiUrl())
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body<PmApiResponse>()
            ?: throw RuntimeException("Could not retrieve PM info")
        return apiResponse.response.body.pmInfos
    }

    private fun generateApiUrl(): String {
        return StringBuilder(apiUrl)
            .append("?serviceKey=").append(secretKey)
            .append("&returnType=").append("json")
            .append("&numOfRows=").append("40")
            .append("&pageNo=").append("1")
            .append("&sidoName=").append("서울")
            .append("&ver=").append("1.0")
            .toString()
    }

}