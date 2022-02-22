package com.kdh.tmp.dto.review

import com.fasterxml.jackson.annotation.JsonInclude
import com.kdh.tmp.domain.review.MetaReviewContent

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MetaReviewContentListResponse(val items: List<MetaReviewContent>) {
}