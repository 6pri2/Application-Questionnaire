package com.example.applicationquestionnaire.ui.theme

data class Question(
    val question: String,
    val correct: String,
    val wrong: String
)

val questionList = listOf(
    Question("Combien font 2+2 ?", "4", "22"),
    Question("Quelle est la capitale de la France ?", "Paris", "Caen"),
    Question("PV = ", "nrt", "public virtuel"),
    Question("Qui est le record man du 100m ?", "Usain Bolt", "Nelson Monfort"),
    Question("Où ont eu lieu les JO en 2024 ?", "Paris", "Los Angeles")
)


