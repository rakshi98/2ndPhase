package com.virtusa.trainingmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.virtusa.trainingmanagementsystem.models.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer>,CrudRepository<Schedule,Integer>{

	
	  @Modifying
	  @Query(value="UPDATE Schedule_Table s SET s.venue = :venue WHERE s.schedule_Id = :scheduleId",nativeQuery=true) 
	  int updateVenue(@Param("scheduleId") int scheduleId, @Param("venue") String venue);
	 

}
