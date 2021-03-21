package com.ibm.hashtagtrack.models;

import com.ibm.hashtagtrack.util.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HashtagEntity extends AbstractEntity {

    private String hashtag;

}
