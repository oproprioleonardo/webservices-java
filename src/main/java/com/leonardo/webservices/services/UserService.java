package com.leonardo.webservices.services;

import com.leonardo.webservices.entities.User;
import com.leonardo.webservices.repositories.UserRepository;
import com.leonardo.webservices.services.exceptions.DatabaseException;
import com.leonardo.webservices.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return this.repository.findAll();
    }

    public User findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return this.repository.save(user);
    }

    public void delete(Long id) {
        try {
            this.repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj) {
        try {
            User user = this.repository.getReferenceById(id);
            updateData(user, obj);
            return this.repository.save(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setEmail(obj.getEmail());
        entity.setName(obj.getName());
        entity.setPhone(obj.getPhone());
    }


}
