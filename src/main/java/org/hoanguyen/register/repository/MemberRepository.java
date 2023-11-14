package org.hoanguyen.register.repository;

import org.hoanguyen.register.entity.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {
    public Optional<Member> findMemberByEmail(String email);

    @Query(value = "from Member where lastName like %:name%")
    public List<Member> findMembersByLastNameLike(@Param(value = "name") String name);
}
