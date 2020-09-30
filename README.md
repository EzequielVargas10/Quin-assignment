# Quin-assignment

## Description

This project contains the api test for Quin assignment

## Structure

```
src
├── main
│      ├──java
│      │     ├──requests
│      │     │          └── CreateBinRequest
│      │     └──responses
│      │                ├── CreateBinResponse
│      │                └── ErrorRequestResponse
│      └──resources
└── test
       ├──java
       │     └──quin
       │           ├── accesscontrol
       │           │               └── AccessControlTest
       │           ├── binsTests
       │           │           ├── CreateBinTest
       │           │           ├── DeleteBinTest
       │           │           ├── ReadBinTest
       │           │           └── UpdateBinTest
       │           ├── client
       │           │        ├── CreateBinRestClient
       │           │        ├── DeleteBinsRestClient
       │           │        ├── ReadBinsRestClient
       │           │        └── UpdateBinsRestClient
       │           ├── data
       │           │      └── BinDate
       │           ├── service
       │           │         ├── CreateBinsService
       │           │         ├── DeleteBinsService
       │           │         ├── ReadBinsService
       │           │         └── UpdateBinsService
       │           ├── utils
       │           │       └── BinsUtils
       │           └── RestClient
       └── Resources
                   ├── Data
                   │      ├── apiKey.json
                   │      ├── exampleBin.json
                   │      └── exampleUpdateBin.json
                   └── testSuites
                                └── binsApisTestSuite.xml
```

### How to Build
```mvn clean install```
