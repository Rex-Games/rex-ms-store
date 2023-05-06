package com.rexgames.store.adapters.web;

import com.rexgames.store.library.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class GameController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/games")
    public Flux<Game> getGamesList(){
        var one = new Game(1L,"https://venturebeat.com/wp-content/uploads/2021/02/skywardsword.jpg?fit=400%2C200&strip=all","The Lengends of Zelda");
        var two = new Game(2L,"https://i0.wp.com/www.thexboxhub.com/wp-content/uploads/2014/11/Korraheader.png","The Lengends of Korra");
        var three = new Game(3L,"https://data.pixiz.com/output/user/frame/preview/400x400/3/9/4/0/3310493_901aa.jpg","Super Mario Bros");
        var list = new ArrayList<Game>();
        list.add(one);
        list.add(two);
        list.add(three);
        return Flux.fromIterable(list);
    }
}
