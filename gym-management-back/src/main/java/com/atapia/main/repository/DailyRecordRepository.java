package com.atapia.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atapia.main.entity.TDailyRecord;

public interface DailyRecordRepository extends JpaRepository<TDailyRecord, String>{

}
