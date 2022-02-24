package com.kdh.tmp.dto.review

import com.fasterxml.jackson.annotation.JsonInclude
import com.kdh.tmp.domain.review.MetaReviewItem

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MetaReviewItemListResponse(val items: List<MetaReviewItem>) {
}