package org.hanghae.hanghaetask1reviewservice.common.user.repository;

import org.hanghae.hanghaetask1reviewservice.common.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
