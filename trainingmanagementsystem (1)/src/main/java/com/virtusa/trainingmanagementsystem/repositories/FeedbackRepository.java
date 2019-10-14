package com.virtusa.trainingmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.trainingmanagementsystem.models.Feedback;


public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {

}
