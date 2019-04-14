package edu.petr.ptash.contactbook.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

    @Modifying
    @Query("update PhoneNumber n set n.operatorName = :operatorName, n.number = :number where n.id = :numberId")
    int updatePhoneNumberById(
            @Param("numberId") Long numberId,
            @Param("operatorName") String operatorName,
            @Param("number") String number);
}
