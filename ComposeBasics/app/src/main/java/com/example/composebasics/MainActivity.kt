package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    ComposeArticle(
//                        title = getString(R.string.title),
//                        para1 = getString(R.string.para1),
//                        para2 = getString(R.string.para2)
//                    )
//                    TaskManager(
//                        str1 = getString(R.string.all_task_completed),
//                        str2 = getString(R.string.nice_work)
//                    )
                    Quadrants()
                }
            }
        }
    }
}

@Composable
fun ComposeArticle(title: String, para1: String, para2: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = para1,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        Text(
            text = para2,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun TaskManager(str1: String, str2: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = str1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = str2,
            fontSize = 16.sp,
            modifier = Modifier
        )
    }
}

@Composable
fun Quadrants(modifier: Modifier = Modifier) {
    Column {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            QuadrantCard(
                color = Color(0xFFEADDFF),
                title = stringResource(id = R.string.first_title),
                detail = stringResource(id = R.string.first_detail),
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                color = Color(0xFFD0BCFF),
                title = stringResource(id = R.string.second_title),
                detail = stringResource(id = R.string.second_detail),
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.weight(1f)
        ){
            QuadrantCard(
                color = Color(0xFFB69DF8),
                title = stringResource(id = R.string.third_title),
                detail = stringResource(id = R.string.third_detail),
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                color = Color(0xFFF6EDFF),
                title = stringResource(id = R.string.forth_title),
                detail = stringResource(id = R.string.forth_detail),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantCard(color: Color, title: String, detail: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = detail,
            color = Color.Black,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicsTheme {
//        ComposeArticle(
//            title = "Title Here",
//            para1 = "ParaGraph1",
//            para2 = "Paragraph2"
//        )

//        TaskManager(
//            str1 = "All tasks completed",
//            str2 = "Nice work!"
//        )
        Quadrants()

    }
}