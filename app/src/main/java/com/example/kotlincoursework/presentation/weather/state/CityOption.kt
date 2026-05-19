package com.example.kotlincoursework.presentation.weather.state

data class CityOption(
    val russianName: String,
    val apiName: String
)

object CityCatalog {
    val cities = listOf(
        CityOption("Москва", "Moscow"),
        CityOption("Санкт-Петербург", "Saint Petersburg"),
        CityOption("Новосибирск", "Novosibirsk"),
        CityOption("Екатеринбург", "Yekaterinburg"),
        CityOption("Казань", "Kazan"),
        CityOption("Нижний Новгород", "Nizhny Novgorod"),
        CityOption("Самара", "Samara"),
        CityOption("Омск", "Omsk"),
        CityOption("Челябинск", "Chelyabinsk"),
        CityOption("Ростов-на-Дону", "Rostov-on-Don"),
        CityOption("Уфа", "Ufa"),
        CityOption("Красноярск", "Krasnoyarsk"),
        CityOption("Пермь", "Perm"),
        CityOption("Воронеж", "Voronezh"),
        CityOption("Волгоград", "Volgograd"),
        CityOption("Краснодар", "Krasnodar"),
        CityOption("Сочи", "Sochi"),
        CityOption("Калининград", "Kaliningrad"),
        CityOption("Владивосток", "Vladivostok")
    )
}
