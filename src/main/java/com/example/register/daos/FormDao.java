package com.example.register.daos;

import com.example.register.models.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormDao extends JpaRepository<Form, Long> {
}

