package com.kdh.tmp.exception

enum class ErrorCode(val statusCode: Int, val errorMessage: String) {
    CONTENT_NOT_FOUND(200, "데이터가 존재하지 않습니다."),
    INTERNAL_ERROR(500, "서버 에러입니다.")
}