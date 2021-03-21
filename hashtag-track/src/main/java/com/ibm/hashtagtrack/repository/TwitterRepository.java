package com.ibm.hashtagtrack.repository;

import com.ibm.hashtagtrack.models.HashtagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Classic repository for the Hashtag class
 */
@Repository
public interface TwitterRepository extends JpaRepository<HashtagEntity, Long> {
}
