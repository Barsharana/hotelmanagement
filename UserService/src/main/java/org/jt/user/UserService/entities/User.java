package org.jt.user.UserService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="micro_users")
public class User {

        @Id
        @Column(name="ID")
        private String userId;
        @Column(name="NAME")
        private String name;
        @Column(name = "EMAIL")
        private String email;
        @Column(name="ABOUT")
        private String about;
        @Transient
        private List<Rating> ratings;
    }

