package org.mushare.login.dao;

import org.mushare.login.domain.Device;
import org.mushare.login.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDao extends JpaRepository<Device, Long> {

    Device getByUserAndIdentifier(User user, String identifier);

}
