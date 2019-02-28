package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {


    //    "get all the whiskies for a particular year"
    List<Whisky> findWhiskyByYear(int year);


    List<Whisky> findWhiskiesFromDistilleryThathaveAnAge(Long id, int age);

}

