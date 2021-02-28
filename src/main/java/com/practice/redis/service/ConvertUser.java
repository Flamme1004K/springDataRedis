package com.practice.redis.service;

import com.practice.redis.repo.UserJpaRepo;
import com.practice.redis.repo.redisHash.RedisUser;
import com.practice.redis.repo.redisHash.RedisUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConvertUser {

    private final RedisUserRepository redisUserRepository;
    private final UserJpaRepo userJpaRepo;

    @Transactional
    public void toRedis() {
        redisUserRepository.saveAll(convertUserInfo());
    }

    private List<RedisUser> convertUserInfo() {
        return userJpaRepo.findAll().stream().map(user ->
                RedisUser.builder().id(user.getMsrl()).uid(user.getUid()).build()
        ).collect(Collectors.toList());
    }
}
