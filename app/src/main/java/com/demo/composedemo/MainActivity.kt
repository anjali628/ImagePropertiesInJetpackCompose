package com.demo.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.composedemo.ui.theme.ComposeDemoTheme
import com.demo.composedemo.ui.theme.Purple200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TextContainer()
                }
            }
        }
    }
}

@Composable
fun SizeModifier(label: String, size: TextUnit) {
    Text(label, fontSize = size)
}

@Composable
fun ColorText() {
    Text("Color Text", color = Purple200)
}

@Composable
fun BoldText() {
    Text("Bold text", fontWeight = FontWeight.Bold)
}

@Composable
fun ItalicText() {
    Text("Italic Text", fontStyle = FontStyle.Italic)
}

@Composable
fun MaxLines() {
    Text("hello ".repeat(50), maxLines = 2)
}

@Composable
fun OverflowedText() {
    Text("Overflow text  ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
}

@Composable
fun SelectableText() {
    SelectionContainer {
        Text("This text is selectable")
    }
}

@Composable
fun TextContainer() {
    Column (horizontalAlignment = Alignment.Start, modifier = Modifier.padding(start = 20.dp)){
        SimpleImage()
        CircleImageView()
        RoundCornerImageView()
        ImageWithBackgroundColor()
        ImageWithTint()
        InsideFit()
      /*  SizeModifier("Big text", 40.sp)
        ColorText()
        BoldText()
        ItalicText()
        OverflowedText()
        SelectableText()
        MaxLines()*/

    }
}

val redTextStyle = TextStyle(color = Color.Red, fontSize = 30.sp)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Row {
        TextContainer()
    }
}
/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        //TextWithSize(label = "android__web", size = 20.sp )
                       // ColorText()
                        //SimpleRow()
                        //SimpleColumn()
                        //RowArrangement()
                       // ColumnArrangement()
                    }
                }
            }
        }
    }
}*/
/*
@Composable
fun ColorText() {
    Text("Color text", color = Color.Blue)
}

@Composable
fun TextWithSize(label : String, size : TextUnit) {
    Text(label, fontSize = size)
}*/

/*
@Composable
fun SimpleRow(){
    Row {
        Text(text = "Row Text 1",Modifier.background(Color.Red))
        Text(text = "Row Text 2",Modifier.background(Color.White))
        Text(text = "Row Text 3",Modifier.background(Color.Green))
    }
}
*/
/*
@Composable
fun RowArrangement(){
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement  =  Arrangement.SpaceEvenly) {
        Text(text = "Text 1",Modifier.background(Color.Red))
        Text(text = "Text 2",Modifier.background(Color.White))
        Text(text = "Text 3",Modifier.background(Color.Green))
    }
}*/
/*
@Composable
fun ColumnArrangement(){
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment  =  Alignment.End
    ) {
        Text(text = "Text 1",Modifier.background(Color.Red))
        Text(text = "Text 2",Modifier.background(Color.White))
        Text(text = "Text 3",Modifier.background(Color.Green))
    }
}*/

/*
@Composable
fun SimpleColumn(){
    Column {
        Text(text = "Column Text 1", Modifier.background(Color.Red))
        Text(text = "Column Text 2", Modifier.background(Color.White))
        Text(text = "Column Text 3", Modifier.background(Color.Green))
    }
}*/


@Composable
fun SimpleImage() {
    Image(
        painter = painterResource(id = R.drawable.nature),
        contentDescription = "Nature",
        modifier = Modifier
            //.fillMaxWidth()
            .padding(vertical = 20.dp)
    )
}

@Composable
fun CircleImageView() {
    Image(
        painter = painterResource(R.drawable.nature),
        contentDescription = "Circle Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape) // clip to the circle shape
            .border(5.dp, Color.Gray, CircleShape)//optional

    )
}

@Composable
fun RoundCornerImageView() {
    Image(
        painter = painterResource(R.drawable.nature),
        contentDescription = "Round corner image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .padding(vertical = 20.dp)
            .clip(RoundedCornerShape(10))
            .border(5.dp, Color.Gray, RoundedCornerShape(10))
    )
}

@Composable
fun ImageWithBackgroundColor() {
    Image(
        painter = painterResource(id = R.drawable.car_non_selected_image),
        contentDescription = "",
        modifier = Modifier
            .size(100.dp)
            .background(Color.DarkGray)
            .padding(vertical = 20.dp)
    )
}

@Composable
fun ImageWithTint() {
    Image(
        painter = painterResource(id = R.drawable.car_non_selected_image),
        contentDescription = "",
        colorFilter = ColorFilter.tint(Color.Red),
        modifier = Modifier
            .size(100.dp)
    )
}

@Composable
fun InsideFit() {
    Image(
        painter = painterResource(id = R.drawable.nature),
        contentDescription = "",
        modifier = Modifier
            .size(150.dp)
            .background(Color.LightGray),
        contentScale = ContentScale.Inside
    )
}