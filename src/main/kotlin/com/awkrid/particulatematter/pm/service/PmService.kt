package com.awkrid.particulatematter.pm.service

import com.awkrid.particulatematter.pm.client.PmClient
import com.awkrid.particulatematter.pm.dto.PmResponse
import com.awkrid.particulatematter.pm.repository.PmRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class PmService(
    private val pmClient: PmClient,
    private val pmRepository: PmRepository
) {
    fun retrieveAllPmInfo(): List<PmResponse> {
        return pmRepository.findAllPmInfo().map { PmResponse.from(it) }
    }

    @Scheduled(cron = "0 0 0/1 * * *")
    fun savePmInfos() {
        println("[GET API Called] : time=${LocalDateTime.now()}")
        pmClient.retrievePmInfos()
            .let { pmRepository.save(it) }
    }

    fun retrievePmInfoByStationName(stationName: String): PmResponse {
        return pmRepository.findPmInfoByStationName(stationName)
            .let { PmResponse.from(it) }

    }
}