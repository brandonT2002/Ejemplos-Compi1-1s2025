# Organización de Lenguajes y Compiladores 1

## Archivo de Entrada - Proyecto 1

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

## Archivo de Entrada - Proyecto 2

```
// === INSTRUCCIONES INICIALES ===
imprimir nl "=== INSTRUCCIONES INICIALES ==="
ingresar num1 como entero con valor 10
ingresar num2 como entero con valor 5

si num1 + num2 > 15 entonces
    imprimir "la suma es mayor a 15"
de lo contrario
    imprimir "la suma es menor o igual a 15"
fin si

if num1 * num2 < 30 && num1 > num2 entonces
    imprimir "El producto es menor que 30 y num1 es mayor que num2"
de lo contrario
    imprimir "Al menos una de las condiciones no se cumple"
fin si

ingresar nota como decimal
imprimir nota
nota -> 70.0

segun nota hacer
    en caso de ser nota > 85
        imprimir "Excelente"
        detener
    en caso de ser nota >= 61 && nota <= 85
        imprimir "Aprobado"
        detener
    de lo contrario entonces
        imprimir "No aprobado"
        detener
fin segun

// === INSTRUCCIONES INTERMEDIAS ===
imprimir nl "=== INSTRUCCIONES INTERMEDIAS ==="
procedimiento factorial con parametros (num entero)
    ingresar factorial como entero
    ingresar i como entero

    /*
    Este es un comentario
    de varias líneas
    ¡Si sale Compi!
    */

    factorial -> 1
    i -> 1

    mientras i <= num hacer
        factorial -> factorial * i
        inc(i)
    fin mientras

    imprimir "El factorial de " + num + " es igual a " + factorial // 5! = 120
fin procedimiento

funcion figura1 cadena con parametros (altura entero)
    ingresar i como entero
    ingresar j como entero
    ingresar linea como cadena con valor ""
    ingresar figura como cadena con valor ""

    para i -> 1 hasta altura + 1 con incremento i++ hacer
        linea -> ""
        para j -> 1 hasta i con incremento i++ hacer
            linea -> linea + "*"
        fin para
        figura -> figura + linea + "\n"
    fin para

    retornar figura
fin funcion

funcion figura2 cadena con parametros (n entero)
    ingresar i como decimal con valor -3 * n / 2
    ingresar j como decimal
    ingresar absolutoi como decimal
    ingresar absolutoj como decimal
    ingresar linea como cadena
    ingresar figura como cadena

    mientras i <= n hacer
        j = -3 * n / 2
        mientras j <= 3 hacer
            si i < 0 entonces
                absolutoi = -i
            de lo contrario
                absolutoi = i
            fin si

            si j < 0 entonces
                absolutoj = -j
            de lo contrario
                absolutoj = j
            fin si

            si (absolutoi + absolutoj < n) ||
                ((-n / 2 - i)^2 + (n / 2 - j)^2 <= (n*n) / 2) ||
                ((-n / 2 - i)^2 + (-n / 2 - j)^2 <= (n * n) / 2)
            entonces
                linea -> linea + "*"
            de lo contrario
                linea -> linea + "."
            fin si

            inc(j)
        fin mientras

        figura -> figura + linea + "\n"
        i++
    fin mientras

    retornar figura
fin funcion

ejecutar factorial(5) // 5! = 120
imprimir figura1(5) // Imprime triángulo
imprimir figura2(10) // Debe imprimir un corazón

// === INSTRUCCIONES AVANZADAS
imprimir nl "=== INSTRUCCIONES AVANZADAS ==="
ingresar lista (1, Entero) listaEnteros -> (1,2,3,4,5)
ingresar k como entero

para k -> 0 hasta longitud(listaEnteros) con incremento i++ hacer
    imprimir listaEnteros[i]
fin para

// Objeto
objeto vehiculo (
    tipo Cadena
    nombre Cadena
    velocidad Entero
)

// Método del objeto vehiculo
Carro -> metodo mostrarTipo
    imprimir "TIpo: " + tipo
fin metodo

// Crear instancia de objeto
ingresar objeto vehiculo vehiculo1 -> Carro(
    "Terrestre",
    "Carro",
    3000
)

ejecutar vehiculo1.mostrarTipo()
imprimir vehiculo1.nombre

// Recursividad sencilla
funcion multiplicacion entero con parametros (a entero, b entero)
    si b == 0 entonces
        retornar 0
    de lo contrario
        retornar a + multiplicacion(a, b - 1)
    fin si
fin funcion

imprimir "multiplicacion = " + multiplicacion(10, 5)

// Recursividad dificil
ingresar lista (1, Entero) arreglo -> (1,2,3,4,5)
ingresar objetivo como entero con valor 9
ingresar resultadoSuma como booleano

funcion suma_subconjunto booleano con parametros (arr lista, n entero, objetivo entero)
    si objetivo == 0 entonces
        retornar verdadero
    fin si

    si n == 0 entonces
        retornar falso
    fin si

    si arr[n-1] > objetivo entonces
        retornar suma_subconjunto(arr, n-1, objetivo)
    fin si

    retornar suma_subconjunto(arr, n-1, objetivo) || suma_subconjunto(arr, n-1, objetivo - arr[n-1])
fin funcion

resultado -> suma_subconjunto(arr, longitud(arr), objetivo)

si resultado entonces
    // Debe entrar aquí
    imprimir "Si es posible encontrar un subconjunto con la suma " + objetivo
de lo contrario
    imprimir "No es posible encontrar un subconjunto con la suma " + objetivo
fin si

imprimir "Si llegaste hasta aquí, ¡felicidades!🎊\nEstarás en Compi2\ten el \"2s2025\" 😎"

```