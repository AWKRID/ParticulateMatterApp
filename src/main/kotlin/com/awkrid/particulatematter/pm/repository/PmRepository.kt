package com.awkrid.particulatematter.pm.repository

import com.awkrid.particulatematter.pm.dto.PmInfo
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class PmRepository(
    private val redisTemplate: RedisTemplate<String, String>,
    private val stationNameList: List<String> = listOf(
        "서대문구",
        "마포구",
        "은평구",
        "도봉구",
        "강서구",
        "구로구",
        "영등포구",
        "동작구",
        "관악구",
        "서초구",
        "강남구",
        "송파구",
        "강북구",
        "강동구"
    )
) {
    fun save(pmInfos: List<PmInfo>) {
        val hashOperations = redisTemplate.opsForHash<String, String>()
        pmInfos.forEach {
            val key = it.stationName
            if (key in stationNameList) {
                hashOperations.put(key, "pm10Value", it.pm10Value)
                hashOperations.put(key, "pm25Value", it.pm25Value)
                hashOperations.put(key, "pm10Grade", it.pm10Grade)
                hashOperations.put(key, "pm25Grade", it.pm25Grade)
            }
        }
    }

    fun findAllPmInfo(): List<PmInfo> {
        val hashOperations = redisTemplate.opsForHash<String, String>()
        val pmInfoList = mutableListOf<PmInfo>()
        for (stationName in stationNameList) {
            PmInfo(
                stationName = stationName,
                pm10Value = hashOperations.get(stationName, "pm10Value") ?: "정보없음",
                pm25Value = hashOperations.get(stationName, "pm25Value") ?: "정보없음",
                pm10Grade = hashOperations.get(stationName, "pm10Grade") ?: "정보없음",
                pm25Grade = hashOperations.get(stationName, "pm25Grade") ?: "정보없음",
            ).let {
                pmInfoList.add(it)
            }
        }
        return pmInfoList
    }

    fun findPmInfoByStationName(stationName: String): PmInfo {
        val hashOperations = redisTemplate.opsForHash<String, String>()
        if (!stationNameList.contains(stationName)) throw RuntimeException("$stationName not supported")
        return PmInfo(
            stationName = stationName,
            pm10Value = hashOperations.get(stationName, "pm10Value") ?: "정보없음",
            pm25Value = hashOperations.get(stationName, "pm25Value") ?: "정보없음",
            pm10Grade = hashOperations.get(stationName, "pm10Grade") ?: "정보없음",
            pm25Grade = hashOperations.get(stationName, "pm25Grade") ?: "정보없음",

            )
    }
}