package com.menes.be.demo.registration.token;

import com.menes.be.demo.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConfirmationToken {

        @SequenceGenerator(
                name = "confirmation_token_sequence",
                sequenceName = "confirmation_token_sequence",
                allocationSize = 1
        )
        @Id
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "confirmation_token_sequence"
        )
        private Long id;

        @Column(nullable = false)
        private String token;

        @Column(nullable = false)
        private LocalDateTime createdAt;

        @Column(nullable = false)
        private LocalDateTime expiredAt;

        private LocalDateTime confirmedAt;

        @ManyToOne
        @JoinColumn(
                nullable = false,
                name = "user_id"
        )
        private User user;

        public ConfirmationToken(String token,
                                 LocalDateTime createdAt,
                                 LocalDateTime expiredAt,
                                 User user) {
            this.token = token;
            this.createdAt = createdAt;
            this.expiredAt = expiredAt;
            this.user = user;
    }

}
