package com.hwan.shopping.domain;

import com.hwan.shopping.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@NoArgsConstructor
@Getter
@Entity
public class Account{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String email;
   private String password;
   private String name;
   private Role role;

   @Builder
   public Account(Long id, String email, String password, String name, Role role) {
      this.id = id;
      this.email = email;
      this.password = password;
      this.name = name;
      this.role = role;
   }
}
