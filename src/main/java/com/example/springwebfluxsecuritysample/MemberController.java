package com.example.springwebfluxsecuritysample;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("members")
@Slf4j
public class MemberController {

    MemberRepository memberRepository;
    @NonFinal int idx;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String save() {

        memberRepository.save(new Member("test" + idx, List.of("USER")));
        idx++;
        return "test" + idx;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<Member> getLoginUser(Mono<Authentication> auth) {
        return auth.map(Principal::getName).doOnNext(n -> log.info("{}", n)).flatMap(memberRepository::get);
    }
}
