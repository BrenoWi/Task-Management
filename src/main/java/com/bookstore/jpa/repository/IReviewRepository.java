package com.bookstore.jpa.repository;

import com.bookstore.jpa.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IReviewRepository extends JpaRepository<Review, Long> {
}
