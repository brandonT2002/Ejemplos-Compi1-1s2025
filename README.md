# Organización de Lenguajes y Compiladores 1

Archivo de Entrada - Proyecto 1

```
strategy Graaskamp {
    initial: D
    rules: [
        if round_number <= 2 then D,
        if round_number == 3 && get_moves_count(opponent_history, D) == 2 then C,
        if round_number > 3 && get_last_n_moves(opponent_history, 2) == [D, D] then D,
        else last_move(opponent_history)
    ]
}

strategy Random {
    initial: C
    rules: [
        if random < 0.5 then C,
        else D
    ]
}

match GraaskampvsRandom {
    players strategies: [Graaskamp, Random]
    rounds: 100
    scoring: {
        mutual cooperation: 3, 
        mutual defection: 1, 
        betrayal reward: 5, 
        betrayal punishment: 0 
    }
}

main {
    run [GraaskampvsRandom] with {
        seed: 42
    }
}
```