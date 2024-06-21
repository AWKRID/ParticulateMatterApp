# ParticulateMatterApp Project
---

## Introduction
---

This project provide simple API for checking PM values in seoul.
Implemented by redis and Spring Scheduler

## Features
---

- Retrieve PM informations from [공공데이터포털] every single hour by scheduler.
- Save PM values with hash supported by redis.
- Can get PM values using GET : /pm or /pm/{stationName} 

## Guide
---
Run program on local environment and two GET apis are provided.

> [GET] localhost:8080/pm

```
[
  {
    "stationName": "서대문구",
    "pm25Value": "17",
    "pm10Value": "48",
    "pm25Grade": "2",
    "pm10Grade": "2"
  },
  {
    "stationName": "마포구",
    "pm25Value": "22",
    "pm10Value": "42",
    "pm25Grade": "2",
    "pm10Grade": "2"
  },
  {
    "stationName": "은평구",
    "pm25Value": "20",
    "pm10Value": "43",
    "pm25Grade": "2",
    "pm10Grade": "2"
  },
  {
    "stationName": "도봉구",
    "pm25Value": "25",
    "pm10Value": "47",
    "pm25Grade": "2",
    "pm10Grade": "2"
  },
  {
    "stationName": "강서구",
    "pm25Value": "16",
    "pm10Value": "31",
    "pm25Grade": "2",
    "pm10Grade": "2"
  },
  // 생략 
  {
    "stationName": "구로구",
    "pm25Value": "16",
    "pm10Value": "29",
    "pm25Grade": "2",
    "pm10Grade": "2"
  },
  {
    "stationName": "영등포구",
    "pm25Value": "17",
    "pm10Value": "32",
    "pm25Grade": "2",
    "pm10Grade": "2"
  },
  {
    "stationName": "동작구",
    "pm25Value": "17",
    "pm10Value": "29",
    "pm25Grade": "2",
    "pm10Grade": "2"
  },
  {
    "stationName": "관악구",
    "pm25Value": "19",
    "pm10Value": "38",
    "pm25Grade": "2",
    "pm10Grade": "2"
  },
  {
    "stationName": "강동구",
    "pm25Value": "14",
    "pm10Value": "36",
    "pm25Grade": "2",
    "pm10Grade": "2"
  }
]
```

> [GET] localhost:8080/pm/마포구

```
{
  "stationName": "마포구",
  "pm25Value": "22",
  "pm10Value": "42",
  "pm25Grade": "2",
  "pm10Grade": "2"
}
```



