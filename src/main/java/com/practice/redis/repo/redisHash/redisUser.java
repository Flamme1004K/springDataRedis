package com.practice.redis.repo.redisHash;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@RedisHash("users")
public class redisUser {

    @Id
    private long Id;
    @Column(nullable = false, unique = true, length = 50)
    private String uid;
    @Column(nullable = false, length = 100)
    private String address;

}
