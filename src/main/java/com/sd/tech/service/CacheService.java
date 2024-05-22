package com.sd.tech.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
/*
@Service
public class CacheService {

    @Cacheable(value = "users", key = "#userId")
    public User getUserById(Long userId) {
        // Method implementation to fetch user by ID
        return userRepository.findById(userId).orElse(null);
    }

    @CachePut(value = "users", key = "#user.id")
    public User updateUser(User user) {
        // Method implementation to update user
        return userRepository.save(user);
    }

    @CacheEvict(value = "users", key = "#userId")
    public void deleteUser(Long userId) {
        // Method implementation to delete user
        userRepository.deleteById(userId);
    }
    */


