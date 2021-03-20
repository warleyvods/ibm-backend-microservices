package com.ibm.hashtagtrack.service;

import com.ibm.hashtagtrack.models.HashtagEntity;
import com.ibm.hashtagtrack.repository.TwitterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashtagService {

    private final TwitterRepository twitterRepository;

    public HashtagService(TwitterRepository twitterRepository) {
        this.twitterRepository = twitterRepository;
    }

    public HashtagEntity saveHashtag(HashtagEntity hashtagEntity) {
        return twitterRepository.save(hashtagEntity);
    }

    public List<HashtagEntity> findAllHashtag() {
        return twitterRepository.findAll();
    }

}
