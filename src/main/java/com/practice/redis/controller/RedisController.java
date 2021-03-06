package com.practice.redis.controller;

import com.practice.redis.config.CacheKey;
import com.practice.redis.repo.User;
import com.practice.redis.repo.UserJpaRepo;
import com.practice.redis.repo.redisHash.RedisUser;
import com.practice.redis.repo.redisHash.RedisUserRepository;
import com.practice.redis.service.ConvertUser;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/redis")
@RestController
public class RedisController {

    private final UserJpaRepo userJpaRepo;
    private final RedisUserRepository redisUserRepository;
    private final ConvertUser convertUser;

    @Cacheable(value = CacheKey.USER, key = "#msrl", unless = "#result == null")
    @GetMapping("/user/{msrl}")
    public User findOne(@PathVariable long msrl) {
        return userJpaRepo.findById(msrl).orElse(null);
    }

    @Cacheable(value = CacheKey.USERLIST, unless = "#result == null")
    @GetMapping("/user")
    public List<User> findAll() {
        return userJpaRepo.findAll();
    }

    @PostMapping("/user")
    @ResponseBody
    public User postUser(@RequestBody User user) {
        return userJpaRepo.save(user);
    }

    @CachePut(value = CacheKey.USER, key = "#user.msrl")
    @PutMapping("/user")
    @ResponseBody
    public User putUser(@RequestBody User user) {
        return userJpaRepo.save(user);
    }

    @CacheEvict(value = CacheKey.USER, key = "#msrl")
    @DeleteMapping("/user/{msrl}")
    @ResponseBody
    public boolean deleteUser(@PathVariable long msrl) {
        userJpaRepo.deleteById(msrl);
        return true;
    }

    @GetMapping("/redisUser")
    @ResponseBody
    public void redisUser() {
        convertUser.toRedis();
    }

    @GetMapping("/redisUser/all")
    @ResponseBody
    public Iterable<RedisUser> redisAllUser() {
        return redisUserRepository.findAll();
    }
}