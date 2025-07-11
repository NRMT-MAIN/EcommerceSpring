package com.example.ecommerceSpring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false , updatable = false)
    private Instant createdAt;

    @CreatedDate
    @Column(nullable = false)
    private Instant updatedAt;

    @PrePersist
    protected void onCreate(){
        Instant now = Instant.now() ;
        this.createdAt = now ;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate(){
        Instant now = Instant.now() ;
        this.updatedAt = now ;
    }
}
