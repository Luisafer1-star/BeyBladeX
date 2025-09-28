package com.example.beyapp

import androidx.annotation.DrawableRes


// CLASES DE DATOS

data class Bey(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val imageId: Int
)

data class Piece(
    val name: String,
    val description: String,
    @DrawableRes val imageId: Int
)

data class Launch(
    val name: String,
    val description: String,
    @DrawableRes val imageId: Int
)

data class BeyExample(
    val beyTypeId: Int,
    val name: String,
    @DrawableRes val imageId: Int
)

data class PieceExample(
    val pieceId: Int,
    val name: String,
    @DrawableRes val imageId: Int
)


// LISTAS DE DATOS DE EJEMPLO


// LISTA DE TIPOS DE BEYBLADE
val sampleBeys = listOf(
    Bey(
        id = 1,
        name = "Ataque",
        description = "Los bleys tipo ataque están diseñados para golpear fuerte y rápido. Algunas características de este bley son: Velocidad alta: reducción de fricción y movimiento más rápido. Baja resistencia o stamina. Potencia de golpes muy agresivo. Debilidad: son vulnerables a beyblades tipo resistencia.",
        imageId = R.drawable.logo_ataque
    ),
    Bey(
        id = 2,
        name = "Defensa",
        description = "Los bleys tipo defensa están diseñados para aguantar ataques potentes. Algunas de estas características de este bley son: Mucho peso para resistir empujes. Movimiento limitado. Diseño ancho y redondo para repeler golpes. Debilidad: Tipo resistencia.",
        imageId = R.drawable.logo_defensa
    ),
    Bey(
        id = 3,
        name = "Resistencia",
        description = "Los bleys tipo resistencia están diseñados principalmente para ganar por tiempo, es decir vencerlos cuando el rival se queda sin giro antes que ellos. Sus características: Su diseños es liso para no perder energía. Suelen usar punta redonda o en aguja para reducir la fricción. Debilidad: Muy vulnerables a los tipo ataque.",
        imageId = R.drawable.logo_resistencia
    ),
    Bey(
        id = 4,
        name = "Equilibrio",
        description = "Estos bleys tipo equilibrio están diseñados para combinar lo mejor de los 3 tipos, para así adaptarse a los diferentes tipos de beys. Algunas características de este bley son: Mezcla los 3 tipos de beys. Son útiles cuando no sabes que elegirá el rival. Y tiene una movilidad moderna (más control de ataque y defensa). Debilidad: su rendimiento dependerá mucho del control del estadio y del lanzador.",
        imageId = R.drawable.logo_equilibrio
    )
)

// LISTA DE TIPOS DE LANZAMIENTO
val sampleLaunches = listOf(
    Launch(
        name = "Lanzamiento Neutral",
        description = "Se refiere a la técnica donde el lanzador y el Beyblade se mantienen paralelos a la superficie del estadio durante el lanzamiento. Este tipo de lanzamiento es efectivo para jugadores que buscan estabilidad y control, especialmente aquellos con estrategias de resistencia y defensa. El lanzador y el Beyblade se mantienen paralelos a la superficie del estadio. Es efectivo para los tipos de resistencia y defensa, ayudando a mantener la estabilidad y control.",
        imageId = R.drawable.lanzamiento_neutral // Asegúrate que el archivo se llame lanzamiento_neutral.png
    ),
    Launch(
        name = "Lanzamiento Inclinado",
        description = "El lanzamiento inclinado en Beyblade, también conocido como \"lanzamiento a lo bestia\", es una técnica donde el Beyblade se lanza desde un ángulo pronunciado, a menudo hacia el borde del estadio. El lanzador se inclina hacia un lado, afectando la trayectoria y velocidad del Beyblade.",
        imageId = R.drawable.lanzamiento_inclinado // Asegúrate que el archivo se llame lanzamiento_inclinado.png
    ),
    Launch(
        name = "Lanzamiento X-Dash",
        description = "Es una técnica avanzada donde el Beyblade es lanzado con fuerza y un ángulo específico para que alcance la zona extrema del estadio, donde puede realizar ataques potentes o desplazar al oponente. Es un truco que permite a los Beyblades alcanzar una velocidad y potencia de impacto increíbles gracias a una superaceleración.",
        imageId = R.drawable.x_dash // Asegúrate que el archivo se llame x_dash.png
    )
)

// LISTA DE TIPOS DE PIEZAS (CON imageId)
val samplePieces = listOf(

    Piece(
        name = "Blade",
        description = "Es la hoja y pieza superior, rodeada de metal, y el principal punto de contacto entre bleys en una batalla. Dependiendo de su forma, y peso, estará más enfocada al ataque, defensa o resistencia.",
        imageId = R.drawable.blade
    ),

    Piece(
        name = "Ratchet",
        description = "Es la pieza central hecha de plástico y es la pieza que une la hoja y la punta, se identifica fácilmente por las protuberancias en los laterales que tiene y la altura de la pieza, sirve para distribuir el peso de los bleys.",
        imageId = R.drawable.ratchet
    ),

    Piece(
        name = "Bit",
        description = "El bit o la punta es el principal punto de contacto entre bleys. Dependiendo de su forma y peso, estará más enfocado al ataque, defensa o resistencia.",
        imageId = R.drawable.bit
    )
)

// LISTA DE EJEMPLOS DE BEYBLADES
val sampleExamples = listOf(

    BeyExample(1, "Variante Ataque 1", R.drawable.ejemplo_ataque_1),
    BeyExample(1, "Variante Ataque 2", R.drawable.ejemplo_ataque_2),
    BeyExample(1, "Variante Ataque 3", R.drawable.ejemplo_ataque_3),
    BeyExample(1, "Variante Ataque 4", R.drawable.ejemplo_ataque_4),


    BeyExample(2, "Variante Defensa 1", R.drawable.ejemplo_defensa_1),
    BeyExample(2, "Variante Defensa 2", R.drawable.ejemplo_defensa_2),
    BeyExample(2, "Variante Defensa 3", R.drawable.ejemplo_defensa_3),
    BeyExample(2, "Variante Defensa 4", R.drawable.ejemplo_defensa_4),


    BeyExample(3, "Variante Resistencia 1", R.drawable.ejemplo_resistencia_1),
    BeyExample(3, "Variante Resistencia 2", R.drawable.ejemplo_resistencia_2),
    BeyExample(3, "Variante Resistencia 3", R.drawable.ejemplo_resistencia_3),
    BeyExample(3, "Variante Resistencia 4", R.drawable.ejemplo_resistencia_4),


    BeyExample(4, "Variante Equilibrio 1", R.drawable.equilibrio_1),
    BeyExample(4, "Variante Equilibrio 2", R.drawable.equilibrio_2),
    BeyExample(4, "Variante Equilibrio 3", R.drawable.equilibrio_3),
    BeyExample(4, "Variante Equilibrio 4", R.drawable.equilibrio_4)

)

// LISTA DE EJEMPLOS DE PIEZAS
val samplePieceExamples = listOf(

    PieceExample(1, "Blade Ejemplo 1", R.drawable.blade_1),
    PieceExample(1, "Blade Ejemplo 2", R.drawable.blade_2),
    PieceExample(1, "Blade Ejemplo 3", R.drawable.blade_3),



    PieceExample(2, "Ratchet Ejemplo 1", R.drawable.ratchet_1),
    PieceExample(2, "Ratchet Ejemplo 2", R.drawable.ratchet_2),
    PieceExample(2, "Ratchet Ejemplo 3", R.drawable.ratchet_3),



    PieceExample(3, "Bit Ejemplo 1", R.drawable.bit_1),
    PieceExample(3, "Bit Ejemplo 2", R.drawable.bit_2),
    PieceExample(3, "Bit Ejemplo 3", R.drawable.bit_3),
)
