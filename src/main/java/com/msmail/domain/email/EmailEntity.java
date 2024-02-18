package com.msmail.domain.email;

import com.msmail.domain.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "emails")
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String ownerRef;
    private String emailTo;
    private String emailFrom;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime sendDate;
    private StatusEmail status;
}
