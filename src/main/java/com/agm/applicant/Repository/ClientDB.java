package com.agm.applicant.Repository;

import com.agm.applicant.Model.ClientModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDB extends JpaRepository<ClientModel, Long>{
}
