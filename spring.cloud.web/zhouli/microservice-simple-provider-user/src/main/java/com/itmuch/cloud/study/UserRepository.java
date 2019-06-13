package com.itmuch.cloud.study;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 734070824@qq.com
 * @date 2019/6/11 10:18
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
