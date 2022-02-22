package com.kdh.tmp.exception

class ApiException(val errorCode: ErrorCode) : RuntimeException() {

    fun getResponseBody(): Map<String, String> {
        return HashMap<String, String>().apply {
            put("statusCode", errorCode.statusCode.toString())
            put("errorMessage", errorCode.errorMessage)
        }
    }
}