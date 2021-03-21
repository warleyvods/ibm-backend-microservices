package com.ibm.hashtagtrack.service;

import com.ibm.hashtagtrack.models.HashtagEntity;
import com.ibm.hashtagtrack.repository.TwitterRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Service for the Crud methods
 */
@Service
public class HashtagService {

    private final TwitterRepository twitterRepository;

    public HashtagService(TwitterRepository twitterRepository) {
        this.twitterRepository = twitterRepository;
    }

    /**
     * Save a hashtagEntity in a database
     *
     * @param hashtagEntity hashtag location populated
     */
    public void saveHashtag(HashtagEntity hashtagEntity) {
        twitterRepository.save(hashtagEntity);
    }

    /**
     * List all recent search from database
     * Note: in a reverse list.
     *
     * @return list all researches
     */
    public List<HashtagEntity> findAllHashtag() {
        List<HashtagEntity> all = twitterRepository.findAll();
        Collections.reverse(all);
        return all;
    }

}
