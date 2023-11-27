package kr.ac.kumoh.ce.s20210734.s23w1203lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.s20210734.s23w1203lazylist.ui.theme.S23W1203LazyListTheme

data class Song(var title:String, var singer:String)
private val songs = mutableListOf<Song>()
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repeat(10) {
            songs.add(Song("Gods","뉴진스"))
            songs.add(Song("달빛소년","구자욱"))
            songs.add(Song("테스형","나훈아"))
        }
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    S23W1203LazyListTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyList()
        }
    }
}

@Composable
fun MyList() {
    //Column(Modifier.verticalScroll(rememberScrollState())) {//권장하지 않음
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        /*item {
        //    Text("노래 1")
        //}
        //item{
        //    Text("노래 2")
        }*/
        //items(30){
            //TextTitle("노래 $it")
        items(songs) { song ->
            Songitem(song)
        }
    }
}

@Composable
fun Songitem(song: Song) {
    Column(
        modifier= Modifier
            .fillMaxWidth()
            .background(Color(0xffffffcc))
            .padding(16.dp)//순서 확인 중요!!!
    ) {
        TextTitle("노래 ${song.title}")
        TextSinger("이 노래를 부른 가수는 ${song.singer} 입니다")
    }
}

@Composable
fun TextTitle(title: String) {
    Text(title, fontSize = 30.sp)
}

@Composable
fun TextSinger(title: String) {
    Text(title, fontSize = 20.sp)
}