package com.ipc.calculatemanagerservice.repository;

import com.ipc.calculatemanagerservice.model.UserInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInsuranceRepository extends JpaRepository<UserInsurance, Long> {
}
