package ru.netology.nmedia

import ru.netology.nmedia.dto.Post
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсива по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен -> http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likes = 999999,
            shared = 990,
            views = 3000,
            likedByMe = false
        )

        with(binding) {
            imageViewAvatar.setImageResource(R.drawable.ic_launcher_foreground)
            textViewAuthor.text = post.author
            textViewContent.text = post.content
            textViewDate.text = post.published
            textViewReposts.text = toCutTheNumber(post.shared)
            textViewViews.text = toCutTheNumber(post.views)
            textViewLikes.text = toCutTheNumber(post.likes)
            if (post.likedByMe) {
                imageViewLikes?.setImageResource(R.drawable.ic_baseline_favorite_24)
            }
            imageViewLikes?.setOnClickListener() {
                imageViewLikes.setImageResource(
                    if (!post.likedByMe) {
                        post.likes++
                        R.drawable.ic_baseline_favorite_24
                    }

                    else {
                        post.likes--
                        R.drawable.ic_twotone_favorite_border_24
                    }
                )
                post.likedByMe = !post.likedByMe
                textViewLikes.text = toCutTheNumber(post.likes)
            }
            imageViewReposts.setOnClickListener() {
                post.shared++
                if (post.shared % 10 == 0) {
                    textViewReposts.text = toCutTheNumber(post.shared)
                }
            }
        }
    }
}