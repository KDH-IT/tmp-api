package com.kdh.tmp.service

import com.kdh.tmp.domain.review.*
import com.kdh.tmp.domain.user.UserRepository
import com.kdh.tmp.dto.review.ReviewRequest
import com.kdh.tmp.exception.ApiException
import com.kdh.tmp.exception.ErrorCode
import org.springframework.stereotype.Service

@Service
class CreateReviewService(
    val reviewRepository: ReviewRepository,
    val reviewItemRepository: ReviewItemRepository,
    val metaReviewRepository: MetaReviewItemRepository,
    val userRepository: UserRepository
) {

    fun createReview(request: ReviewRequest): Review {
        val reviewer = userRepository.findById(request.reviewerId).orElseThrow { ApiException(ErrorCode.BAD_REQUEST) }
        val reviewee = userRepository.findById(request.revieweeId).orElseThrow { ApiException(ErrorCode.BAD_REQUEST) }
        val review = reviewRepository.save(Review(reviewer, reviewee, request.comment))

        review.reviewItems = reviewItemRepository.saveAll(metaReviewRepository
            .findAllByMetaReviewItemIdIsIn(request.metaReviewItemList)
            .map { ReviewItem(review, it) })

        return reviewRepository.save(review)
    }
}