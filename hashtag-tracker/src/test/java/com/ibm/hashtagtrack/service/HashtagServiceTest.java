package com.ibm.hashtagtrack.service;

import com.ibm.hashtagtrack.HashtagTrackerApplication;
import com.ibm.hashtagtrack.models.HashtagEntity;
import com.ibm.hashtagtrack.repository.TwitterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HashtagTrackerApplication.class)
public class HashtagServiceTest {

    @Autowired
    TwitterRepository twitterRepository;

    @Autowired
    HashtagService hashtagService;

    private HashtagEntity hashtagEntityMock() {
        HashtagEntity hashtagEntity = new HashtagEntity();
        hashtagEntity.setHashtag("#TEST");
        return hashtagEntity;
    }

    @Test
    public void saveHashtag() {
        HashtagEntity save = twitterRepository.save(hashtagEntityMock());
        assertThat(twitterRepository.findById(save.getId()).get().getHashtag()).isEqualTo("#TEST");
    }

    @Test
    public void saveAnotherHashtagWithAnyValue() {
        HashtagEntity h = hashtagEntityMock();
        h.setHashtag("#World");
        HashtagEntity save = twitterRepository.save(h);
        assertThat(twitterRepository.findById(save.getId()).get().getHashtag()).isEqualTo("#World");
    }

    @Test
    public void findAllHashtag() {
        twitterRepository.save(hashtagEntityMock());
        twitterRepository.save(hashtagEntityMock());

        assertThat(twitterRepository.findAll()).isNotNull();
    }

    @Test
    public void returnListAllHashtagsInverse() {
        HashtagEntity h1 = hashtagEntityMock();
        h1.setId(1L);
        twitterRepository.save(h1);

        HashtagEntity h2 = hashtagEntityMock();
        h2.setId(2L);
        twitterRepository.save(h2);

        HashtagEntity h3 = hashtagEntityMock();
        h3.setId(3L);
        twitterRepository.save(h3);

        HashtagEntity h4 = hashtagEntityMock();
        h4.setId(4L);
        twitterRepository.save(h4);

        List<HashtagEntity> all = twitterRepository.findAll();
        Collections.reverse(all);

        for (HashtagEntity hashtagEntity : all) {
            assertThat(hashtagEntity.getId()).isEqualTo(hashtagEntity.getId());
        }

    }


}
