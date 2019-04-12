package edu.petr.ptash.contactbook.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Modifying
    @Query("update Contact c set c.firstName = :firstName, c.lastName = :lastName, c.email = :email where c.id = :id")
    int updateContactById(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("email") String email,
            @Param("id") long id
    );

    @Query("select c from Contact c left join fetch c.phoneNumbers")
    List<Contact> findAllJoinNumbers();
}
