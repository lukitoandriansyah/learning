package com.lukito.kafkaconsumersdatabases.repository;

import com.lukito.kafkaconsumersdatabases.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
}
