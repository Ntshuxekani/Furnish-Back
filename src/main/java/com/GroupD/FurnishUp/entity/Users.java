package com.GroupD.FurnishUp.entity;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import java.util.Collection;
import java.util.List;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CUSTOMER")
@SQLDelete(sql = "UPDATE tbl_users SET deleted = true WHERE id=?")
@Where(clause="deleted=false")
@Table(name = "tbl_users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;

    public boolean isDeleted() {
        return deleted;
    }


    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    private boolean deleted = Boolean.FALSE; //FALSE =not deleted, TRUE = deleted

}


