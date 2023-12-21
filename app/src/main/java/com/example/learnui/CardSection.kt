package com.example.learnui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnui.ui.theme.BlueEnd
import com.example.learnui.ui.theme.BlueStart
import com.example.learnui.ui.theme.GreenEnd
import com.example.learnui.ui.theme.GreenStart
import com.example.learnui.ui.theme.OrangeEnd
import com.example.learnui.ui.theme.OrangeStart
import com.example.learnui.ui.theme.PurpleEnd
import com.example.learnui.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "8993 3332 5204 7219",
        cardName = "Business",
        balance = 445.633,
        color = getGradient(PurpleStart, PurpleEnd)
    ),

    Card(
        cardType = "VISA",
        cardNumber = "0078 0286 3446 7789",
        cardName = "Savings",
        balance = 4.89,
        color = getGradient(BlueStart, BlueEnd)
    ),

    Card(
        cardType = "VISA",
        cardNumber = "1111 3333 6778 1937",
        cardName = "School",
        balance = 36.33,
        color = getGradient(OrangeStart, OrangeEnd)
    ),

    Card(
        cardType = "MASTER CARD",
        cardNumber = "8993 3332 5204 7219",
        cardName = "Trips",
        balance = 426.48,
        color = getGradient(GreenStart, GreenEnd)
    )
)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview
@Composable
fun CardsSection(){
    LazyRow(){
        items(cards.size){index ->
            CardItem(index)

        }
    }
}

@Composable
fun CardItem(
    index: Int
){
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1){
        lastItemPaddingEnd = 16.dp
    }
    
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(modifier = Modifier
        .padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {  }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = "Card type",
                modifier = Modifier.width(60.dp))

            Spacer(Modifier.height(16.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview
@Composable
fun PreviewCardItem(){
    CardItem(index = 1)
}