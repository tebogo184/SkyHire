package com.SkyHire.project.Repository;

import com.SkyHire.project.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
