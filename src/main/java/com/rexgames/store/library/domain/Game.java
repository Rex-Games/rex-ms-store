package com.rexgames.store.library.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Game {
    private Long id;
    private String image;
    private String name;

    public Game(Long i, String url, String gamename) {
        id = i;
        image = url;
        name = gamename;
    }
}
