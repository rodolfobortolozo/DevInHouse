package org.example;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
public class Pessoa {
    private final Long id;
    private final String nome;
}
