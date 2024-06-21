package com.awkrid.particulatematter.pm.controller

import com.awkrid.particulatematter.pm.dto.PmResponse
import com.awkrid.particulatematter.pm.service.PmService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/pm")
class PmController(
    private val pmService: PmService
) {

    @GetMapping
    fun getAllPmInfo(): ResponseEntity<List<PmResponse>> {
        return ResponseEntity.ok(pmService.retrieveAllPmInfo())
    }

    @GetMapping("/{stationName}")
    fun getPmInfo(@PathVariable stationName: String): ResponseEntity<PmResponse> {
        return ResponseEntity.ok(pmService.retrievePmInfoByStationName(stationName))
    }

}