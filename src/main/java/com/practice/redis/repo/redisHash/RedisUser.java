package com.practice.redis.repo.redisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@Getter
@RedisHash("users")
@NoArgsConstructor
public class RedisUser {

    @Id
    private long Id;
    private String uid;
    private String address;

    @Builder
    public RedisUser(long id, String uid) {
        Id = id;
        this.uid = uid;
        this.address = uid.toUpperCase();
    }
}
