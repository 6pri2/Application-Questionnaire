# 📋 Application Questionnaire - Kotlin Android App

Bienvenue dans ce projet Android, une application simple pour poser des questions à l'utilisateur et afficher son score ! 🎮🎯

## 📑 Sommaire
- [🎯 Fonctionnalités](#fonctionnalités)
- [🔧 Technologies](#technologies)
- [🚀 Installation](#installation)
- [📱 Aperçu](#aperçu)
- [🧑‍💻 Comment ça marche ?](#comment-ça-marche)
- [🧑‍💻 Structure du projet](#structure-du-projet)
- [🔄 Rejouer](#rejouer)
- [📜 Questions & Réponses](#questions--réponses)
- [🚧 À faire](#à-faire)
- [📃 Licence](#licence)
- [👨‍💻 Auteur](#auteur)


## 🎯 Fonctionnalités
- 📖 Pose des questions à l'utilisateur avec deux propositions de réponses.
- ✔️ Réponse avec un choix entre deux options.
- 🏆 Calcul et affichage du score final.
- 🔁 Possibilité de recommencer le quiz.

## 🔧 Technologies
- **Kotlin** : Le langage principal utilisé pour développer l'application.
- **Jetpack Compose** : Pour la construction de l'interface utilisateur de manière déclarative.
- **Android SDK** : L'environnement de développement pour Android.

## 🚀 Installation

1. **Clonez ce dépôt** :
    ```bash
    git clone https://github.com/ton-username/application-questionnaire.git
    ```

2. **Ouvrez le projet dans Android Studio** :
    - Lancez **Android Studio**.
    - Ouvrez le projet cloné.
    - Assurez-vous que votre appareil (émulateur ou physique) est prêt.

3. **Exécutez l'application** :
    - Cliquez sur le bouton **Run** dans Android Studio pour lancer l'application sur un appareil ou un émulateur Android.

## 📱 Aperçu

L'application pose des questions avec deux options de réponses, l'utilisateur choisit une réponse, et à la fin, son score est affiché ! Voici comment ça fonctionne :

1. L'application affiche une question avec deux options de réponses.
2. L'utilisateur sélectionne une réponse.
3. Le score est mis à jour en fonction de la bonne réponse.
4. Une fois toutes les questions passées, le score final est affiché avec la possibilité de recommencer le quiz.

## 🧑‍💻 Comment ça marche ?

L'application est construite avec **Jetpack Compose** pour une interface fluide et moderne. Voici comment la logique fonctionne :

- **MainActivity.kt** gère la logique principale du quiz, l'affichage des questions, le suivi du score, et le passage à la question suivante. Lorsqu'une réponse est sélectionnée, elle est comparée à la réponse correcte, et le score est mis à jour.
- **Question.kt** est une classe de données qui contient chaque question avec ses deux propositions de réponses (correcte et incorrecte). Les propositions sont mélangées avant d'être affichées pour ajouter un peu de variété.

Les questions sont stockées dans une liste et récupérées dans l'application pour chaque question. À la fin de chaque série de questions, le score final est affiché et l'utilisateur peut recommencer.

## 🧑‍💻 Structure du projet

Le projet est structuré comme suit :

- **MainActivity.kt** : Le fichier principal où se trouve la logique de l'application. Il gère l'affichage des questions, le suivi du score, et le passage à la question suivante.
- **Question.kt** : Une **data class** qui stocke chaque question, la réponse correcte et la réponse incorrecte.
  
  Exemple de la **data class Question** :
  ```kotlin
  data class Question(
      val question: String,
      val correct: String,
      val wrong: String
  )```

- **GamePage.kt** : Le composant d'interface utilisateur qui affiche la question actuelle et ses deux propositions de réponses. L'utilisateur choisit une réponse, et si elle est correcte, le score est mis à jour. Ensuite, l'application passe à la question suivante.

- **ScorePage.kt** : Le composant d'interface utilisateur qui affiche le score final après toutes les questions. L'utilisateur peut ensuite appuyer sur le bouton **Rejouer** pour réinitialiser le score et recommencer le quiz.

## 🔄 Rejouer

À la fin du quiz, lorsque toutes les questions ont été répondues, l'utilisateur voit son score final. Un bouton **Rejouer** lui permet de réinitialiser le quiz en réinitialisant le score à zéro et en revenant à la première question.

Cela permet de tester à nouveau ses connaissances et de voir si le score s'améliore après plusieurs tentatives.

## 📜 Questions & Réponses

Les questions sont stockées sous forme de liste d'objets `Question` dans le code. Chaque question a deux réponses possibles : une correcte et une incorrecte. Les réponses sont mélangées avant d'être affichées.

### Exemple de structure d'une question :

```kotlin
data class Question(
    val question: String,
    val correct: String,
    val wrong: String
)
```
## 🚧 À faire
- 🎮 Ajouter plus de questions pour rendre le quiz plus diversifié.
- 📊 Ajouter des catégories de questions (par exemple, culture générale, technologie, etc.).
- ❌ Ajouter une fonctionnalité pour afficher les mauvaises réponses à la fin du quiz afin de permettre à l'utilisateur d'apprendre de ses erreurs.
- 🧩 Ajouter une minuterie pour rendre le quiz plus dynamique et compétitif.
- 📱 Améliorer l'interface utilisateur avec des animations et des transitions plus fluides.

## 📃 Licence
Ce projet est sous la licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus de détails.

## 👨‍💻 Auteur
Projet développé par **Cyprien Duroy** dans le cadre du cours de Développement d'application mobiles du **BUT Informatique - 2025**. 🚀

