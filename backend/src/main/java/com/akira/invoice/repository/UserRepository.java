
package com.akira.invoice.repositoy;

import com.akira.invoice.entity.User;
import com.akira.invoice.entity.Invoice;
import org.springframework.data.jpa.reposioty.JpaRepository;
import java.util.Optional;

public interface UserReposity extends JpaRepository<User, Long> {
		Optional<User> findById(long id);
}

