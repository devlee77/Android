package com.example.covidtoday

data class Response(var header: Header,
                    var body: Body)

data class Header(var resultCode : String,
                  var resultMsg : String)

data class Body(var items : Items,
                var numOfRows: String,
                var pageNo : String,
                var totalCount : String)

data class Items(var item : List<Item>)

data class Item(var accDefRate : String,
                var accExamCnt : String,
                var accExamCompCnt : String,
                var careCnt : String,
                var clearCnt : String,
                var createDt : String,
                var deathCnt : String,
                var decideCnt : String,
                var examCnt : String,
                var resutlNegCnt : String,
                var seq : String,
                var stateDt : String,
                var stateTime : String,
                var updateDt : String)