package com.example.banking_service_test_task.repository;

import com.example.banking_service_test_task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    @Modifying
    @Query(value = """
            UPDATE users 
            SET account_id = :accountId
            WHERE id = :userId
                        """, nativeQuery = true)
    void assignAccount(Long userId, Long accountId);

    @Query(value = """
            SELECT amount FROM accounts a 
            JOIN users u ON a.id = u.account_id
            WHERE u.id = :userId
                                    """, nativeQuery = true)
    double getBalanceByUserId(Long userId);

    @Modifying
    @Query(value = """
            UPDATE accounts 
            SET amount = :amount
            WHERE id = (
            SELECT account_id FROM users
            WHERE users.id = :userId
            )
                        """, nativeQuery = true)
    void updateBalanceByUserId(Long userId, double amount);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByPhoneNumber(String phoneNumber);

}
