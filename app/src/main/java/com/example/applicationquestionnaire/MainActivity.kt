package com.example.applicationquestionnaire


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.applicationquestionnaire.ui.theme.ApplicationQuestionnaireTheme
import com.example.applicationquestionnaire.ui.theme.questionList
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    private var currentQuestionIndex by mutableIntStateOf(0)
    private var score by mutableIntStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ApplicationQuestionnaireTheme {
                if (currentQuestionIndex < questionList.size) {
                    GamePage(
                        questionIndex = currentQuestionIndex,
                        score = score,
                        onAnswerSelected = { isCorrect ->
                            if (isCorrect) score++
                        },
                        onNextQuestion = {
                            if (currentQuestionIndex < questionList.size - 1) {
                                currentQuestionIndex++
                            } else {
                                currentQuestionIndex = questionList.size
                            }
                        }
                    )
                } else {
                    ScorePage(score = score, totalQuestions = questionList.size) {
                        score = 0
                        currentQuestionIndex = 0
                    }
                }
            }
        }
    }
}


@Composable
fun GamePage(
    questionIndex: Int,
    score: Int,
    onAnswerSelected: (Boolean) -> Unit,
    onNextQuestion: () -> Unit
) {
    val question = questionList[questionIndex]
    val answers = listOf(question.correct, question.wrong).shuffled()
    val randomAnswers = randomizeAnswers(answers)

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Question ${questionIndex + 1}", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))

            HorizontalDivider()

            Text(
                text = question.question,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(2f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                randomAnswers.forEach { answer ->
                    Button(
                        onClick = {
                            onAnswerSelected(answer == question.correct)
                            onNextQuestion()
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = answer)
                    }
                }
            }
            HorizontalDivider()
            Text(
                text="",
                modifier = Modifier.weight(1f)
            )

        }
    }
}

fun randomizeAnswers(answers: List<String>): List<String> {
    val random = Random
    val mutableAnswers = answers.toMutableList()
    val randomizedAnswers = mutableListOf<String>()

    while (mutableAnswers.isNotEmpty()) {
        val randomIndex = random.nextInt(mutableAnswers.size)
        randomizedAnswers.add(mutableAnswers[randomIndex])
        mutableAnswers.removeAt(randomIndex)
    }

    return randomizedAnswers
}


@Composable
fun ScorePage(score: Int, totalQuestions: Int, onRetry: () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(
                text = "Score final : $score/$totalQuestions",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(3f)
                    .align(Alignment.CenterHorizontally)
            )
            Button(
                onClick = onRetry,
                modifier = Modifier

                    .align(Alignment.CenterHorizontally)
            ) {
                Text("Rejouer")
            }
        }
    }
}

