package org.mushare.login.dao;

import org.mushare.login.domain.OSSFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OSSFileDao extends JpaRepository<OSSFile, Long> {
}
