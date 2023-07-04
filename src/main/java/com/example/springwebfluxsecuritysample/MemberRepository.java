package com.example.springwebfluxsecuritysample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class MemberRepository {
    private final Map<String ,Member> members = new HashMap<>();

    public void save(Member member) {
        members.put(member.getId(), member);
    }

    public Mono<Member> get(String id) {
        log.info("{}", id);
        return Mono.just(members.get(id));
    }
}
